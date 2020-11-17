package com.neotys.gremlin.customactions.generated.shutdown;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class ShutdownEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return ShutdownOption.values();
  }

  @Override
  public String getCommand() {
    return "shutdown";
  }

  @Override
  public String getCommandType() {
    return "Shutdown";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-SHUTDOWN-ACTION-01";
  }
}
