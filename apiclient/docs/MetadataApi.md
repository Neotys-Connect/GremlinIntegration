# MetadataApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**metadata**](MetadataApi.md#metadata) | **GET** /metadata | Get metadata about the Gremlin commands.


<a name="metadata"></a>
# **metadata**
> metadata(teamId)

Get metadata about the Gremlin commands.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import MetadataApi;


MetadataApi apiInstance = new MetadataApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.metadata(teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling MetadataApi#metadata");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

