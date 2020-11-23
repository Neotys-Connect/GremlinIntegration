package com.neotys.gremlin.common.engine;

import com.gremlin.api.ApiGremlinClient;
import com.gremlin.api.ApiGremlinException;
import com.gremlin.api.api.AttacksApi;
import com.gremlin.api.api.MetricsApi;
import com.gremlin.api.api.ScenariosApi;
import com.neotys.ascode.api.v3.client.ApiClient;
import com.neotys.ascode.api.v3.client.ApiException;
import com.neotys.ascode.api.v3.client.api.ResultsApi;
import com.neotys.ascode.api.v3.client.model.TestResultDefinition;
import com.neotys.ascode.api.v3.client.model.TestResultStatistics;
import com.neotys.extensions.action.engine.Context;
import com.neotys.gremlin.common.GremlinException;
import com.neotys.gremlin.common.GremlinMetriException;
import com.neotys.gremlin.common.datamodel.EventSyncronized;
import com.neotys.gremlin.common.datamodel.NeoLoadEvent;
import com.neotys.gremlin.common.datamodel.NeoLoadMetric;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


public class GremlinSyncTask implements Runnable {

    private final List<String> idlists;
    private final String nlApiKey;
    private final String nlApiBaseURL;
    private final String workspaceid;
    private ApiClient apiClient;
    private TaskType taskType;
    private ApiGremlinClient gremlinClient;
    private String teamid;
    private String testid;
    private HashMap<String, EventSyncronized> taksID;
    private long statTestTime;
    private String neoloadTestUrl;

    public GremlinSyncTask(final ApiGremlinClient gremlinClient, final ApiClient nlapiclient, TaskType taskType, Context context,String teamid) throws GremlinException {
        this.apiClient = nlapiclient;
        this.gremlinClient = gremlinClient;
        this.taskType=taskType;
        this.idlists = new CopyOnWriteArrayList<>();
        nlApiKey=context.getAccountToken();
        nlApiBaseURL=context.getWebPlatformApiUrl();
        workspaceid=context.getWorkspaceId();
        testid=context.getTestId();
        this.teamid=teamid;
        this.taksID=new HashMap<>();
        statTestTime=getStatTestTime();
        neoloadTestUrl=context.getWebPlatformRunningTestUrl();
    }

    private long getStatTestTime() throws GremlinException {
       try {
           ResultsApi resultsApi=new ResultsApi(apiClient);
           TestResultDefinition testResultDefinition=resultsApi.getTestResult(workspaceid,testid);
           return testResultDefinition.getStartDate();
        } catch (ApiException e) {
           e.printStackTrace();
           throw new GremlinException("NL API Exception "+ e.getResponseBody());

        }
    }
    public void addId(final String id) {
        this.idlists.add(id);
    }

    public void removeId(final String id) {
        this.idlists.remove(id);
    }

    private void syncAttack()
    {
        idlists.stream().forEach(s -> {
            try {
                NeoLoadEvent event = GremlinUtils.getAttackDetail(s, teamid, new AttacksApi(gremlinClient));
                if(event!=null) {
                    if (taksID.containsKey(event.getGuid()))
                    {
                        EventSyncronized eventSyncronized=taksID.get(event.getGuid());
                        if(!eventSyncronized.isIsended()) {
                            if (event.getEndtime() > 0)
                            {
                                String neoloadeventid=GremlinUtils.updateNeoLoadEvent(apiClient,eventSyncronized.getEventid(),event,workspaceid,testid);
                                eventSyncronized.setIsended();
                                //--end time define
                                //#TODO update the event in neoload
                                try
                                {
                                    List<NeoLoadMetric> neoLoadMetricList=GremlinUtils.getAttackMetrics(event.getGuid(),teamid,new MetricsApi(gremlinClient));
                                    if(neoLoadMetricList.size()>0) {
                                        GremlinUtils.sendGremlinMetricsToNl(apiClient, workspaceid, testid, neoLoadMetricList,statTestTime);
                                        removeId(s);
                                    }
                                    else
                                        taksID.put(event.getGuid(),eventSyncronized);
                                }
                                catch (GremlinMetriException e)
                                {
                                    taksID.put(event.getGuid(),eventSyncronized);
                                    removeId(s);
                                }

                            }
                        }
                        else
                        {
                            try
                            {
                                List<NeoLoadMetric> neoLoadMetricList=GremlinUtils.getAttackMetrics(event.getGuid(),teamid,new MetricsApi(gremlinClient));
                                if(neoLoadMetricList.size()>0) {
                                    GremlinUtils.sendGremlinMetricsToNl(apiClient, workspaceid, testid, neoLoadMetricList,statTestTime);
                                    removeId(s);
                                }
                            }
                            catch (GremlinMetriException e)
                            {
                                removeId(s);
                            }

                        }
                        ///case to update
                    } else {
                        //#TODO creation of the neoload event
                        String neoloadeventid=GremlinUtils.createNeoLoadEvent(event,apiClient,workspaceid,testid);
                        EventSyncronized eventSyncronized=new EventSyncronized(neoloadeventid);
                        if(event.getEndtime()>0) {
                            eventSyncronized.setIsended();
                            //get the monitoring
                            try {
                                List<NeoLoadMetric> neoLoadMetricList = GremlinUtils.getAttackMetrics(s, teamid, new MetricsApi(gremlinClient));
                                if(neoLoadMetricList.size()>0) {
                                    GremlinUtils.sendGremlinMetricsToNl(apiClient, workspaceid, testid, neoLoadMetricList, statTestTime);
                                    removeId(s);
                                }
                            }
                            catch (GremlinMetriException e)
                            {
                                removeId(s);
                            }
                        }
                        taksID.put(event.getGuid(), new EventSyncronized(neoloadeventid));

                    }
                }
            }
            catch (GremlinException e)
            {
               removeId(s);
                e.printStackTrace();
            }
        });
    }

    private void updateAttack(String uuid) throws GremlinException {
        try
        {
            ResultsApi resultsApi=new ResultsApi(apiClient);
            TestResultStatistics testResultStatistics=resultsApi.getTestResultStatistics(workspaceid,testid);

            String notes=GremlinUtils.getNotesFromResultStatistics(testResultStatistics);

            AttacksApi attacksApi=new AttacksApi(gremlinClient);
        }
        catch (ApiException e)
        {
            e.printStackTrace();
            throw new GremlinException("NL API exeption while retrieving summary data on from the test result "+e.getResponseBody());
        }
       /* catch (ApiGremlinException e)
        {
            e.printStackTrace();
            throw new GremlinException("Gremlin API Exeption while upating the attack "+e.getResponseBody());
        }*/
    }

    public  void updateScenarioResultsNote(String scenarioid,String runnumber) throws GremlinException {
        try
        {
            ResultsApi resultsApi=new ResultsApi(apiClient);
            ScenariosApi scenariosApi=new ScenariosApi(gremlinClient);
            TestResultStatistics testResultStatistics=resultsApi.getTestResultStatistics(workspaceid,testid);
            String body=GremlinUtils.getNotesFromResultStatistics(testResultStatistics);
            body+="\n link to the NeoLoad test result : "+ neoloadTestUrl;
            scenariosApi.setScenarioRunResultNotes(scenarioid,new Long(runnumber),body,teamid);
        }
        catch(ApiGremlinException e)
        {
            e.printStackTrace();
            throw new GremlinException(" Unable to add notes to the scenario results "+ e.getResponseBody());
        }
         catch (ApiException e) {
            e.printStackTrace();
             throw new GremlinException(" Unable to get the neoload test statistics "+ e.getResponseBody());

         }
    }
    
    private void syncScenario()
    {
        idlists.stream().forEach(s -> {
            String[] ids=s.split(":");
            if(ids.length>0) {
                String scenarioid = ids[0];
                String runid=ids[1];
                try {
                    List<NeoLoadEvent> eventList = GremlinUtils.getScenarioRunDetail(scenarioid,new Long(runid), teamid, new ScenariosApi(gremlinClient));
                    eventList.stream().forEach(neoLoadEvent -> {

                        if(neoLoadEvent!=null) {
                            if (taksID.containsKey(neoLoadEvent.getGuid()))
                            {
                                EventSyncronized eventSyncronized=taksID.get(neoLoadEvent.getGuid());
                                if(!eventSyncronized.isIsended()) {
                                    if (neoLoadEvent.getEndtime() > 0) {
                                        //--end time define
                                        //#TODO update the event in neoload
                                        try {
                                            updateScenarioResultsNote(scenarioid,runid);
                                            GremlinUtils.updateNeoLoadEvent(apiClient, eventSyncronized.getEventid(), neoLoadEvent, workspaceid, testid);
                                            eventSyncronized.setIsended();
                                            taksID.put(neoLoadEvent.getGuid(), eventSyncronized);
                                            //Get the monitoring

                                            List<NeoLoadMetric> neoLoadMetricList=GremlinUtils.getScenarioMetrics(scenarioid,new Long(runid),teamid,new MetricsApi(gremlinClient));
                                            if(neoLoadMetricList.size()>0) {
                                                GremlinUtils.sendGremlinMetricsToNl(apiClient, workspaceid, testid, neoLoadMetricList,statTestTime);
                                                removeId(s);
                                            }


                                        }
                                        catch (GremlinException e)
                                        {
                                            e.printStackTrace();
                                        }

                                    }
                                }
                                else
                                {
                                    try {
                                        List<NeoLoadMetric> neoLoadMetricList = GremlinUtils.getScenarioMetrics(scenarioid, new Long(runid), teamid, new MetricsApi(gremlinClient));
                                        if (neoLoadMetricList.size() > 0) {
                                            GremlinUtils.sendGremlinMetricsToNl(apiClient, workspaceid, testid, neoLoadMetricList,statTestTime);
                                            removeId(s);
                                        }
                                    }
                                    catch (GremlinException e)
                                    {
                                        e.printStackTrace();
                                    }
                                }
                                ///case to update
                            } else {
                                //#TODO creation of the neoload event
                                try {
                                    String neoloadeventid=GremlinUtils.createNeoLoadEvent(neoLoadEvent, apiClient, workspaceid, testid);
                                    EventSyncronized eventSyncronized=new EventSyncronized(neoloadeventid);
                                    if(neoLoadEvent.getEndtime()>0)
                                    {
                                        updateScenarioResultsNote(scenarioid,runid);
                                        eventSyncronized.setIsended();
                                        //get the monitoring
                                        List<NeoLoadMetric> neoLoadMetricList=GremlinUtils.getScenarioMetrics(scenarioid,new Long(runid),teamid,new MetricsApi(gremlinClient));
                                        if(neoLoadMetricList.size()>0) {
                                            GremlinUtils.sendGremlinMetricsToNl(apiClient, workspaceid, testid, neoLoadMetricList, statTestTime);
                                            removeId(s);
                                        }
                                    }
                                    taksID.put(neoLoadEvent.getGuid(), new EventSyncronized(neoloadeventid));
                                }
                                catch (GremlinException e)
                                {
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                }
                catch (GremlinException e)
                {
                    idlists.remove(s);
                    e.printStackTrace();
                }

            }
            else
            {
                System.out.println("The id does not macht the right format");
                removeId(s);
            }
        });
    }

    public boolean isTestRunning()
    {
        ResultsApi resultsApi=new ResultsApi(apiClient);
        boolean result=false;
        try {
            TestResultDefinition testResultDefinition=resultsApi.getTestResult(workspaceid,testid);
            if(testResultDefinition.getStatus().getValue().equalsIgnoreCase(TestResultDefinition.StatusEnum.RUNNING.getValue())||testResultDefinition.getStatus().getValue().equalsIgnoreCase(TestResultDefinition.StatusEnum.INIT.getValue()))
                return true;
        } catch (ApiException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void run() {
        if(isTestRunning())
        {
            if (taskType.equals(TaskType.ATTACK)) {
                syncAttack();
            } else {
                syncScenario();
            }
        }
        else
        {
        //synchronized block to remove overhead
            synchronized (GremlinExecutor.class)
            {
                    // if instance is null, initialize
                ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
                executorService.shutdown();
            }
        }

    }
}
