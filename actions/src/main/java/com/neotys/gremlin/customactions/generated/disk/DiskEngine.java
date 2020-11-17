package com.neotys.gremlin.customactions.generated.disk;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class DiskEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return DiskOption.values();
  }

  @Override
  public String getCommand() {
    return "disk";
  }

  @Override
  public String getCommandType() {
    return "Disk";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-DISK-ACTION-01";
  }
}
