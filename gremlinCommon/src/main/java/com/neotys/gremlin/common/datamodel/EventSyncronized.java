package com.neotys.gremlin.common.datamodel;

public class EventSyncronized {
    String eventid;
    boolean isended=false;

    public EventSyncronized(String eventid) {
        this.eventid = eventid;
    }

    public String getEventid() {
        return eventid;
    }

    public void setEventid(String eventid) {
        this.eventid = eventid;
    }

    public boolean isIsended() {
        return isended;
    }

    public void setIsended() {
        this.isended = true;
    }
}
