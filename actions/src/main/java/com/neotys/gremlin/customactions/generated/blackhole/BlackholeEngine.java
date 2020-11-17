package com.neotys.gremlin.customactions.generated.blackhole;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class BlackholeEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return BlackholeOption.values();
  }

  @Override
  public String getCommand() {
    return "blackhole";
  }

  @Override
  public String getCommandType() {
    return "Blackhole";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-BLACKHOLE-ACTION-01";
  }
}
