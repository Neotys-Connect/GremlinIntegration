package com.neotys.gremlin.common;

import com.neotys.action.argument.ArgumentValidator;
import com.neotys.action.argument.DefaultArgumentValidator;
import com.neotys.action.argument.Option;
import com.neotys.extensions.action.ActionParameter;

import static com.neotys.action.argument.DefaultArgumentValidator.INTEGER_VALIDATOR;
import static com.neotys.action.argument.DefaultArgumentValidator.NON_EMPTY;
import static com.neotys.action.argument.Option.AppearsByDefault.True;
import static com.neotys.action.argument.Option.OptionalRequired.Optional;
import static com.neotys.action.argument.Option.OptionalRequired.Required;
import static com.neotys.extensions.action.ActionParameter.Type;


enum GremlinCommonOption implements GremlinOption  {

    GremlinToken("GremlinToken", Required, True, Type.TEXT,
            "Gremlin API Token",
            "Gremlin API Token",
            NON_EMPTY),
   GremlinTeamID("GremlinTeamID", Required, True, Type.TEXT,
            "Gremlin Team ID",
            "Gremlin  Team ID",
            NON_EMPTY),
    GremlinTargetType("GremlinTargetType", Required, True, Type.TEXT,
            "Type of target : hosts or containers",
            "Type of target : hosts or containers",
            NON_EMPTY),
    GremlinTargetTags("GremlinTargetHostTags", Required, True, Type.TEXT,
            "List of tags to select the host that will be target by the attack",
            "List of tags seperated by a , ",
            NON_EMPTY),
    GremlinTarget("GremlinTarget", Required, True, Type.TEXT,
            "percent or exact",
            "Select the target by Percent or exact",
            NON_EMPTY),
    GremlinTargetNumber("GremlinTargetNumber", Required, True, Type.TEXT,
            "Number of targets that would be impacted ",
                    "Number of targets that would be impacted ( in percentage or exact depends on the value the parameter GremlinTarget",
                  INTEGER_VALIDATOR);


    private final String name;
    private final OptionalRequired optionalRequired;
    private final AppearsByDefault appearsByDefault;
    private final ActionParameter.Type type;
    private final String defaultValue;
    private final String description;
    private final ArgumentValidator argumentValidator;

    GremlinCommonOption(final String name, final OptionalRequired optionalRequired,
                             final AppearsByDefault appearsByDefault,
                             final ActionParameter.Type type, final String defaultValue, final String description,
                             final ArgumentValidator argumentValidator) {
        this.name = name;
        this.optionalRequired = optionalRequired;
        this.appearsByDefault = appearsByDefault;
        this.type = type;
        this.defaultValue = defaultValue;
        this.description = description;
        this.argumentValidator = argumentValidator;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public OptionalRequired getOptionalRequired() {
        return optionalRequired;
    }

    @Override
    public AppearsByDefault getAppearsByDefault() {
        return appearsByDefault;
    }

    @Override
    public ActionParameter.Type getType() {
        return type;
    }

    @Override
    public String getDefaultValue() {
        return defaultValue;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public ArgumentValidator getArgumentValidator() {
        return argumentValidator;
    }

    @Override
    public String getShortname() {
        return null;
    }
}
