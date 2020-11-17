package com.gremlin.api.model;

import com.google.gson.annotations.SerializedName;

public class ImpactDefinition {
    @SerializedName("infra_command_type")
    public String infra_command_type;
    @SerializedName("infra_command_args")
    public InfraCommandArgs infra_command_args;

    public String getInfra_command_type() {
        return infra_command_type;
    }

    public void setInfra_command_type(String infra_command_type) {
        this.infra_command_type = infra_command_type;
    }

    public InfraCommandArgs getInfra_command_args() {
        return infra_command_args;
    }

    public void setInfra_command_args(InfraCommandArgs infra_command_args) {
        this.infra_command_args = infra_command_args;
    }
}
