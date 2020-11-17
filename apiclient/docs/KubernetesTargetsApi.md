# KubernetesTargetsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getTargets**](KubernetesTargetsApi.md#getTargets) | **GET** /kubernetes/targets | List all attackable targets


<a name="getTargets"></a>
# **getTargets**
> getTargets(clientId, teamId)

List all attackable targets

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import KubernetesTargetsApi;


KubernetesTargetsApi apiInstance = new KubernetesTargetsApi();
String clientId = "clientId_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.getTargets(clientId, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling KubernetesTargetsApi#getTargets");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **clientId** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

