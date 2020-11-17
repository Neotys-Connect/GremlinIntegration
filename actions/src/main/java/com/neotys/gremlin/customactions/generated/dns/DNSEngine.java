package com.neotys.gremlin.customactions.generated.dns;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class DNSEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return DNSOption.values();
  }

  @Override
  public String getCommand() {
    return "dns";
  }

  @Override
  public String getCommandType() {
    return "DNS";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-DNS-ACTION-01";
  }
}
