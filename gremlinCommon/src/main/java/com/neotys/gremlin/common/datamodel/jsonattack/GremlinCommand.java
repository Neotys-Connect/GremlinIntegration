package com.neotys.gremlin.common.datamodel.jsonattack;

import com.gremlin.api.model.InfraCommand;

import java.util.ArrayList;
import java.util.List;

public class GremlinCommand {
    InfraCommand.InfraCommandTypeEnum commandType;
    List<String> args=new ArrayList<>();


    public GremlinCommand(InfraCommand.InfraCommandTypeEnum commandType, List<String> args) {
        this.commandType = commandType;
        this.args = args;
    }

    public InfraCommand.InfraCommandTypeEnum getCommandType() {
        return commandType;
    }

    public void setCommandType(InfraCommand.InfraCommandTypeEnum commandType) {
        this.commandType = commandType;
    }

    public List<String> getArgs() {
        return args;
    }

    public void setArgs(List<String> args) {
        this.args = args;
    }
}
