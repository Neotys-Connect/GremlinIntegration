package com.neotys.gremlin.customactions.generated.cpu;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class CPUEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return CPUOption.values();
  }

  @Override
  public String getCommand() {
    return "cpu";
  }

  @Override
  public String getCommandType() {
    return "CPU";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-CPU-ACTION-01";
  }
}
