
# WebhookRequest

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**name** | **String** | The name of the webhook to be created/updated |  [optional]
**description** | **String** | The description of the webhook to be created/updated |  [optional]
**uri** | **String** | The URI of the webhook |  [optional]
**method** | **String** | The HTTP request method to use when the webhook is invoked |  [optional]
**headers** | **Map&lt;String, String&gt;** | Optional request headers to be used when the webhook is invoked |  [optional]
**triggerEvents** | **List&lt;String&gt;** | The list of attack events that should cause the webhook to be invoked |  [optional]
**state** | **String** | State (active/deactivated) of the webhook |  [optional]
**payload** | **String** | The payload to be sent when the webhook is invoked |  [optional]



