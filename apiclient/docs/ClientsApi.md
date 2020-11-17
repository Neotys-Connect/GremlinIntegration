# ClientsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**activate**](ClientsApi.md#activate) | **PUT** /clients/{identifier}/activate | Activate a client.
[**active2**](ClientsApi.md#active2) | **GET** /clients/active | Returns all active clients within a team.
[**all2**](ClientsApi.md#all2) | **GET** /clients | Returns all clients within a team.
[**revoke**](ClientsApi.md#revoke) | **DELETE** /clients/{identifier} | Deactivates a client.


<a name="activate"></a>
# **activate**
> activate(identifier, teamId)

Activate a client.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;ACTIVATE_CLIENT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ClientsApi;


ClientsApi apiInstance = new ClientsApi();
String identifier = "identifier_example"; // String | The identifier of the client to modify.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.activate(identifier, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ClientsApi#activate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**| The identifier of the client to modify. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="active2"></a>
# **active2**
> List&lt;Client&gt; active2(teamId)

Returns all active clients within a team.

This operation will return all active clients.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
ApiGremlinException
//import ClientsApi;


ClientsApi apiInstance = new ClientsApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Client> result = apiInstance.active2(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClientsApi#active2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Client&gt;**](Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="all2"></a>
# **all2**
> List&lt;Client&gt; all2(teamId)

Returns all clients within a team.

This operation will return all active, idle, and recently inactive clients.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ClientsApi;


ClientsApi apiInstance = new ClientsApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Client> result = apiInstance.all2(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ClientsApi#all2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Client&gt;**](Client.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="revoke"></a>
# **revoke**
> revoke(identifier, teamId)

Deactivates a client.

This operation will deactivate the specified client. The specified client will no longer be able to be used as a target.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ClientsApi;


ClientsApi apiInstance = new ClientsApi();
String identifier = "identifier_example"; // String | The identifier of the client to modify.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.revoke(identifier, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ClientsApi#revoke");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**| The identifier of the client to modify. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

