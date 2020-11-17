package com.neotys.gremlin.customactions.generated.io;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class IOEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return IOOption.values();
  }

  @Override
  public String getCommand() {
    return "io";
  }

  @Override
  public String getCommandType() {
    return "IO";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-IO-ACTION-01";
  }
}
