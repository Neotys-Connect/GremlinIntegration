package com.neotys.gremlin.common.engine;

import com.gremlin.api.model.Strategy;
import com.gremlin.api.model.Task;

import java.util.Arrays;

public class Constants {

    public static final String GREMLIN_API_HOST="api.gremlin.com";
    public static final String GREMLIN_API_PATH="/v1";
    public static final String GREMLIN_OBJECT_NAME="GremlinEgine";
    public static final String GREMLIN_API_PROTOCOL="https://";
    public static final String NLWEB_VERSION="v3";
    public static final int TASK_DELAY=5;
    public static final String NL_PROJECT="Neoload_Project";
    public static final String NL_SCENARIO="Neoload_Scenario";
    public static final String NL_TESTNAME="Neoload_TestName";
    public static final String NL_URL="Neoload_Test_Result_URL";
    public static final String GREMLIN_ANNOTATION_METRICURL="metrics";
    public static final String GREMLIN_ANNOTATION_NOTES="notes";
    public static final String NL_DEFAULT_VERSION="7.6";
    public static final String NOTSTARTED="NotStarted";
    public static final String GREMLINSOURCE="Gremlin";
    public static final String SUCESSFUL="Successful";

    public static final String RANDOM="Random";
    public static final String CONTAINER="containers";
    public static final String HOST="hosts";

    public static final Task.StageEnum[] STATEWITHEND ={
        Task.StageEnum.TARGETNOTFOUND,Task.StageEnum.INVALIDARGUMENT,Task.StageEnum.SUCCESSFUL,Task.StageEnum.USERHALTED,Task.StageEnum.CLIENTABORTED,Task.StageEnum.LOSTCOMMUNICATION,Task.StageEnum.INITIALIZATIONFAILED,Task.StageEnum.TEARDOWNFAILED,Task.StageEnum.HALTFAILED,Task.StageEnum.FAILED,Task.StageEnum.HALT};
}
