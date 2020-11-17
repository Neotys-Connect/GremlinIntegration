# ContainersApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**all4**](ContainersApi.md#all4) | **GET** /containers | Get all active containers.


<a name="all4"></a>
# **all4**
> List&lt;Container&gt; all4(teamId)

Get all active containers.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ContainersApi;


ContainersApi apiInstance = new ContainersApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Container> result = apiInstance.all4(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ContainersApi#all4");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Container&gt;**](Container.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

