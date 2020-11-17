package com.neotys.gremlin.common;

import com.google.common.base.Optional;

public class GremlinParameter {
    String name;
    String shortname;
    Optional<String> value;

    public GremlinParameter(String name, String shortname, Optional<String> value) {
        this.name = name;
        this.shortname = shortname;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public Optional<String> getValue() {
        return value;
    }

    public void setValue(Optional<String> value) {
        this.value = value;
    }
}
