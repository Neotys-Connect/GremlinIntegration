package com.neotys.gremlin.customactions;

import com.neotys.action.argument.ArgumentValidator;
import com.neotys.action.argument.Option;
import com.neotys.extensions.action.ActionParameter;

import static com.neotys.action.argument.DefaultArgumentValidator.NON_EMPTY;
import static com.neotys.action.argument.Option.AppearsByDefault.True;
import static com.neotys.action.argument.Option.OptionalRequired.Required;
import static com.neotys.extensions.action.ActionParameter.Type.TEXT;

enum GremlinAttackFromJsonOption implements Option {
    GremlinToken("GremlinToken", Required, True, TEXT,
            "Gremlin API Token",
                    "Gremlin API Token",
                 NON_EMPTY),
    GremlinJsonAttackFile("GremlinJsonAttackFile", Required, True, TEXT,
            "Path to your json Attack File",
            "Path to your json Attack File",
            NON_EMPTY),
    GremlinTeamID("GremlinTeamID", Required, True, TEXT,
            "Gremlin Team ID",
                    "Gremlin Team ID",
                  NON_EMPTY);

    private final String name;
    private final OptionalRequired optionalRequired;
    private final AppearsByDefault appearsByDefault;
    private final ActionParameter.Type type;
    private final String defaultValue;
    private final String description;
    private final ArgumentValidator argumentValidator;

    GremlinAttackFromJsonOption(final String name, final OptionalRequired optionalRequired,
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
}
