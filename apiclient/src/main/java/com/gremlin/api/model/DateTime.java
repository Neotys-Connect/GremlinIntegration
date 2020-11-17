package com.gremlin.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class DateTime {
    @SerializedName("value")
    public Date value;

    public Date getValue() {
        return value;
    }

    public void setValue(Date value) {
        this.value = value;
    }
}
