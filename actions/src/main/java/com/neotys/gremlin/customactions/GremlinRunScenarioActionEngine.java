package com.neotys.gremlin.customactions;

import com.google.common.base.Optional;
import com.neotys.action.result.ResultFactory;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.extensions.action.engine.ActionEngine;
import com.neotys.extensions.action.engine.Context;
import com.neotys.extensions.action.engine.Logger;
import com.neotys.extensions.action.engine.SampleResult;
import com.neotys.gremlin.common.engine.GremlinEngine;


import java.util.List;
import java.util.Map;

import static com.neotys.action.argument.Arguments.getArgumentLogString;
import static com.neotys.action.argument.Arguments.parseArguments;

import static com.neotys.gremlin.common.engine.Constants.GREMLIN_OBJECT_NAME;

public class GremlinRunScenarioActionEngine implements ActionEngine {


    private static final String STATUS_CODE_INVALID_PARAMETER = "NL-GREMLINSCENARIO_ACTION-01";
    private static final String STATUS_CODE_TECHNICAL_ERROR = "NL-GREMLINSCENARIO_ACTION-02";
    private static final String STATUS_CODE_BAD_CONTEXT = "NL-GREMLINSCENARIO_ACTION-03";
    private static final String NLWEB_VERSION ="v1" ;

    public SampleResult execute(Context context, List<ActionParameter> parameters) {
        final SampleResult sampleResult = new SampleResult();
        final StringBuilder requestBuilder = new StringBuilder();
        final StringBuilder responseBuilder = new StringBuilder();

        final Map<String, Optional<String>> parsedArgs;
        try {
            parsedArgs = parseArguments(parameters, GremlinRunScenarioOption.values());
        } catch (final IllegalArgumentException iae) {
            return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "Could not parse arguments: ", iae);
        }


        final Optional<String> gremlinTeamID=parsedArgs.get(GremlinRunScenarioOption.GremlinTeamID.getName());
        final String scenarioName = parsedArgs.get(GremlinRunScenarioOption.Scenario.getName()).get();
        final String gremlinToken = parsedArgs.get(GremlinRunScenarioOption.GremlinToken.getName()).get();


        final Logger logger = context.getLogger();
        if (logger.isDebugEnabled()) {
            logger.debug("Executing " + this.getClass().getName() + " with parameters: "
                    + getArgumentLogString(parsedArgs, GremlinRunScenarioOption.values()));
        }

        if(!gremlinTeamID.isPresent())
            return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "The Gremlin Teamid is requireds " );


        try {
            sampleResult.sampleStart();
            GremlinEngine gremlinEngine= (GremlinEngine) context.getCurrentVirtualUser().get(gremlinTeamID.get() + GREMLIN_OBJECT_NAME);
            if(gremlinEngine==null)
            {
                gremlinEngine=new GremlinEngine(gremlinToken,gremlinTeamID,context);

            }

            String response=gremlinEngine.runScenario(scenarioName);
            appendLineToStringBuilder(responseBuilder,response);
            sampleResult.sampleEnd();

            context.getCurrentVirtualUser().put(gremlinTeamID.get() + GREMLIN_OBJECT_NAME,gremlinEngine);

        }catch (Exception e) {
            return ResultFactory.newErrorResult(context, STATUS_CODE_TECHNICAL_ERROR, "HTtml Unit technical Error ", e);
        }


        sampleResult.setRequestContent(requestBuilder.toString());
        sampleResult.setResponseContent(responseBuilder.toString());


        return sampleResult;
    }

    private String getBasePath(final Context context) {
        final String webPlatformApiUrl = context.getWebPlatformApiUrl();
        final StringBuilder basePathBuilder = new StringBuilder(webPlatformApiUrl);
        if(!webPlatformApiUrl.endsWith("/")) {
            basePathBuilder.append("/");
        }
        basePathBuilder.append(NLWEB_VERSION + "/");
        return basePathBuilder.toString();
    }

    private void appendLineToStringBuilder(final StringBuilder sb, final String line) {
        sb.append(line).append("\n");
    }

    /**
     * This method allows to easily create an error result and log exception.
     */
    private static SampleResult getErrorResult(final Context context, final SampleResult result, final String errorMessage, final Exception exception) {
        result.setError(true);
        result.setStatusCode("NL-XRAY_ERROR");
        result.setResponseContent(errorMessage);
        if (exception != null) {
            context.getLogger().error(errorMessage, exception);
        } else {
            context.getLogger().error(errorMessage);
        }
        return result;
    }

    @Override
    public void stopExecute() {
        // TODO add code executed when the test have to stop.

    }
}