package com.neotys.gremlin.common.datamodel;

import com.gremlin.api.model.*;
import com.neotys.ascode.api.v3.client.model.PostCustomEventRequest;
import com.neotys.gremlin.common.engine.TaskType;
import org.threeten.bp.OffsetDateTime;

import java.math.BigDecimal;
import java.util.Date;
import java.util.stream.Collectors;

import static com.neotys.gremlin.common.engine.Constants.GREMLINSOURCE;

public class NeoLoadEvent {
    String url;
    String description;
    String source;
    String code;
    String fullname;
    Long starttime;
    Long endtime=null;
    String guid;
    TaskType type;

    public NeoLoadEvent(String url, String description, String source, String code, String fullname, long starttime,TaskType type) {
        this.url = url;
        this.description = description;
        this.source = source;
        this.code = code;
        this.fullname = fullname;
        this.starttime = starttime;
        this.type=type;
    }

    public NeoLoadEvent(String guid, AttackTarget command, InfraCommand target, String url, Date startTime) {
        StringBuilder descriptionbuilder=new StringBuilder();

        descriptionbuilder.append("Attack "+target.getInfraCommandType().getValue()    +" on "  +   command.getTargetType().getValue()  );




        this.description=descriptionbuilder.toString();
        this.url=url;
        this.source=GREMLINSOURCE;
        this.code=  target.getInfraCommandType().getValue();
        this.starttime=new Long(startTime.getTime()/1000);
        this.fullname=GREMLINSOURCE +" attack "+target.getInfraCommandType().getValue();
        this.guid=guid;
        this.type=TaskType.SCENARIO;
    }

    public NeoLoadEvent(String guid, InfraCommand command, TaskTarget target, String gettaskDetailURLFromAttack, OffsetDateTime startTime) {
        StringBuilder descriptionbuilder=new StringBuilder();

        descriptionbuilder.append("Attack "+         command.getCommandType().getValue()+" ");

        if(target.getTargetType().getValue().equalsIgnoreCase(TaskTarget.TargetTypeEnum.HOST.getValue()))
            descriptionbuilder.append("on hosts "+target.getResolvedHosts().stream().collect(Collectors.joining(",")));

        if(target.getTargetType().getValue().equalsIgnoreCase(TaskTarget.TargetTypeEnum.CONTAINER.getValue()))
            target.getResolvedContainers().forEach((s, strings) -> {
                descriptionbuilder.append("on containers "+s+ " :"+strings.stream().collect(Collectors.joining(",")));
            } );

        this.description=descriptionbuilder.toString();
        this.url=gettaskDetailURLFromAttack;
        this.source=GREMLINSOURCE;

        this.code=  command.getCommandType().getValue();
        this.starttime=new Long(startTime.toEpochSecond());
        this.fullname=GREMLINSOURCE +" attack "+command.getCommandType().getValue();
        this.guid=guid;
        this.type=TaskType.ATTACK;
    }

    public String getUrl() {
        return url;
    }

    public NeoLoadEvent(String guid,TargetDefinition targetDefinition, ImpactDefinition impactDefinition, String url, Date stardate)
    {

        StringBuilder descriptionbuilder=new StringBuilder();

        descriptionbuilder.append("Attack "+         impactDefinition.getInfra_command_type() );

        if(targetDefinition.strategy.getHostIds()!=null)
            descriptionbuilder.append("on hosts "+targetDefinition.strategy.getHostIds().stream().collect(Collectors.joining(",")));

        if(targetDefinition.strategy.getContainerIds()!=null)
            descriptionbuilder.append("on containers "+targetDefinition.strategy.getContainerIds().stream().collect(Collectors.joining(",")));

        this.description=descriptionbuilder.toString();
        this.url=url;
        this.source=GREMLINSOURCE;

        this.code=  impactDefinition.getInfra_command_type();
        this.starttime=new Long(stardate.getTime()/1000);
        this.fullname=GREMLINSOURCE +" attack "+impactDefinition.getInfra_command_type();
        this.guid=guid;
        this.type=TaskType.SCENARIO;
    }


    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }

    public void setEndtime(Long endtime) {
        this.endtime = endtime;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public long getStarttime() {
        return starttime.longValue();
    }

    public void setStarttime(long starttime) {
        this.starttime = new Long(starttime);
    }

    public long getEndtime() {
        if(endtime!=null)
            return endtime.longValue();
        else
            return 0;
    }

    public PostCustomEventRequest topostCustomEventRequest()
    {
        PostCustomEventRequest postCustomEventRequest=new PostCustomEventRequest();
        postCustomEventRequest.setDescription(getDescription());
        postCustomEventRequest.setCode(getCode());
        postCustomEventRequest.setFullname(getFullname());
        postCustomEventRequest.setSource(getSource());
        postCustomEventRequest.setStartTimestamp(new BigDecimal(getStarttime()));
        postCustomEventRequest.setUrl(getUrl());
        postCustomEventRequest.setTimeframe(PostCustomEventRequest.TimeframeEnum.TIME_RANGE);
        if(getEndtime()>0)
            postCustomEventRequest.setEndTimestamp(new BigDecimal(getEndtime()));

        return postCustomEventRequest;


    }

    public void setEndtime(long endtime) {
        this.endtime = new Long(endtime);
    }

    public void setEndtime(Date endtime) {
        this.endtime = new Long(endtime.getTime()/1000);
    }

    public void setEndtime(OffsetDateTime endTime) {
        this.endtime =new Long(endTime.toEpochSecond());
    }
}
