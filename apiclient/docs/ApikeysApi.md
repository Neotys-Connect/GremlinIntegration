# ApikeysApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**activate1**](ApikeysApi.md#activate1) | **PUT** /apikeys/{identifier}/activate | Un-Revoke an existing API Key
[**createNew**](ApikeysApi.md#createNew) | **POST** /apikeys | Create a new API Key
[**listActive**](ApikeysApi.md#listActive) | **GET** /apikeys/active | List active API Keys
[**listAll**](ApikeysApi.md#listAll) | **GET** /apikeys | List all API Keys
[**revoke1**](ApikeysApi.md#revoke1) | **DELETE** /apikeys/{identifier} | Revoke an existing API Key


<a name="activate1"></a>
# **activate1**
> activate1(identifier, teamId)

Un-Revoke an existing API Key

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;ACTIVATE_API_KEY&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ApikeysApi;


ApikeysApi apiInstance = new ApikeysApi();
String identifier = "identifier_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.activate1(identifier, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ApikeysApi#activate1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

<a name="createNew"></a>
# **createNew**
> createNew(body, teamId)

Create a new API Key

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ApikeysApi;


ApikeysApi apiInstance = new ApikeysApi();
CreateApiKeysRequest body = new CreateApiKeysRequest(); // CreateApiKeysRequest | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.createNew(body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ApikeysApi#createNew");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**CreateApiKeysRequest**](CreateApiKeysRequest.md)|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="listActive"></a>
# **listActive**
> List&lt;ApiKeyJson&gt; listActive(teamId)

List active API Keys

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ApikeysApi;


ApikeysApi apiInstance = new ApikeysApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ApiKeyJson> result = apiInstance.listActive(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApikeysApi#listActive");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ApiKeyJson&gt;**](ApiKeyJson.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listAll"></a>
# **listAll**
> List&lt;ApiKeyJson&gt; listAll(teamId)

List all API Keys

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ApikeysApi;


ApikeysApi apiInstance = new ApikeysApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ApiKeyJson> result = apiInstance.listAll(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ApikeysApi#listAll");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ApiKeyJson&gt;**](ApiKeyJson.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="revoke1"></a>
# **revoke1**
> revoke1(identifier, teamId)

Revoke an existing API Key

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ApikeysApi;


ApikeysApi apiInstance = new ApikeysApi();
String identifier = "identifier_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.revoke1(identifier, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ApikeysApi#revoke1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: Not defined

