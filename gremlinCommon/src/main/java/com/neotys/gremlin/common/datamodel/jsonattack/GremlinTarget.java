package com.neotys.gremlin.common.datamodel.jsonattack;

import com.gremlin.api.model.TaskTarget;

import java.util.ArrayList;
import java.util.List;

public class GremlinTarget {
    TaskTarget.TargetTypeEnum type;
    List<String> tags=new ArrayList<>();
    TargetSelectionTypeEnum selectionType;
    Integer numberOfSelection;

    public GremlinTarget(TaskTarget.TargetTypeEnum type, List<String> tags, TargetSelectionTypeEnum selectionType, Integer numberOfSelection) {
        this.type = type;
        this.tags = tags;
        this.selectionType = selectionType;
        this.numberOfSelection = numberOfSelection;
    }


    public TaskTarget.TargetTypeEnum getType() {
        return type;
    }

    public void setType(TaskTarget.TargetTypeEnum type) {
        this.type = type;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public TargetSelectionTypeEnum getSelectionType() {
        return selectionType;
    }

    public void setSelectionType(TargetSelectionTypeEnum selectionType) {
        this.selectionType = selectionType;
    }

    public Integer getNumberOfSelection() {
        return numberOfSelection;
    }

    public void setNumberOfSelection(Integer numberOfSelection) {
        this.numberOfSelection = numberOfSelection;
    }
}
