package com.gremlin.api.model;

import com.google.gson.annotations.SerializedName;

public class TargetDefinition {
    @SerializedName("strategy_type")
    private String strategy_type;
    @SerializedName("target_type")
    private String target_type;
    @SerializedName("strategy")
    public Strategy strategy;
}
