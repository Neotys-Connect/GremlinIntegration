# HaltsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**haltAll**](HaltsApi.md#haltAll) | **POST** /halts | Idempotently halt all active impacts across the Gremlin platform


<a name="haltAll"></a>
# **haltAll**
> haltAll(teamId, body)

Idempotently halt all active impacts across the Gremlin platform

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import HaltsApi;


HaltsApi apiInstance = new HaltsApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
HaltRequest body = new HaltRequest(); // HaltRequest | 
try {
    apiInstance.haltAll(teamId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling HaltsApi#haltAll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**HaltRequest**](HaltRequest.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

