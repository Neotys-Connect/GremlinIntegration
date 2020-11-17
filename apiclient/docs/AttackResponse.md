
# AttackResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**uid** | **String** |  |  [optional]
**attackId** | **String** |  |  [optional]
**attack** | [**AttackK8sObjectResponse**](AttackK8sObjectResponse.md) |  |  [optional]
**stage** | [**StageEnum**](#StageEnum) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**createUser** | **String** |  |  [optional]
**error** | **String** |  |  [optional]
**scenarioId** | **String** |  |  [optional]
**scenarioRunNumber** | **Long** |  |  [optional]
**scenarioNodeGuid** | **String** |  |  [optional]


<a name="StageEnum"></a>
## Enum: StageEnum
Name | Value
---- | -----
RESOLVING | &quot;RESOLVING&quot;
ERROR | &quot;ERROR&quot;
LAUNCHED | &quot;LAUNCHED&quot;
USER_HALTED | &quot;USER_HALTED&quot;



