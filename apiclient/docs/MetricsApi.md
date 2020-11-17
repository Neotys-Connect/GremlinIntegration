# MetricsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getMetricsForAttack**](MetricsApi.md#getMetricsForAttack) | **GET** /metrics/attacks/{attackId} | Get metrics for an attack
[**getMetricsForScenarioRun**](MetricsApi.md#getMetricsForScenarioRun) | **GET** /metrics/scenarios/{scenarioId}/runs/{scenarioRunNumber} | Get metrics for a scenario run


<a name="getMetricsForAttack"></a>
# **getMetricsForAttack**
> AttackMetricsDisplayResponse getMetricsForAttack(attackId, teamId)

Get metrics for an attack

This endpoint will allow you to get metrics for a specific attack based on its guid.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import MetricsApi;


MetricsApi apiInstance = new MetricsApi();
String attackId = "attackId_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    AttackMetricsDisplayResponse result = apiInstance.getMetricsForAttack(attackId, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MetricsApi#getMetricsForAttack");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **attackId** | **String**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**AttackMetricsDisplayResponse**](AttackMetricsDisplayResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getMetricsForScenarioRun"></a>
# **getMetricsForScenarioRun**
> List&lt;TaskMetrics&gt; getMetricsForScenarioRun(scenarioId, scenarioRunNumber, teamId)

Get metrics for a scenario run

This endpoint will allow you to get metrics for a specific scenario run based on its scenario guid and run number.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
ApiGremlinException
//import MetricsApi;


MetricsApi apiInstance = new MetricsApi();
String scenarioId = "scenarioId_example"; // String | 
Long scenarioRunNumber = 789L; // Long | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<TaskMetrics> result = apiInstance.getMetricsForScenarioRun(scenarioId, scenarioRunNumber, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling MetricsApi#getMetricsForScenarioRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **scenarioId** | **String**|  |
 **scenarioRunNumber** | **Long**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;TaskMetrics&gt;**](TaskMetrics.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

