package com.neotys.gremlin.common.datamodel.jsonattack;

public class GremlinAttackAttack {

    GremlinTarget gremlinTarget;
    GremlinCommand gremlinCommand;

    GremlinDelay delay;

    public GremlinAttackAttack(GremlinTarget gremlinTarget, GremlinCommand gremlinCommand,GremlinDelay delay) {
        this.gremlinTarget = gremlinTarget;
        this.gremlinCommand = gremlinCommand;
        this.delay=delay;
    }

    public GremlinDelay getDelay() {
        return delay;
    }

    public void setDelay(GremlinDelay delay) {
        this.delay = delay;
    }

    public GremlinTarget getGremlinTarget() {
        return gremlinTarget;
    }

    public void setGremlinTarget(GremlinTarget gremlinTarget) {
        this.gremlinTarget = gremlinTarget;
    }

    public GremlinCommand getGremlinCommand() {
        return gremlinCommand;
    }

    public void setGremlinCommand(GremlinCommand gremlinCommand) {
        this.gremlinCommand = gremlinCommand;
    }
}
