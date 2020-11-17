package com.neotys.gremlin.customactions.generated.latency;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class LatencyEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return LatencyOption.values();
  }

  @Override
  public String getCommand() {
    return "latency";
  }

  @Override
  public String getCommandType() {
    return "Latency";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-LATENCY-ACTION-01";
  }
}
