# AlfiApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**active**](AlfiApi.md#active) | **GET** /experiments/active | List all active experiments.
[**completed**](AlfiApi.md#completed) | **GET** /experiments/completed | List all completed experiments.
[**createNewExperiment**](AlfiApi.md#createNewExperiment) | **POST** /experiments | Creates a new application level experiment.
[**getExperimentByGuid**](AlfiApi.md#getExperimentByGuid) | **GET** /experiments/{guid} | Get details about an experiment.
[**requestHalt**](AlfiApi.md#requestHalt) | **DELETE** /experiments | Idempotently halt all active experiments.
[**requestHalt1**](AlfiApi.md#requestHalt1) | **DELETE** /experiments/{guid} | Idempotently halt the experiment with the associated &#x60;guid&#x60;.


<a name="active"></a>
# **active**
> List&lt;ApplicationExperiment&gt; active(teamId)

List all active experiments.

This endpoint will return all active experiments for the team.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AlfiApi;


AlfiApi apiInstance = new AlfiApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ApplicationExperiment> result = apiInstance.active(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlfiApi#active");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ApplicationExperiment&gt;**](ApplicationExperiment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="completed"></a>
# **completed**
> List&lt;ApplicationExperiment&gt; completed(teamId)

List all completed experiments.

This endpoint will return all completed experiments that the team has performed  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AlfiApi;


AlfiApi apiInstance = new AlfiApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ApplicationExperiment> result = apiInstance.completed(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlfiApi#completed");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ApplicationExperiment&gt;**](ApplicationExperiment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="createNewExperiment"></a>
# **createNewExperiment**
> String createNewExperiment(body, teamId)

Creates a new application level experiment.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AlfiApi;


AlfiApi apiInstance = new AlfiApi();
String body = "body_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    String result = apiInstance.createNewExperiment(body, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlfiApi#createNewExperiment");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="getExperimentByGuid"></a>
# **getExperimentByGuid**
> ApplicationExperiment getExperimentByGuid(guid, teamId)

Get details about an experiment.

This endpoint will allow you to get info on a specific experiment based on its &#x60;guid&#x60;.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AlfiApi;


AlfiApi apiInstance = new AlfiApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ApplicationExperiment result = apiInstance.getExperimentByGuid(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AlfiApi#getExperimentByGuid");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ApplicationExperiment**](ApplicationExperiment.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="requestHalt"></a>
# **requestHalt**
> requestHalt(teamId)

Idempotently halt all active experiments.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AlfiApi;


AlfiApi apiInstance = new AlfiApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.requestHalt(teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling AlfiApi#requestHalt");
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
 - **Accept**: text/plain

<a name="requestHalt1"></a>
# **requestHalt1**
> requestHalt1(guid, teamId)

Idempotently halt the experiment with the associated &#x60;guid&#x60;.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AlfiApi;


AlfiApi apiInstance = new AlfiApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.requestHalt1(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling AlfiApi#requestHalt1");
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
 - **Accept**: text/plain

