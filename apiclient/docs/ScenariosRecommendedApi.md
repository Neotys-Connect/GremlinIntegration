# ScenariosRecommendedApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getActive**](ScenariosRecommendedApi.md#getActive) | **GET** /scenarios/recommended | List all recommended scenarios.
[**getRecommendedScenario**](ScenariosRecommendedApi.md#getRecommendedScenario) | **GET** /scenarios/recommended/{guid} | Get details about a recommended scenario.
[**getRecommendedScenarioFromStaticEndpointName**](ScenariosRecommendedApi.md#getRecommendedScenarioFromStaticEndpointName) | **GET** /scenarios/recommended/static/{staticEndpointName} | Get details about a recommended scenario.


<a name="getActive"></a>
# **getActive**
> List&lt;RecommendedScenarioResponse&gt; getActive()

List all recommended scenarios.



### Example
```java
// Import classes:
//import ApiException;
//import ScenariosRecommendedApi;


ScenariosRecommendedApi apiInstance = new ScenariosRecommendedApi();
try {
    List<RecommendedScenarioResponse> result = apiInstance.getActive();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosRecommendedApi#getActive");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;RecommendedScenarioResponse&gt;**](RecommendedScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRecommendedScenario"></a>
# **getRecommendedScenario**
> RecommendedScenarioResponse getRecommendedScenario(guid, teamId)

Get details about a recommended scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosRecommendedApi;


ScenariosRecommendedApi apiInstance = new ScenariosRecommendedApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    RecommendedScenarioResponse result = apiInstance.getRecommendedScenario(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosRecommendedApi#getRecommendedScenario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**RecommendedScenarioResponse**](RecommendedScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRecommendedScenarioFromStaticEndpointName"></a>
# **getRecommendedScenarioFromStaticEndpointName**
> RecommendedScenarioResponse getRecommendedScenarioFromStaticEndpointName(staticEndpointName, teamId)

Get details about a recommended scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosRecommendedApi;


ScenariosRecommendedApi apiInstance = new ScenariosRecommendedApi();
String staticEndpointName = "staticEndpointName_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    RecommendedScenarioResponse result = apiInstance.getRecommendedScenarioFromStaticEndpointName(staticEndpointName, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosRecommendedApi#getRecommendedScenarioFromStaticEndpointName");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **staticEndpointName** | **String**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**RecommendedScenarioResponse**](RecommendedScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

