package com.neotys.gremlin.common.datamodel;

import com.neotys.ascode.api.v3.client.model.CustomMonitorValuesInner;

public class MetricValue {
    long timestamp;
    double value;


    public MetricValue(long timestamp, double value) {
        this.timestamp = timestamp/1000;
        this.value = value;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public CustomMonitorValuesInner toCustomMonitorValuesInner()
    {
        CustomMonitorValuesInner customMonitorValuesInner=new CustomMonitorValuesInner();
        customMonitorValuesInner.setTimestamp(getTimestamp());
        customMonitorValuesInner.setValue(new Float(getValue()));

        return customMonitorValuesInner;
    }

}
