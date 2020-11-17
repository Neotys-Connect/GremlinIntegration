package com.neotys.gremlin.common;

import com.neotys.action.argument.Option;
import com.neotys.extensions.action.Action;
import com.neotys.extensions.action.ActionParameter;



import java.util.ArrayList;
import java.util.List;

public interface GremlinCommonAction extends Action {


    List<ActionParameter> getCustomActionParameters();

    String getCustomArgsDescription();

}
