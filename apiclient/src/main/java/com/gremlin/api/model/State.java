package com.gremlin.api.model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class State {
        @SerializedName("task_id")
        public String task_id;
        @SerializedName("task_summary")
        public TaskSummary task_summary;
        @SerializedName("resolved_targets")
        public ResolvedTargets resolved_targets;
        @SerializedName("lifecycle")
        public String lifecycle;
        @SerializedName("start_time")
        public Date start_time;
         @SerializedName("end_time")
        public Date end_time;

    public String getTask_id() {
        return task_id;
    }

    public void setTask_id(String task_id) {
        this.task_id = task_id;
    }

    public TaskSummary getTask_summary() {
        return task_summary;
    }

    public void setTask_summary(TaskSummary task_summary) {
        this.task_summary = task_summary;
    }

    public ResolvedTargets getResolved_targets() {
        return resolved_targets;
    }

    public void setResolved_targets(ResolvedTargets resolved_targets) {
        this.resolved_targets = resolved_targets;
    }

    public String getLifecycle() {
        return lifecycle;
    }

    public void setLifecycle(String lifecycle) {
        this.lifecycle = lifecycle;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }
}
