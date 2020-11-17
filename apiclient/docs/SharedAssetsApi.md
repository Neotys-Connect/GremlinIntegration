# SharedAssetsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**approveAccess**](SharedAssetsApi.md#approveAccess) | **POST** /sharedAssets/requests/{requestId}/approve | Approves a sharing request to a resource you own
[**approveAccessRequests**](SharedAssetsApi.md#approveAccessRequests) | **POST** /sharedAssets/requests/approve | 
[**deleteRequest**](SharedAssetsApi.md#deleteRequest) | **DELETE** /sharedAssets/requests/{requestId} | Deletes an existing request for Access
[**denyAccess**](SharedAssetsApi.md#denyAccess) | **POST** /sharedAssets/requests/{requestId}/deny | Denies or Revokes a sharing request to a resource you own
[**denyAccessRequests**](SharedAssetsApi.md#denyAccessRequests) | **POST** /sharedAssets/requests/deny | 
[**listAssetsSharedWithMe**](SharedAssetsApi.md#listAssetsSharedWithMe) | **GET** /sharedAssets/withMe | 
[**listAvailableAssets**](SharedAssetsApi.md#listAvailableAssets) | **GET** /sharedAssets | 
[**listMyRequests**](SharedAssetsApi.md#listMyRequests) | **GET** /sharedAssets/requests | 
[**listRequestsToMe**](SharedAssetsApi.md#listRequestsToMe) | **GET** /sharedAssets/requests/toMe | 
[**postDeleteRequest**](SharedAssetsApi.md#postDeleteRequest) | **POST** /sharedAssets/requests/{requestId}/delete | Deletes an existing request for Access
[**requestAccess**](SharedAssetsApi.md#requestAccess) | **POST** /sharedAssets/requests | 
[**requestAccessToAsset**](SharedAssetsApi.md#requestAccessToAsset) | **POST** /sharedAssets/{owningTeam}/{assetId} | 


<a name="approveAccess"></a>
# **approveAccess**
> SharedAsset approveAccess(requestId, teamId)

Approves a sharing request to a resource you own

The {requestId} parameter _must_ be urlencoded  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;SHARE_ASSET&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
String requestId = "requestId_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    SharedAsset result = apiInstance.approveAccess(requestId, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#approveAccess");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**SharedAsset**](SharedAsset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="approveAccessRequests"></a>
# **approveAccessRequests**
> SharedAssetUpdate approveAccessRequests(body, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;SHARE_ASSET&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
UpdateAllRequests body = new UpdateAllRequests(); // UpdateAllRequests | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    SharedAssetUpdate result = apiInstance.approveAccessRequests(body, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#approveAccessRequests");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UpdateAllRequests**](UpdateAllRequests.md)|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**SharedAssetUpdate**](SharedAssetUpdate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="deleteRequest"></a>
# **deleteRequest**
> SharedAsset deleteRequest(requestId)

Deletes an existing request for Access

The {requestId} parameter _must_ be urlencoded  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
String requestId = "requestId_example"; // String | 
try {
    SharedAsset result = apiInstance.deleteRequest(requestId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#deleteRequest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**|  |

### Return type

[**SharedAsset**](SharedAsset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="denyAccess"></a>
# **denyAccess**
> SharedAsset denyAccess(requestId, teamId)

Denies or Revokes a sharing request to a resource you own

The {requestId} parameter _must_ be urlencoded  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;SHARE_ASSET&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
String requestId = "requestId_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    SharedAsset result = apiInstance.denyAccess(requestId, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#denyAccess");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**SharedAsset**](SharedAsset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="denyAccessRequests"></a>
# **denyAccessRequests**
> SharedAssetUpdate denyAccessRequests(body, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;SHARE_ASSET&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
UpdateAllRequests body = new UpdateAllRequests(); // UpdateAllRequests | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    SharedAssetUpdate result = apiInstance.denyAccessRequests(body, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#denyAccessRequests");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**UpdateAllRequests**](UpdateAllRequests.md)|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**SharedAssetUpdate**](SharedAssetUpdate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listAssetsSharedWithMe"></a>
# **listAssetsSharedWithMe**
> SharedAssetUpdate listAssetsSharedWithMe()



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
try {
    SharedAssetUpdate result = apiInstance.listAssetsSharedWithMe();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#listAssetsSharedWithMe");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SharedAssetUpdate**](SharedAssetUpdate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listAvailableAssets"></a>
# **listAvailableAssets**
> SharableAssets listAvailableAssets(assetId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
ApiGremlinException
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
String assetId = "assetId_example"; // String | 
try {
    SharableAssets result = apiInstance.listAvailableAssets(assetId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#listAvailableAssets");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **assetId** | **String**|  | [optional]

### Return type

[**SharableAssets**](SharableAssets.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listMyRequests"></a>
# **listMyRequests**
> OutstandingRequests listMyRequests()



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
try {
    OutstandingRequests result = apiInstance.listMyRequests();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#listMyRequests");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**OutstandingRequests**](OutstandingRequests.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="listRequestsToMe"></a>
# **listRequestsToMe**
> OutstandingRequests listRequestsToMe(assetId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
String assetId = "assetId_example"; // String | 
try {
    OutstandingRequests result = apiInstance.listRequestsToMe(assetId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#listRequestsToMe");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **assetId** | **String**|  | [optional]

### Return type

[**OutstandingRequests**](OutstandingRequests.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="postDeleteRequest"></a>
# **postDeleteRequest**
> SharedAsset postDeleteRequest(requestId)

Deletes an existing request for Access

The {requestId} parameter _must_ be urlencoded  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
String requestId = "requestId_example"; // String | 
try {
    SharedAsset result = apiInstance.postDeleteRequest(requestId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#postDeleteRequest");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **requestId** | **String**|  |

### Return type

[**SharedAsset**](SharedAsset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="requestAccess"></a>
# **requestAccess**
> SharedAssetUpdate requestAccess(body)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
NewRequestRequest body = new NewRequestRequest(); // NewRequestRequest | 
try {
    SharedAssetUpdate result = apiInstance.requestAccess(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#requestAccess");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**NewRequestRequest**](NewRequestRequest.md)|  | [optional]

### Return type

[**SharedAssetUpdate**](SharedAssetUpdate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="requestAccessToAsset"></a>
# **requestAccessToAsset**
> SharedAsset requestAccessToAsset(owningTeam, assetId, namespace)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SharedAssetsApi;


SharedAssetsApi apiInstance = new SharedAssetsApi();
String owningTeam = "owningTeam_example"; // String | 
String assetId = "assetId_example"; // String | 
String namespace = "namespace_example"; // String | 
try {
    SharedAsset result = apiInstance.requestAccessToAsset(owningTeam, assetId, namespace);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SharedAssetsApi#requestAccessToAsset");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **owningTeam** | **String**|  |
 **assetId** | **String**|  |
 **namespace** | **String**|  | [optional]

### Return type

[**SharedAsset**](SharedAsset.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

