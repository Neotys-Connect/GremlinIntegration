package com.neotys.gremlin.common;

import com.google.common.base.Optional;
import com.neotys.action.result.ResultFactory;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.extensions.action.engine.ActionEngine;
import com.neotys.extensions.action.engine.Context;
import com.neotys.extensions.action.engine.SampleResult;
import com.neotys.gremlin.common.engine.GremlinEngine;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.neotys.action.argument.Arguments.parseArguments;
import static com.neotys.gremlin.common.engine.Constants.GREMLIN_OBJECT_NAME;

public abstract class GremlinActionEngine implements ActionEngine {

    private static final String EXACT="exact";
    private static final String PERCENT="percent";
    private static String command;
    private static String commandType;

    public  GremlinOption getOptionfromName(String name)
    {
        java.util.Optional<GremlinOption> gremlinOptionOptional=Arrays.stream(getAllOptions()).filter(option -> option.getName().equalsIgnoreCase(name)).findFirst();
        if(gremlinOptionOptional.isPresent())
            return gremlinOptionOptional.get();
        else
            return null;
    }

    public abstract String getCommand();
    public abstract String getCommandType();

    public abstract GremlinOption[] getOptions();

    public abstract String getInvalidParameterCode();

    public GremlinOption[] getAllOptions()
    {
        return Stream.concat(Arrays.stream(GremlinCommonOption.values()), Arrays.stream(getOptions())) .toArray(GremlinOption[]::new);
    }

    @Override
    public SampleResult execute(Context context, List<ActionParameter> list) {
        final SampleResult sampleResult = new SampleResult();
        final StringBuilder requestBuilder = new StringBuilder();
        final StringBuilder responseBuilder = new StringBuilder();

        final Map<String, Optional<String>> parsedArgs;
        try {
            parsedArgs = parseArguments(list, getOptions());
        } catch (final IllegalArgumentException iae) {
            return ResultFactory.newErrorResult(context, getInvalidParameterCode(), "Could not parse arguments: ", iae);
        }

        List<GremlinParameter> gremlinParameters=parsedArgs.entrySet().stream().map(e->{
            GremlinOption gremlinOption=getOptionfromName(e.getKey());
            if(gremlinOption!=null) {
                if(gremlinOption.getShortname()!=null && e.getValue().isPresent())
                  return new GremlinParameter(e.getKey(), gremlinOption.getShortname(), e.getValue());
            }
            return null;
        }).filter(gremlinParameter -> gremlinParameter!=null).collect(Collectors.toList());

        final String gremlinToken=parsedArgs.get(GremlinCommonOption.GremlinToken.getName()).get();
        final String gremlinTeamId = parsedArgs.get(GremlinCommonOption.GremlinTeamID.getName()).get();
        final String gremlintags = parsedArgs.get(GremlinCommonOption.GremlinTargetTags.getName()).get();
        final String gremlinTargetType=parsedArgs.get(GremlinCommonOption.GremlinTargetType.getName()).get();
        final String gremlintarget=parsedArgs.get(GremlinCommonOption.GremlinTarget.getName()).get();

        final String gremlinTargetNumber=parsedArgs.get(GremlinCommonOption.GremlinTargetNumber.getName()).get();

        if(!gremlintarget.equalsIgnoreCase(EXACT)&&!gremlintarget.equalsIgnoreCase(PERCENT))
            return ResultFactory.newErrorResult(context, getInvalidParameterCode(), "Target can only be equal to exact or pecent: ");

        try {
            sampleResult.sampleStart();
            GremlinEngine engine = (GremlinEngine) context.getCurrentVirtualUser().get(gremlinTeamId + GREMLIN_OBJECT_NAME);
            if(engine==null)
            {
                engine=new GremlinEngine(gremlinToken,Optional.of(gremlinTeamId),context);
            }


            String response= engine.runAttack(gremlinParameters,gremlintags,gremlinTargetType,gremlintarget,Integer.parseInt(gremlinTargetNumber),getCommand(),getCommandType().toLowerCase());

            sampleResult.sampleEnd();
            context.getCurrentVirtualUser().put(gremlinTeamId + GREMLIN_OBJECT_NAME,engine);

            sampleResult.setResponseContent(response);
        }
        catch (GremlinException e)
        {
            context.getLogger().error("Technical Error",e);
            return getErrorResult(context, sampleResult,getInvalidParameterCode(), e);

        }

        return sampleResult;
    }

    @Override
    public void stopExecute() {

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


}
