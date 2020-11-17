
# ApplicationExperiment

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**active** | **Boolean** |  |  [optional]
**version** | **Integer** |  |  [optional]
**startTime** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**endTime** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**duration** | **Integer** |  |  [optional]
**serviceStates** | [**List&lt;ServiceStateStage&gt;**](ServiceStateStage.md) |  |  [optional]
**distributedClients** | **List&lt;String&gt;** |  |  [optional]
**impactedClients** | **List&lt;String&gt;** |  |  [optional]
**createSource** | [**CreateSourceEnum**](#CreateSourceEnum) |  |  [optional]
**expectedEnd** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**stage** | [**StageEnum**](#StageEnum) |  |  [optional]
**experimentInterval** | [**Interval**](Interval.md) |  |  [optional]
**guid** | **String** |  |  [optional]
**attributes** | **Map&lt;String, Object&gt;** |  |  [optional]
**createdBy** | **String** |  |  [optional]
**orgId** | **String** |  |  [optional]
**tags** | **Map&lt;String, String&gt;** |  |  [optional]
**sourceInfo** | [**SourceInfo**](SourceInfo.md) |  |  [optional]
**createSourceDetail** | [**CreateSourceDetailEnum**](#CreateSourceDetailEnum) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]


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


<a name="StageEnum"></a>
## Enum: StageEnum
Name | Value
---- | -----
PENDING | &quot;Pending&quot;
DISTRIBUTED | &quot;Distributed&quot;
IMPACTED | &quot;Impacted&quot;
HALTREQUESTED | &quot;HaltRequested&quot;
HALTED | &quot;Halted&quot;
APPLICATIONNOTFOUND | &quot;ApplicationNotFound&quot;
TRAFFICNOTFOUND | &quot;TrafficNotFound&quot;
SUCCESSFUL | &quot;Successful&quot;


<a name="CreateSourceDetailEnum"></a>
## Enum: CreateSourceDetailEnum
Name | Value
---- | -----
ONBOARDING | &quot;Onboarding&quot;



