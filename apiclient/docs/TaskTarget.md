
# TaskTarget

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**templateId** | **String** |  |  [optional]
**strategyType** | [**StrategyTypeEnum**](#StrategyTypeEnum) |  |  [optional]
**targetType** | [**TargetTypeEnum**](#TargetTypeEnum) |  |  [optional]
**strategy** | [**Strategy**](Strategy.md) |  |  [optional]
**resolvedHosts** | **List&lt;String&gt;** |  |  [optional]
**resolvedContainers** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]


<a name="StrategyTypeEnum"></a>
## Enum: StrategyTypeEnum
Name | Value
---- | -----
EXACT | &quot;Exact&quot;
REGEX | &quot;Regex&quot;
RANDOM | &quot;Random&quot;


<a name="TargetTypeEnum"></a>
## Enum: TargetTypeEnum
Name | Value
---- | -----
HOST | &quot;Host&quot;
CONTAINER | &quot;Container&quot;
DOCKER | &quot;Docker&quot;
KUBERNETES | &quot;Kubernetes&quot;



