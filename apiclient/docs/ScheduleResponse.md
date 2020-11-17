
# ScheduleResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**orgId** | **String** |  |  [optional]
**guid** | **String** |  |  [optional]
**trigger** | **Map&lt;String, Object&gt;** |  |  [optional]
**target** | **Map&lt;String, Object&gt;** |  |  [optional]
**command** | **Map&lt;String, Object&gt;** |  |  [optional]
**createdBy** | **String** |  |  [optional]
**taskIds** | **List&lt;String&gt;** |  |  [optional]
**labels** | **Map&lt;String, String&gt;** |  |  [optional]
**multiSelectLabels** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]
**createSource** | [**CreateSourceEnum**](#CreateSourceEnum) |  |  [optional]
**callbacks** | [**List&lt;CallBack&gt;**](CallBack.md) |  |  [optional]
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



