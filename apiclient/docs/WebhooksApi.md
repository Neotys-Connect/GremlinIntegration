# WebhooksApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createWebhook1**](WebhooksApi.md#createWebhook1) | **POST** /webhooks | 
[**deleteWebhook**](WebhooksApi.md#deleteWebhook) | **DELETE** /webhooks/{guid} | 
[**getWebhookById**](WebhooksApi.md#getWebhookById) | **GET** /webhooks/{guid} | 
[**getWebhooks**](WebhooksApi.md#getWebhooks) | **GET** /webhooks | 
[**updateWebhook**](WebhooksApi.md#updateWebhook) | **PUT** /webhooks/{guid} | 


<a name="createWebhook1"></a>
# **createWebhook1**
> createWebhook1(body, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_WEBHOOKS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import WebhooksApi;


WebhooksApi apiInstance = new WebhooksApi();
WebhookRequest body = new WebhookRequest(); // WebhookRequest | webhook to create
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.createWebhook1(body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#createWebhook1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**WebhookRequest**](WebhookRequest.md)| webhook to create | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="deleteWebhook"></a>
# **deleteWebhook**
> deleteWebhook(guid, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_WEBHOOKS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import WebhooksApi;


WebhooksApi apiInstance = new WebhooksApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.deleteWebhook(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#deleteWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="getWebhookById"></a>
# **getWebhookById**
> Webhook getWebhookById(guid, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_WEBHOOKS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import WebhooksApi;


WebhooksApi apiInstance = new WebhooksApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    Webhook result = apiInstance.getWebhookById(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#getWebhookById");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**Webhook**](Webhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getWebhooks"></a>
# **getWebhooks**
> List&lt;Webhook&gt; getWebhooks(state, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_WEBHOOKS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import WebhooksApi;


WebhooksApi apiInstance = new WebhooksApi();
String state = "state_example"; // String | Filter webhooks by state
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Webhook> result = apiInstance.getWebhooks(state, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#getWebhooks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **state** | **String**| Filter webhooks by state | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Webhook&gt;**](Webhook.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateWebhook"></a>
# **updateWebhook**
> updateWebhook(guid, body, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_WEBHOOKS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import WebhooksApi;


WebhooksApi apiInstance = new WebhooksApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
WebhookRequest body = new WebhookRequest(); // WebhookRequest | webhook update
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.updateWebhook(guid, body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling WebhooksApi#updateWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **body** | [**WebhookRequest**](WebhookRequest.md)| webhook update | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

