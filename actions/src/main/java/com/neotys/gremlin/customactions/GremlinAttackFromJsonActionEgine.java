package com.neotys.gremlin.customactions;

import com.google.common.base.Optional;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.JsonReader;
import com.neotys.action.result.ResultFactory;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.extensions.action.engine.ActionEngine;
import com.neotys.extensions.action.engine.Context;
import com.neotys.extensions.action.engine.Logger;
import com.neotys.extensions.action.engine.SampleResult;
import com.neotys.gremlin.common.GremlinException;
import com.neotys.gremlin.common.engine.GremlinEngine;
import com.neotys.gremlin.common.datamodel.jsonattack.AttackJson;
import net.dongliu.gson.GsonJava8TypeAdapterFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Map;

import static com.neotys.action.argument.Arguments.getArgumentLogString;
import static com.neotys.action.argument.Arguments.parseArguments;
import static com.neotys.gremlin.common.engine.Constants.GREMLIN_OBJECT_NAME;

public class GremlinAttackFromJsonActionEgine  implements ActionEngine {


    private static final String STATUS_CODE_INVALID_PARAMETER = "NL-GREMLINJSONATTACK_ACTION-01";
    private static final String STATUS_CODE_TECHNICAL_ERROR = "NL-GREMLINJSONATTACK_ACTION-02";
    private static final String STATUS_CODE_BAD_CONTEXT = "NL-GREMLINJSONATTACK_ACTION-03";
    private static final String NLWEB_VERSION ="v3" ;

    public SampleResult execute(Context context, List<ActionParameter> parameters) {
        final SampleResult sampleResult = new SampleResult();
        final StringBuilder requestBuilder = new StringBuilder();
        final StringBuilder responseBuilder = new StringBuilder();

        final Map<String, Optional<String>> parsedArgs;
        try {
            parsedArgs = parseArguments(parameters, GremlinAttackFromJsonOption.values());
        } catch (final IllegalArgumentException iae) {
            return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "Could not parse arguments: ", iae);
        }


        final Optional<String> gremlinTeamID=parsedArgs.get(GremlinAttackFromJsonOption.GremlinTeamID.getName());
        final String jsonpath = parsedArgs.get(GremlinAttackFromJsonOption.GremlinJsonAttackFile.getName()).get();
        final String gremlinToken = parsedArgs.get(GremlinAttackFromJsonOption.GremlinToken.getName()).get();


        final Logger logger = context.getLogger();
        if (logger.isDebugEnabled()) {
            logger.debug("Executing " + this.getClass().getName() + " with parameters: "
                    + getArgumentLogString(parsedArgs, GremlinAttackFromJsonOption.values()));
        }

        if(!gremlinTeamID.isPresent())
            return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "The Gremlin Teamid is requireds " );

        File jsonfile=new File(jsonpath);
        if(!jsonfile.exists())
        {
            return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "The Gremlin json file doesn't not exists" );



        }


        try {

            AttackJson attackJson;
            Gson gson = new GsonBuilder().registerTypeAdapterFactory(new GsonJava8TypeAdapterFactory()).create();


            JsonReader reader = new JsonReader(new FileReader(jsonfile));
            attackJson = gson.fromJson(reader, AttackJson.class);

            String validate=attackJson.validateModel();
            if(!validate.isEmpty())
                return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "The Gremlin json has issues "+ validate );

            sampleResult.sampleStart();
            GremlinEngine gremlinEngine= (GremlinEngine) context.getCurrentVirtualUser().get(gremlinTeamID.get() + GREMLIN_OBJECT_NAME);
            if(gremlinEngine==null)
            {
                gremlinEngine=new GremlinEngine(gremlinToken,gremlinTeamID,context);

            }
            String response=gremlinEngine.runJsonAttacks(attackJson);
            appendLineToStringBuilder(responseBuilder,response);
            sampleResult.sampleEnd();

            context.getCurrentVirtualUser().put(gremlinTeamID.get() + GREMLIN_OBJECT_NAME,gremlinEngine);

        }catch (FileNotFoundException e) {
            return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "The Gremlin json file doesn't not exists" );

        }
        catch (JsonIOException e)
        {
            return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "The Gremlin json file is not on the correct format" +e.getMessage());

        }
        catch (JsonSyntaxException e)
        {
            return ResultFactory.newErrorResult(context, STATUS_CODE_INVALID_PARAMETER, "The Gremlin json file is not on the correct format" +e.getMessage());

        }
        catch (GremlinException e) {
            return ResultFactory.newErrorResult(context, STATUS_CODE_TECHNICAL_ERROR, "Technical Error while runing the attacks", e);
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
        result.setStatusCode("NL-GREMLIN_ERROR");
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