
# AttackMetricsDisplayResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**state** | [**StateEnum**](#StateEnum) |  |  [optional]
**disabledReason** | **String** |  |  [optional]
**range** | [**TimeRange**](TimeRange.md) |  |  [optional]
**attackRange** | [**TimeRange**](TimeRange.md) |  |  [optional]
**metricData** | [**Map&lt;String, List&lt;MetricPoint&gt;&gt;**](List.md) |  |  [optional]
**infraCommandType** | [**InfraCommandTypeEnum**](#InfraCommandTypeEnum) |  |  [optional]
**chartTitle** | **String** |  |  [optional]
**lines** | [**List&lt;YAxisLine&gt;**](YAxisLine.md) |  |  [optional]


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
DISABLED | &quot;DISABLED&quot;
PENDING | &quot;PENDING&quot;
NO_DATA | &quot;NO_DATA&quot;
PARTIAL | &quot;PARTIAL&quot;
COMPLETE | &quot;COMPLETE&quot;


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



