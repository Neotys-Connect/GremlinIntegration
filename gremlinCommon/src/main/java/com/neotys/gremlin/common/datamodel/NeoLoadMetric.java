package com.neotys.gremlin.common.datamodel;

import com.gremlin.api.model.MetricPoint;
import com.neotys.ascode.api.v3.client.model.CustomMonitor;
import com.neotys.ascode.api.v3.client.model.CustomMonitorValues;
import com.neotys.ascode.api.v3.client.model.MonitorPostRequest;

import java.util.ArrayList;
import java.util.List;

import static com.neotys.gremlin.common.engine.Constants.GREMLINSOURCE;

public class NeoLoadMetric {
    private String command_type;
    private String metricname;
    private String node;
    List<MetricValue> metricValueList;



    public NeoLoadMetric(String value, String chartTitle, String node, List<MetricPoint> metricPoints) {
        this.command_type=value;
        this.metricname=chartTitle;
        this.node=node;
        this.metricValueList=new ArrayList<>();
        metricPoints.forEach(metricPoint -> {
            metricValueList.add(new MetricValue(metricPoint.getTimestamp(),metricPoint.getValue()));
        });
    }

    public CustomMonitor toCustomMonitor(long statTestTime)
    {
        CustomMonitor customMonitorList=new CustomMonitor();
        CustomMonitor customMonitor=new CustomMonitor();
        customMonitor.addPathItem(GREMLINSOURCE);
        customMonitor.addPathItem(getCommand_type());
        customMonitor.addPathItem(getNode());
        customMonitor.addPathItem(getMetricname());
        customMonitor.setUnit(null);
        customMonitor.setName(getMetricname());
        CustomMonitorValues monitorValues=new CustomMonitorValues();
        metricValueList.stream().forEach(metricValue -> {
            if(metricValue.getTimestamp()>=statTestTime/1000)
                   monitorValues.add(metricValue.toCustomMonitorValuesInner());
        });

        customMonitor.setValues(monitorValues);

        return customMonitor;

    }

    public String getCommand_type() {
        return command_type;
    }

    public void setCommand_type(String command_type) {
        this.command_type = command_type;
    }

    public String getMetricname() {
        return metricname;
    }

    public void setMetricname(String metricname) {
        this.metricname = metricname;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public List<MetricValue> getMetricValueList() {
        return metricValueList;
    }

    public void setMetricValueList(List<MetricValue> metricValueList) {
        this.metricValueList = metricValueList;
    }
}
