package com.gremlin.api.model;

import com.google.gson.annotations.SerializedName;

public class TaskSummary {
    @SerializedName("total_clients")
    public int total_clients;
    @SerializedName("clients_metrics_enabled_count")
    public int clients_metrics_enabled_count;
    @SerializedName("start_time")
    public DateTime start_time;
    @SerializedName("end_time")
    public DateTime end_time;
    @SerializedName("stage")
    public String stage;
    @SerializedName("version")
    public int version;

    public int getTotal_clients() {
        return total_clients;
    }

    public void setTotal_clients(int total_clients) {
        this.total_clients = total_clients;
    }

    public int getClients_metrics_enabled_count() {
        return clients_metrics_enabled_count;
    }

    public void setClients_metrics_enabled_count(int clients_metrics_enabled_count) {
        this.clients_metrics_enabled_count = clients_metrics_enabled_count;
    }

    public DateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(DateTime start_time) {
        this.start_time = start_time;
    }

    public DateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(DateTime end_time) {
        this.end_time = end_time;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}