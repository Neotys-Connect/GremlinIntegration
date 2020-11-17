
# ScenarioResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**orgId** | **String** |  |  [optional]
**guid** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**description** | **String** |  |  [optional]
**hypothesis** | **String** |  |  [optional]
**steps** | [**List&lt;Map&lt;String, Object&gt;&gt;**](Map.md) |  |  [optional]
**graph** | [**ScenarioGraph**](ScenarioGraph.md) |  |  [optional]
**state** | **String** |  |  [optional]
**createSource** | **String** |  |  [optional]
**createdBy** | **String** |  |  [optional]
**createdAt** | **String** |  |  [optional]
**updatedAt** | **String** |  |  [optional]
**lastRunAt** | **String** |  |  [optional]
**tiers** | **List&lt;String&gt;** |  |  [optional]
**recommendedScenarioId** | **String** |  |  [optional]
**multiSelectTags** | [**Map&lt;String, List&lt;String&gt;&gt;**](List.md) |  |  [optional]
**createdFromType** | [**CreatedFromTypeEnum**](#CreatedFromTypeEnum) |  |  [optional]
**createdFromId** | **String** |  |  [optional]
**editCounter** | **Integer** |  |  [optional]


<a name="CreatedFromTypeEnum"></a>
## Enum: CreatedFromTypeEnum
Name | Value
---- | -----
RECOMMENDED | &quot;Recommended&quot;
SHARED | &quot;Shared&quot;



