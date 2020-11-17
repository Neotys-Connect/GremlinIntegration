package com.neotys.gremlin.customactions.generated.memory;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class MemoryEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return MemoryOption.values();
  }

  @Override
  public String getCommand() {
    return "memory";
  }

  @Override
  public String getCommandType() {
    return "Memory";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-MEMORY-ACTION-01";
  }
}
