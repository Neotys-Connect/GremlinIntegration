
# ApiKeyJson

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**identifier** | **String** | The identifier of this API key. |  [optional]
**description** | **String** | The description for the API key. |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date when this API key was created. |  [optional]
**createdBy** | **String** | The user who created this API key. |  [optional]
**revokedBy** | **String** | The user who revoked this API key. |  [optional]
**state** | [**StateEnum**](#StateEnum) | The current state this API key is in. |  [optional]
**value** | **String** | The API keys value. The core piece that is used for authentication |  [optional]
**orgId** | **String** | The identifier of the team this API key is tied to. |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The date this API key was last updated. |  [optional]


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
IDLE | &quot;IDLE&quot;
REVOKED | &quot;REVOKED&quot;
INVITED | &quot;INVITED&quot;



