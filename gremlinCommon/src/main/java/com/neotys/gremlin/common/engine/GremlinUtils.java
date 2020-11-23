package com.neotys.gremlin.common.engine;


import com.gremlin.api.ApiGremlinException;
import com.gremlin.api.api.AttacksApi;
import com.gremlin.api.api.MetricsApi;
import com.gremlin.api.api.ScenariosApi;
import com.gremlin.api.model.*;
import com.neotys.ascode.api.v3.client.ApiClient;
import com.neotys.ascode.api.v3.client.ApiException;
import com.neotys.ascode.api.v3.client.api.ResultsApi;
import com.neotys.ascode.api.v3.client.model.*;
import com.neotys.gremlin.common.GremlinException;
import com.neotys.gremlin.common.GremlinMetriException;
import com.neotys.gremlin.common.datamodel.NeoLoadEvent;
import com.neotys.gremlin.common.datamodel.NeoLoadMetric;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static com.neotys.gremlin.common.engine.Constants.NOTSTARTED;
import static com.neotys.gremlin.common.engine.Constants.STATEWITHEND;
import static com.neotys.gremlin.common.engine.Constants.SUCESSFUL;

public class GremlinUtils {

   private static String gettaskDEtailURlFromScenario(String guid, String scenarioid,String runnumber)
   {
      return String.format("https://app.gremlin.com/scenarios/detail/%s/runs/%s/steps/%s",scenarioid,runnumber,guid);
   }


   private static String gettaskDetailURLFromAttack(String guid)
   {
       return String.format("https://app.gremlin.com/attacks/%s",guid);
   }
    public static List<NeoLoadEvent> getScenarioRunDetail(String scenariouid, Long runid, String teamid, ScenariosApi scenariosApi) throws GremlinException {
        try {
            ScenarioRunResponse scenarioRunResponse = scenariosApi.getScenarioRun(scenariouid, runid, teamid);
            List<NeoLoadEvent> neoLoadEventList=new ArrayList<>();

            scenarioRunResponse.getGraph().getNodes().forEach((s, graphNode) -> {
                if(graphNode.getType().equals(GraphNode.TypeEnum.INFRAATTACK))
                {
                   if(!graphNode.getState().getLifecycle().equalsIgnoreCase(NOTSTARTED))
                    {
                        AttackNode attackNode=(AttackNode) graphNode;
                        NeoLoadEvent neoLoadEvent=new NeoLoadEvent(attackNode.getGuid(),attackNode.getTargetDefinition(),attackNode.getImpactDefinition(),gettaskDEtailURlFromScenario(graphNode.getGuid(),scenariouid,runid.toString()),graphNode.getState().getTask_summary().getStart_time().getValue());

                        if(graphNode.getState().getTask_summary().getStage().equalsIgnoreCase(SUCESSFUL))
                            neoLoadEvent.setEndtime(graphNode.getState().getTask_summary().getEnd_time().getValue());


                        neoLoadEventList.add(neoLoadEvent);

                    }
                }
            });

            return neoLoadEventList;
        }
        catch (ApiGremlinException e)
        {
            throw new GremlinException("APiExecption to get run run detail "+ e.getResponseBody());
        }
    }

    public static String updateNeoLoadEvent(ApiClient apiClient,String eventid,NeoLoadEvent event,String workspaceid,String testid) throws GremlinException {
        try
        {
            ResultsApi resultsApi=new ResultsApi(apiClient);
            PatchCustomEventRequest patchCustomEventRequest=new PatchCustomEventRequest();
            patchCustomEventRequest.setEndTimestamp(new BigDecimal(event.getEndtime()));
            patchCustomEventRequest.setUrl(event.getUrl());
            PatchCustomEventResponse response=resultsApi.patchTestResultCustomEvent(patchCustomEventRequest,workspaceid,testid,eventid);
            return response.getId();
        }
        catch (ApiException e)
        {
            throw new GremlinException("Issue When Updating the event - API Exception "+e.getResponseBody());
        }
    }

    public static NeoLoadEvent getAttackDetail(String attackid, String teamid, AttacksApi attacksApi) throws GremlinException {
        try {
            Task task = attacksApi.get(attackid,teamid);

            if(!task.getStage().equals(Task.StageEnum.PENDING)) {
                ///Status with end event
                NeoLoadEvent neoLoadEvent = new NeoLoadEvent(task.getGuid(), task.getCommand(), task.getTarget(), gettaskDetailURLFromAttack(task.getGuid()), task.getStartTime());

                if (Arrays.asList(STATEWITHEND).contains(task.getStage()))
                    neoLoadEvent.setEndtime(task.getEndTime());

                return neoLoadEvent;
            }
            else
                return null;

        }
        catch (ApiGremlinException e)
        {
            throw new GremlinException("APiExecption to get run run detail "+ e.getResponseBody());
        }
    }

    public static String createNeoLoadEvent(NeoLoadEvent event, ApiClient apiClient,String workspaceid,String testid) throws GremlinException {
        try {

        ResultsApi resultsApi=new ResultsApi(apiClient);

        PostCustomEventResponse customEventResponse=resultsApi.postTestResultCustomEvent(event.topostCustomEventRequest(),workspaceid,testid);

        return customEventResponse.getId();
        }
        catch (ApiException e)
        {
            throw new GremlinException("Issue When Creating the event - API Exception "+e.getResponseBody());
        }
    }

    public static void sendGremlinMetricsToNl(ApiClient apiClient, String worspaceid, String testid, List<NeoLoadMetric> metriclist, long statTestTime) throws GremlinException {
        try {
            ResultsApi resultsApi = new ResultsApi(apiClient);
            MonitorPostRequest monitorPostRequest=new MonitorPostRequest();
            monitorPostRequest.setMonitors(metriclist.stream().map(metric -> {
                return metric.toCustomMonitor(statTestTime);
            }).collect(Collectors.toList()));

            if(monitorPostRequest.getMonitors().size()>0)
               resultsApi.postTestResultMonitors(monitorPostRequest,worspaceid,testid);
        }
        catch (ApiException e)
        {
            throw new GremlinException("Issue When sending metrics - API Exception "+e.getResponseBody());

        }

    }

    //#TODO create a methods that update the attack with the neoload url

    //#TODO create a method that update the task witht the neoload url

    public static List<NeoLoadMetric> getScenarioMetrics(String scenarioid, Long runNumber, String teamid,MetricsApi metricsApi) throws GremlinException {
        try {
            List<NeoLoadMetric> neoLoadMetricList=new ArrayList<>();
            List<TaskMetrics> taskMetricsList=metricsApi.getMetricsForScenarioRun(scenarioid,runNumber,teamid);
            taskMetricsList.forEach(taskMetrics -> {

                if(taskMetrics.getMetrics().getState().getValue().equalsIgnoreCase(AttackMetricsDisplayResponse.StateEnum.COMPLETE.getValue()))
                    taskMetrics.getMetrics().getMetricData().forEach((s, metricPoints) -> {

                            NeoLoadMetric neoLoadMetric=new NeoLoadMetric(taskMetrics.getMetrics().getInfraCommandType().getValue(),taskMetrics.getMetrics().getChartTitle(),s,metricPoints);
                            neoLoadMetricList.add(neoLoadMetric);
                    });
                });

            return neoLoadMetricList;

        } catch (ApiGremlinException e) {
            throw new GremlinException("GetMetrics apiexeption "+e.getResponseBody());
        }

    }




    public static List<NeoLoadMetric> getAttackMetrics(String guid,String teamid,MetricsApi metricsApi) throws GremlinException, GremlinMetriException {
        try {
            List<NeoLoadMetric> neoLoadMetricList=new ArrayList<>();
           AttackMetricsDisplayResponse attackMetricsDisplayResponse=metricsApi.getMetricsForAttack(guid,teamid);

            if(attackMetricsDisplayResponse.getState().getValue().equalsIgnoreCase(AttackMetricsDisplayResponse.StateEnum.COMPLETE.getValue()))
                attackMetricsDisplayResponse.getMetricData().forEach((s, metricPoints) -> {
                        NeoLoadMetric neoLoadMetric=new NeoLoadMetric(attackMetricsDisplayResponse.getInfraCommandType().getValue(),attackMetricsDisplayResponse.getChartTitle(),s,metricPoints);
                        neoLoadMetricList.add(neoLoadMetric);
                    });

            if(attackMetricsDisplayResponse.getState().getValue().equalsIgnoreCase(AttackMetricsDisplayResponse.StateEnum.DISABLED.getValue()))
                throw new GremlinMetriException("This Task has no metrics");

            return neoLoadMetricList;

        } catch (ApiGremlinException e) {
            throw new GremlinException("GetMetrics apiexeption "+e.getResponseBody());
        }

    }

    public static String getNotesFromResultStatistics(TestResultStatistics testResultStatistics) {
       StringBuilder notebuilder=new StringBuilder();
       notebuilder.append(testResultStatistics.getLastVirtualUserCount().toString()+" concurrent users during the attack \n");
       notebuilder.append(" Current statistics :\n"+ " \t hit/s:"+testResultStatistics.getLastRequestCountPerSecond().toString()+"\n");
       notebuilder.append(" \t average transaction duration (ms) : "+testResultStatistics.getLastTransactionDurationAverage().toString()+"\n");

       return notebuilder.toString();
    }
}
