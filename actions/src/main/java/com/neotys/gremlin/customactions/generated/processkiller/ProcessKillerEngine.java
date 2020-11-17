package com.neotys.gremlin.customactions.generated.processkiller;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class ProcessKillerEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return ProcessKillerOption.values();
  }

  @Override
  public String getCommand() {
    return "process_killer";
  }

  @Override
  public String getCommandType() {
    return "Process Killer";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-PROCESSKILLER-ACTION-01";
  }
}
