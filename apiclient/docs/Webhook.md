
# Webhook

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**teamId** | **String** | The identifier of the team to which this webhook belongs |  [optional]
**identifier** | **String** | The identifier of this webhook |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The type of this webhook |  [optional]
**webhookEndpoint** | [**WebhookEndpoint**](WebhookEndpoint.md) | The webhook endpoint configuration for this webhook |  [optional]
**name** | **String** | The name of this webhook |  [optional]
**description** | **String** | The description of this webhook |  [optional]
**createdBy** | **String** | The identifier of the user that created this webhook |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) | The time of creation of this webhook |  [optional]
**updatedBy** | **String** | The time of the most recent update for this webhook (if applicable) |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) | The identifier of the user that most recently updated this webhook (if applicable) |  [optional]
**triggerEvents** | [**List&lt;TriggerEventsEnum&gt;**](#List&lt;TriggerEventsEnum&gt;) | The identifier of the user that most recently updated this webhook (if applicable) |  [optional]
**state** | [**StateEnum**](#StateEnum) | The state of this webhook (ACTIVE / DEACTIVATED |  [optional]
**payload** | **String** | The payload to be sent when the webhook is invoked |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
TASK | &quot;TASK&quot;
STATUS_CHECK | &quot;STATUS_CHECK&quot;


<a name="List<TriggerEventsEnum>"></a>
## Enum: List&lt;TriggerEventsEnum&gt;
Name | Value
---- | -----
INITIALIZING | &quot;INITIALIZING&quot;
RUNNING | &quot;RUNNING&quot;
FINISHED | &quot;FINISHED&quot;


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
DEACTIVATED | &quot;DEACTIVATED&quot;



