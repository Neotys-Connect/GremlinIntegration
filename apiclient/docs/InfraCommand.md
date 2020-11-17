
# InfraCommand

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**templateId** | **String** |  |  [optional]
**infraCommandType** | [**InfraCommandTypeEnum**](#InfraCommandTypeEnum) |  |  [optional]
**infraCommandArgs** | [**InfraCommandArgs**](InfraCommandArgs.md) |  |  [optional]
**maxExpectedLength** | **Integer** |  |  [optional]
**length** | **Integer** |  |  [optional]


<a name="InfraCommandTypeEnum"></a>
## Enum: InfraCommandTypeEnum
Name | Value
---- | -----
CPU | &quot;CPU&quot;
IO | &quot;IO&quot;
MEMORY | &quot;Memory&quot;
DISK | &quot;Disk&quot;
BLACKHOLE | &quot;Blackhole&quot;
DNS | &quot;DNS&quot;
LATENCY | &quot;Latency&quot;
PACKET_LOSS | &quot;Packet_Loss&quot;
SHUTDOWN | &quot;Shutdown&quot;
TIME_TRAVEL | &quot;Time_Travel&quot;
PROCESS_KILLER | &quot;Process_Killer&quot;
UNKNOWN | &quot;Unknown&quot;



