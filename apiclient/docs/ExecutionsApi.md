# ExecutionsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**forAttack**](ExecutionsApi.md#forAttack) | **GET** /executions | Get a list of executions associated with an attack.


<a name="forAttack"></a>
# **forAttack**
> forAttack(taskId, teamId)

Get a list of executions associated with an attack.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ExecutionsApi;


ExecutionsApi apiInstance = new ExecutionsApi();
String taskId = "taskId_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.forAttack(taskId, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ExecutionsApi#forAttack");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **taskId** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

