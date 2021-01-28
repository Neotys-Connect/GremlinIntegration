package com.neotys.gremlin.common.engine;

import com.google.common.base.Optional;


import com.gremlin.api.ApiGremlinClient;
import com.gremlin.api.ApiGremlinException;
import com.gremlin.api.api.AttacksApi;
import com.gremlin.api.api.ClientsApi;
import com.gremlin.api.api.MetricsApi;
import com.gremlin.api.api.ScenariosApi;
import com.gremlin.api.model.*;
import com.neotys.ascode.api.v3.client.ApiClient;
import com.neotys.ascode.api.v3.client.ApiException;
import com.neotys.ascode.api.v3.client.api.ResultsApi;
import com.neotys.ascode.api.v3.client.api.RuntimeApi;
import com.neotys.ascode.api.v3.client.model.ProjectDefinition;
import com.neotys.ascode.api.v3.client.model.TestDefinition;
import com.neotys.ascode.api.v3.client.model.TestResultDefinition;
import com.neotys.extensions.action.engine.Context;
import com.neotys.extensions.action.engine.Logger;
import com.neotys.gremlin.common.GremlinException;
import com.neotys.gremlin.common.GremlinParameter;
import com.neotys.gremlin.common.datamodel.jsonattack.AttackJson;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

import static com.neotys.gremlin.common.engine.Constants.*;


public class GremlinEngine {
    private String token;
    private ApiGremlinClient apiGremlinClient;
    private Optional<String> gremlinTeamID;
    private Logger logger;
    private String testcontext;
    private String nlApiKey;
    private ApiClient nlapiclient;
    private Context context;

    public GremlinEngine(String token, Optional<String> gremlinTeamID, Context context) throws GremlinException {
        this.token = token;
        this.testcontext=context.getProjectName()+"_"+context.getScenarioName();
        this.apiGremlinClient =new ApiGremlinClient();
        this.logger=context.getLogger();
        this.gremlinTeamID=gremlinTeamID;
        apiGremlinClient.setApiKey(token);
        apiGremlinClient.setApiKeyPrefix("Key");
        apiGremlinClient.setBasePath(GREMLIN_API_PROTOCOL+GREMLIN_API_HOST+GREMLIN_API_PATH);

        nlApiKey=context.getAccountToken();
        nlapiclient=new ApiClient();
        nlapiclient.setApiKey(nlApiKey);
        nlapiclient.setBasePath(getBasePath(context));

        String nlversion=getProjectVersion(context);
        apiGremlinClient.addDefaultHeader("X-GREMLIN-AGENT",new String("neotys/"+nlversion).toLowerCase());
        this.context=context;
    }

    private String getProjectVersion(Context context) throws GremlinException {
        ResultsApi resultsApi=new ResultsApi(nlapiclient);
        try {
            TestResultDefinition testDefinition=resultsApi.getTestResult(context.getWorkspaceId(),context.getTestId());
            String testid=testDefinition.getTestId();
            if(testid!=null)
            {
                RuntimeApi runtimeApi = new RuntimeApi(nlapiclient);
                ProjectDefinition projectdefinition = runtimeApi.readProjectMetadata(context.getWorkspaceId(), testid);
                return projectdefinition.getProjectVersion();
            }
            else
                return NL_DEFAULT_VERSION;
        } catch (ApiException e) {
           logger.error("API error while retrieving project version "+e.getResponseBody(),e);
           throw new GremlinException("API error while retrieving project version "+e.getResponseBody());
        }
    }
    private String getBasePath(final Context context) {
        final String webPlatformApiUrl = context.getWebPlatformApiUrl();
        final StringBuilder basePathBuilder = new StringBuilder(webPlatformApiUrl);
        context.getLogger().debug(context.getWebPlatformApiUrl());
        return basePathBuilder.toString();
    }

    public String getToken() {
        return token;
    }

    public String runAttack(List<GremlinParameter> gremlinParameterList,String gremlinTags,String gremlinTypeOfTarget,String gremlinTarget,int gremlinTargetNumber,String command,String commandType) throws GremlinException {
        try {
            AttacksApi attacksApi = new AttacksApi(apiGremlinClient);

            TaskInput taskInput = new TaskInput();
            //taskInput.setSource(TaskInput.SourceEnum.API);
            Map<String, String> annotation = new HashMap<>();
            annotation.put(NL_PROJECT, context.getProjectName());
            annotation.put(NL_SCENARIO, context.getScenarioName());
            annotation.put(NL_TESTNAME, context.getTestName());
            annotation.put(NL_URL, context.getWebPlatformRunningTestUrl());
            annotation.put(NL_URL, context.getWebPlatformRunningTestUrl());
            annotation.put(GREMLIN_ANNOTATION_METRICURL,context.getWebPlatformRunningTestUrl());
            taskInput.setAnnotations(annotation);

            HashMap<String, Object> target = new HashMap<>();
            target.put("type", RANDOM);
            HashMap<String, Object> targettype = new HashMap<>();
            if (gremlinTypeOfTarget.equalsIgnoreCase(Task.TargetTypeEnum.HOST.getValue())) {
                //--host----
                targettype.put("multiSelectTags", getTags(gremlinTags));
                target.put(Task.TargetTypeEnum.HOST.getValue().toLowerCase(), targettype);
            } else {
                if (gremlinTypeOfTarget.equalsIgnoreCase(Task.TargetTypeEnum.CONTAINER.getValue())) {
                    targettype.put("multiSelectTags", getTags(gremlinTags));
                    target.put(Task.TargetTypeEnum.CONTAINER.getValue().toLowerCase(), targettype);
                    //--containers----

                } else {
                    if (gremlinTypeOfTarget.equalsIgnoreCase(Task.TargetTypeEnum.KUBERNETES.getValue())) {
                        //--kubernetes----

                    }
                }
            }
            target.put(gremlinTarget.toLowerCase(), gremlinTargetNumber);
            taskInput.setTarget(target);
            Map<String, Object> commandline = new HashMap<>();
            commandline.put("type", commandType);
            commandline.put("commandType", command);
            List<String> args = new ArrayList<>();
            gremlinParameterList.stream().forEach(gremlinParameter -> {
                args.add(gremlinParameter.getShortname());
                if (gremlinParameter.getValue().isPresent())
                    args.add(gremlinParameter.getValue().get());
            });
            commandline.put("args", args.toArray());

            taskInput.setCommand(commandline);


            String attackid=attacksApi.create(gremlinTeamID.get(), taskInput);

            GremlinExecutor.addAttackTask(nlapiclient,apiGremlinClient,attackid,context,gremlinTeamID.get());

            return "Attack "+commandType +" created in Gremlin with the id "+attackid;

        }
        catch (GremlinException e)
        {
            logger.error("Gremlin exeption when creating the attack "+e.getMessage(),e);
            throw new GremlinException("Api exeption when creating the attack "+e.getMessage());
        }
        catch (ApiGremlinException e)
        {
            logger.error("Api exeption when creating the attack "+e.getResponseBody(),e);
            throw new GremlinException("Api exeption when creating the attack "+e.getResponseBody());
        }
    }


    public void setToken(String token) {
        this.token = token;
    }

    public String runScenario(String name) throws GremlinException {
        try {
            ScenariosApi scenariosApi=new  ScenariosApi(apiGremlinClient);
            String guid=getScenarioIDFromName(name,scenariosApi);
            if(guid==null)
                throw new GremlinException("Run Scenario execption - Unable to find the scenario "+name);
            else
            {
                String teamid=null;
                if(gremlinTeamID.isPresent())
                    teamid=gremlinTeamID.get();

                ScenarioRunInput scenarioRunInput=new ScenarioRunInput();
                scenarioRunInput.setHypothesis(testcontext);

                String runid=scenariosApi.runScenario(guid,teamid,scenarioRunInput);


                GremlinExecutor.addScenarioTask(nlapiclient,apiGremlinClient,guid+":"+runid,context,gremlinTeamID.get());

                return getRunDetail(scenariosApi,guid,runid,teamid);
            }
        } catch (GremlinException e) {
            logger.error("Run Scenario exeption strating the scenario",e);
        } catch (ApiGremlinException e) {
            logger.error("Error retrieving scenario - output api"+e.getResponseBody(),e);
            throw new GremlinException("Error retrieving scenario - output api");
        }

        return null;

    }

    public String getRunDetail(ScenariosApi scenariosApi,String scenarioID,String runnumber,String teamid) throws GremlinException {
        StringBuilder response=new StringBuilder();
        try {
            ScenarioRunResponse scenarioRunResponse=scenariosApi.getScenarioRun(scenarioID,new Long(runnumber),teamid);
            response.append("Scenario "+scenarioRunResponse.getName() + " has been launched "+"\n");
            scenarioRunResponse.getGraph().getNodes().forEach((s, graphNode) -> {
                if(graphNode.getType().equals(GraphNode.TypeEnum.INFRAATTACK)) {
                    AttackNode attackNode=(AttackNode) graphNode;
                    if(attackNode.getImpactDefinition().getInfraCommandType()!=null)
                        response.append(" - " + attackNode.getImpactDefinition().getInfraCommandType().getValue() + "\n");
                }
            });

            return response.toString();
        }
        catch (ApiGremlinException e)
        {
            logger.error("API Exeption on Gremlin "+e.getResponseBody(),e);
            throw new GremlinException("API Exeption on Gremlin "+e.getResponseBody());
        }
    }

    private HashMap<String,String[]> getTags(String tag)
    {
        HashMap<String,String[]> hashMap=new HashMap<>();
        if(tag.contains(","))
        {
            //case of several tags
            List<String> listofTags= Arrays.asList(tag.split(","));
            listofTags.stream().forEach(s -> {
                String[] strings=s.split(":");
                if(strings.length>0) {
                    String[] values = {strings[1]};
                    hashMap.put(strings[0], values);
                }
            });
        }
        else {
            String[] strings = tag.split(":");
            if(strings.length>0) {
                String[] values = {strings[1]};
                hashMap.put(strings[0], values);
            }
        }

        return hashMap;
    }

    private boolean containsTags(HashMap<String,String> tags, Map<String, String> clienttag)
    {
        AtomicBoolean result= new AtomicBoolean(false);
        clienttag.forEach((s, s2) -> {
            if(tags.containsKey(s))
            {
                if(tags.get(s).equalsIgnoreCase(s2))
                    result.set(true);
            }

        });

        return result.get();
    }



    public void stopExecution()
    {
        GremlinExecutor.stop();
    }

    private String getScenarioIDFromName(String name, ScenariosApi scenariosApi) throws GremlinException {
        try {


            List<ScenarioResponse> scenarioResponseList;
            if(gremlinTeamID.isPresent()) {
                    scenarioResponseList=scenariosApi.getRunnable(gremlinTeamID.get());
                          }
            else
                scenarioResponseList=scenariosApi.getRunnable(null);

            List<String> guidlist=scenarioResponseList.stream().filter(scenarioResponse -> scenarioResponse.getName().equalsIgnoreCase(name)).limit(1).map(scenarioResponse -> {return scenarioResponse.getGuid();}).collect(Collectors.toList());
            if(guidlist.size()>0)
                return guidlist.get(0);
            else
                return null;

        } catch (ApiGremlinException e) {
            logger.error("Error retrieving scenario - output api"+e.getResponseBody(),e);
            throw new GremlinException("Error retrieving scenario - output api");
        }
    }


    public String runJsonAttacks(AttackJson attackJson) throws GremlinException {

        AttacksApi attacksApi = new AttacksApi(apiGremlinClient);
        Map<String, String> annotation = new HashMap<>();
        annotation.put(NL_PROJECT, context.getProjectName());
        annotation.put(NL_SCENARIO, context.getScenarioName());
        annotation.put(NL_TESTNAME, context.getTestName());
        annotation.put(NL_URL, context.getWebPlatformRunningTestUrl());
        annotation.put(GREMLIN_ANNOTATION_METRICURL,context.getWebPlatformRunningTestUrl());

        StringBuilder response=new StringBuilder();
        StringBuilder error=new StringBuilder();
        attackJson.getGremlinAttack().stream().forEach(gremlinAttackAttack -> {


            try
            {
                if(gremlinAttackAttack.getGremlinCommand()!= null && gremlinAttackAttack.getGremlinTarget()!=null) {
                    TaskInput taskInput = new TaskInput();
                    taskInput.setSource(TaskInput.SourceEnum.API);
                    taskInput.setAnnotations(annotation);
                    HashMap<String, Object> target = new HashMap<>();
                    target.put("type", RANDOM);
                    HashMap<String, Object> targettype = new HashMap<>();
                    if (gremlinAttackAttack.getGremlinTarget().getType().getValue().equalsIgnoreCase(Task.TargetTypeEnum.HOST.getValue())) {
                        //--host----
                        targettype.put("multiSelectTags", getTags(gremlinAttackAttack.getGremlinTarget().getTags().stream().collect(Collectors.joining(","))));
                        target.put(Task.TargetTypeEnum.HOST.getValue().toLowerCase(), targettype);
                    } else {
                        if (gremlinAttackAttack.getGremlinTarget().getType().getValue().equalsIgnoreCase(Task.TargetTypeEnum.CONTAINER.getValue())) {
                            targettype.put("multiSelectTags", getTags(gremlinAttackAttack.getGremlinTarget().getTags().stream().collect(Collectors.joining(","))));
                            target.put(Task.TargetTypeEnum.CONTAINER.getValue().toLowerCase(), targettype);
                            //--containers----

                        } else {
                            if (gremlinAttackAttack.getGremlinTarget().getType().getValue().equalsIgnoreCase(Task.TargetTypeEnum.KUBERNETES.getValue())) {
                                //--kubernetes----

                            }
                        }
                    }
                    target.put(gremlinAttackAttack.getGremlinTarget().getSelectionType().getValue().toLowerCase(), gremlinAttackAttack.getGremlinTarget().getNumberOfSelection());
                    taskInput.setTarget(target);
                    Map<String, Object> commandline = new HashMap<>();
                    commandline.put("type", gremlinAttackAttack.getGremlinCommand().getCommandType().getValue().toLowerCase());
                    commandline.put("commandType", gremlinAttackAttack.getGremlinCommand().getCommandType().getValue().toUpperCase());

                    commandline.put("args", gremlinAttackAttack.getGremlinCommand().getArgs().toArray());

                    taskInput.setCommand(commandline);

                    String attackid = attacksApi.create(gremlinTeamID.get(), taskInput);

                    GremlinExecutor.addAttackTask(nlapiclient, apiGremlinClient, attackid, context, gremlinTeamID.get());

                    response.append(" Attack " + attackid + " " + gremlinAttackAttack.getGremlinCommand().getCommandType().getValue() + " has been launched \n");
                }
                else
                {
                    ///there must be a delay
                    if(gremlinAttackAttack.getDelay()!=null)
                    {
                        response.append("Delay before next attack "+ gremlinAttackAttack.getDelay().getDelay().toString()+"\n");
                        Thread.sleep(gremlinAttackAttack.getDelay().getDelay());
                    }
                }
            }
            catch (GremlinException e)
            {
                logger.error("Gremlin exeption when creating the attack "+e.getMessage(),e);
                error.append("Gremlin exeption when creating the attack "+e.getMessage());
            }
            catch (ApiGremlinException e)
            {
                logger.error("Api exeption when creating the attack "+e.getResponseBody(),e);
                error.append("Api exeption when creating the attack "+e.getResponseBody());

            } catch (InterruptedException e) {
                logger.error("Api exeption when creating the pause " +e.getMessage(),e);
                error.append("Api exeption when creating the pause " +e.getMessage());
            }

        });


        if(error.length()>0)
        {
            throw new GremlinException(error.toString());
        }

        return response.toString();

    }
}
