package com.neotys.gremlin.customactions.generated.packetloss;

import com.neotys.gremlin.common.GremlinActionEngine;
import com.neotys.gremlin.common.GremlinOption;
import java.lang.Override;
import java.lang.String;

public class PacketLossEngine extends GremlinActionEngine {
  @Override
  public GremlinOption[] getOptions() {
    return PacketLossOption.values();
  }

  @Override
  public String getCommand() {
    return "packet_loss";
  }

  @Override
  public String getCommandType() {
    return "Packet Loss";
  }

  @Override
  public String getInvalidParameterCode() {
    return "NL-PACKETLOSS-ACTION-01";
  }
}
