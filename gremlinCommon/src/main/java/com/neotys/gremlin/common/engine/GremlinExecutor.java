package com.neotys.gremlin.common.engine;

import com.gremlin.api.ApiGremlinClient;
import com.neotys.ascode.api.v3.client.ApiClient;
import com.neotys.extensions.action.engine.Context;
import com.neotys.gremlin.common.GremlinException;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static com.neotys.gremlin.common.engine.Constants.TASK_DELAY;

public class GremlinExecutor  {
    // private instance, so that it can be
    // accessed by only by getInstance() method
    private static ScheduledExecutorService executorService;
    private static GremlinSyncTask gremlinSyncAttackTask;
    private static GremlinSyncTask gremlinSyncScenarioTask;

    private GremlinExecutor( )
    {
        // private constructor
    }

    public static void stop()
    {
        getInstance().shutdown();
    }
    public static void addAttackTask(final ApiClient apiClient, final ApiGremlinClient gremlinClient, final String newId, Context context,String teamid) throws GremlinException {
        if (gremlinSyncAttackTask == null) {
            synchronized (GremlinExecutor.class) {
                if (gremlinSyncAttackTask == null) {
                    gremlinSyncAttackTask = new GremlinSyncTask(gremlinClient,apiClient,TaskType.ATTACK,context,teamid);
                    getInstance().scheduleWithFixedDelay(gremlinSyncAttackTask, 1, TASK_DELAY, TimeUnit.SECONDS);
                }
            }
        }
        gremlinSyncAttackTask.addId(newId);
    }

    public static void addScenarioTask(final ApiClient apiClient, final ApiGremlinClient gremlinClient, final String newId,Context context,String teamid) throws GremlinException {
        if (gremlinSyncScenarioTask == null) {
            synchronized (GremlinExecutor.class) {
                if (gremlinSyncScenarioTask == null) {
                    gremlinSyncScenarioTask = new GremlinSyncTask( gremlinClient,apiClient,TaskType.SCENARIO,context,teamid);
                    getInstance().scheduleWithFixedDelay(gremlinSyncScenarioTask, 1, TASK_DELAY, TimeUnit.SECONDS);
                }
            }
        }
        gremlinSyncScenarioTask.addId(newId);
    }

    public static ScheduledExecutorService getInstance()
    {
        if (executorService == null)
        {
            //synchronized block to remove overhead
            synchronized (GremlinExecutor.class)
            {
                if(executorService==null)
                {
                    // if instance is null, initialize
                    executorService =  Executors.newSingleThreadScheduledExecutor();
                }

            }
        }
        return executorService;
    }


}
