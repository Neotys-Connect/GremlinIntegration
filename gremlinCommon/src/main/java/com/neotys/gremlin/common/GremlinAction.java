package com.neotys.gremlin.common;

import com.neotys.action.argument.Arguments;
import com.neotys.action.argument.Option;
import com.neotys.extensions.action.ActionParameter;


import java.util.ArrayList;
import java.util.List;

public abstract class GremlinAction implements GremlinCommonAction {
    @Override
    public boolean getDefaultIsHit() {
        return false;
    }

    @Override
    public List<ActionParameter> getDefaultActionParameters() {
        final List<ActionParameter> parameters =setdefaultParameters();

        parameters.addAll(getCustomActionParameters());

        return parameters;
    }


    @Override
    public String getDescription() {
       StringBuilder description=new StringBuilder();
       description.append("Run a Choas Monkey engineering scenario defined in Gremlin.\n\n" + Arguments.getArgumentDescriptions(GremlinCommonOption.values()));

       description.append(getCustomArgsDescription());

       return description.toString();
    }

    private List<ActionParameter> setdefaultParameters()
    {
        final ArrayList<ActionParameter> parameters = new ArrayList<>();
        for (final GremlinCommonOption option : GremlinCommonOption.values()) {
            if (Option.AppearsByDefault.True.equals(option.getAppearsByDefault())) {
                parameters.add(new ActionParameter(option.getName(), option.getDefaultValue(),
                        option.getType()));
            }
        }


        return parameters;
    }
}
