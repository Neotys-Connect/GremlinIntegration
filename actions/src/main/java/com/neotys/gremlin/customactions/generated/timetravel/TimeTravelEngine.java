package com.neotys.gremlin.customactions.generated.timetravel;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class TimeTravelEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return TimeTravelOption.values();
  }

  @Override
  public String getCommand() {
    return "time_travel";
  }

  @Override
  public String getCommandType() {
    return "Time Travel";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-TIMETRAVEL-ACTION-01";
  }
}
