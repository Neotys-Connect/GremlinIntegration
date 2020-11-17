
# SharedAsset

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**companyId** | **String** |  |  [optional]
**owningTeamId** | **String** |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**approver** | **String** |  |  [optional]
**requester** | **String** |  |  [optional]
**assetName** | **String** |  |  [optional]
**currentStatus** | [**CurrentStatusEnum**](#CurrentStatusEnum) |  |  [optional]
**assetId** | **String** |  |  [optional]
**sharedTeam** | **String** |  |  [optional]
**namespace** | **String** |  |  [optional]
**requestId** | **String** |  |  [optional]


<a name="CurrentStatusEnum"></a>
## Enum: CurrentStatusEnum
Name | Value
---- | -----
REQUESTED | &quot;REQUESTED&quot;
APPROVED | &quot;APPROVED&quot;
DENIED | &quot;DENIED&quot;
REVOKED | &quot;REVOKED&quot;
DELETED | &quot;DELETED&quot;



