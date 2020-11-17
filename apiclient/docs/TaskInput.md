
# TaskInput

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**command** | **Map&lt;String, Object&gt;** |  |  [optional]
**multiSelectTags** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]
**multiSelectLabels** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]
**target** | **Map&lt;String, Object&gt;** |  |  [optional]
**annotations** | **Map&lt;String, String&gt;** |  |  [optional]
**source** | [**SourceEnum**](#SourceEnum) |  |  [optional]
**callbacks** | [**List&lt;CallBack&gt;**](CallBack.md) |  |  [optional]


<a name="SourceEnum"></a>
## Enum: SourceEnum
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



