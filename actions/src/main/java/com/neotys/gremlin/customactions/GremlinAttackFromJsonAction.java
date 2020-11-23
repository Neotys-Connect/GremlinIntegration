package com.neotys.gremlin.customactions;

import com.google.common.base.Optional;
import com.neotys.action.argument.Arguments;
import com.neotys.action.argument.Option;
import com.neotys.extensions.action.Action;
import com.neotys.extensions.action.ActionParameter;
import com.neotys.extensions.action.engine.ActionEngine;
import com.neotys.gremlin.common.GreminUtils;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class GremlinAttackFromJsonAction implements Action {
    private static final String BUNDLE_NAME = "com.neotys.gremlin.customactions.runJsonAttack.bundle";
    private static final String DISPLAY_NAME = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString("displayName");
    private static final String DISPLAY_PATH = ResourceBundle.getBundle(BUNDLE_NAME, Locale.getDefault()).getString("displayPath");

    @Override
    public String getType() {
        return "RunJsonAttack";
    }

    @Override
    public List<ActionParameter> getDefaultActionParameters() {
        final ArrayList<ActionParameter> parameters = new ArrayList<>();

        for (final GremlinAttackFromJsonOption option : GremlinAttackFromJsonOption.values()) {
            if (Option.AppearsByDefault.True.equals(option.getAppearsByDefault())) {
                parameters.add(new ActionParameter(option.getName(), option.getDefaultValue(),
                        option.getType()));
            }
        }

        return parameters;
    }

    @Override
    public Class<? extends ActionEngine> getEngineClass() {
        return GremlinAttackFromJsonActionEgine.class;
    }

    @Override
    public Icon getIcon() {
        // TODO Add an icon
        return GreminUtils.getGremlinIcon();
    }

    @Override
    public boolean getDefaultIsHit() {
        return false;
    }

    @Override
    public String getDescription() {
        return "Run a Choas Monkey engineering Attack defined in json file.\n\n" + Arguments.getArgumentDescriptions(GremlinAttackFromJsonOption.values());

    }

    @Override
    public String getDisplayName() {
        return DISPLAY_NAME;
    }

    @Override
    public String getDisplayPath() {
        return DISPLAY_PATH;
    }

    @Override
    public Optional<String> getMinimumNeoLoadVersion() {
        return Optional.of("7.5");
    }

    @Override
    public Optional<String> getMaximumNeoLoadVersion() {
        return Optional.absent();
    }
}
