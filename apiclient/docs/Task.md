
# Task

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**end** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**targets** | **List&lt;String&gt;** |  |  [optional]
**annotations** | **Map&lt;String, String&gt;** |  |  [optional]
**providers** | **List&lt;String&gt;** |  |  [optional]
**version** | **Integer** |  |  [optional]
**startTime** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**endTime** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**k8sAttackId** | **String** |  |  [optional]
**totalClients** | **Integer** |  |  [optional]
**clientsMetricsEnabledCount** | **Integer** |  |  [optional]
**targetContainers** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]
**executionStageSummary** | **Map&lt;String, Integer&gt;** |  |  [optional]
**dynamicallyResolvedIPs** | **List&lt;String&gt;** |  |  [optional]
**externalPartitionKey** | **String** |  |  [optional]
**externalSortKey** | **String** |  |  [optional]
**attackQuery** | [**AttackQuery**](AttackQuery.md) |  |  [optional]
**start** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**callbacks** | [**List&lt;CallBack&gt;**](CallBack.md) |  |  [optional]
**user** | **String** |  |  [optional]
**trafficImpactMapping** | [**TrafficImpactMapping**](TrafficImpactMapping.md) |  |  [optional]
**stage** | [**StageEnum**](#StageEnum) |  |  [optional]
**target** | [**TaskTarget**](TaskTarget.md) |  |  [optional]
**attributes** | **Map&lt;String, Object&gt;** |  |  [optional]
**scenarioRunNumber** | **Integer** |  |  [optional]
**scenarioId** | **String** |  |  [optional]
**scenarioNodeGuid** | **String** |  |  [optional]
**container** | **Boolean** |  |  [optional]
**stageLifecycle** | **String** |  |  [optional]
**halting** | **Boolean** |  |  [optional]
**commandTemplateId** | **String** |  |  [optional]
**targetTemplateId** | **String** |  |  [optional]
**args** | **List&lt;String&gt;** |  |  [optional]
**gremlinName** | **String** |  |  [optional]
**targetType** | [**TargetTypeEnum**](#TargetTypeEnum) |  |  [optional]
**multiSelectLabels** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]
**createSource** | [**CreateSourceEnum**](#CreateSourceEnum) |  |  [optional]
**gremlin** | **String** |  |  [optional]
**multiSelectTags** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]
**length** | **Integer** |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**guid** | **String** |  |  [optional]
**orgId** | **String** |  |  [optional]
**sourceInfo** | [**SourceInfo**](SourceInfo.md) |  |  [optional]
**createSourceDetail** | [**CreateSourceDetailEnum**](#CreateSourceDetailEnum) |  |  [optional]
**command** | [**InfraCommand**](InfraCommand.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]


<a name="StageEnum"></a>
## Enum: StageEnum
Name | Value
---- | -----
INVALIDARGUMENT | &quot;InvalidArgument&quot;
TARGETNOTFOUND | &quot;TargetNotFound&quot;
SUCCESSFUL | &quot;Successful&quot;
USERHALTED | &quot;UserHalted&quot;
CLIENTABORTED | &quot;ClientAborted&quot;
LOSTCOMMUNICATION | &quot;LostCommunication&quot;
INITIALIZATIONFAILED | &quot;InitializationFailed&quot;
TEARDOWNFAILED | &quot;TeardownFailed&quot;
HALTFAILED | &quot;HaltFailed&quot;
FAILED | &quot;Failed&quot;
PENDING | &quot;Pending&quot;
DISTRIBUTED | &quot;Distributed&quot;
INITIALIZING | &quot;Initializing&quot;
HALTDISTRIBUTED | &quot;HaltDistributed&quot;
INTERRUPTTRIGGERED | &quot;InterruptTriggered&quot;
ROLLBACKTRIGGERED | &quot;RollbackTriggered&quot;
ROLLBACKSTARTED | &quot;RollbackStarted&quot;
HALT | &quot;Halt&quot;
RUNNING | &quot;Running&quot;
TEARINGDOWN | &quot;TearingDown&quot;


<a name="TargetTypeEnum"></a>
## Enum: TargetTypeEnum
Name | Value
---- | -----
HOST | &quot;Host&quot;
CONTAINER | &quot;Container&quot;
DOCKER | &quot;Docker&quot;
KUBERNETES | &quot;Kubernetes&quot;


<a name="CreateSourceEnum"></a>
## Enum: CreateSourceEnum
Name | Value
---- | -----
WEBAPP | &quot;WebApp&quot;
API | &quot;Api&quot;
SCHEDULED | &quot;Scheduled&quot;
MANUAL | &quot;Manual&quot;
SPINNAKER | &quot;Spinnaker&quot;
CONCORD | &quot;Concord&quot;
GREMLINFEEDER | &quot;GremlinFeeder&quot;
GREMLINSDKPYTHON | &quot;GremlinSdkPython&quot;
SCENARIO | &quot;Scenario&quot;
CHAO | &quot;Chao&quot;
WEBSITE | &quot;Website&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
NETWORK | &quot;NETWORK&quot;
RESOURCE | &quot;RESOURCE&quot;
STATE | &quot;STATE&quot;
UNKNOWN | &quot;UNKNOWN&quot;


<a name="CreateSourceDetailEnum"></a>
## Enum: CreateSourceDetailEnum
Name | Value
---- | -----
ONBOARDING | &quot;Onboarding&quot;



