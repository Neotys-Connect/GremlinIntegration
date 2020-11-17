# SchedulesApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAttackSchedule**](SchedulesApi.md#createAttackSchedule) | **POST** /schedules/attacks | Create an attack schedule.
[**createAttackScheduleLegacy**](SchedulesApi.md#createAttackScheduleLegacy) | **POST** /schedules | This functionality has moved to POST /schedules/attacks.
[**createScenarioSchedule**](SchedulesApi.md#createScenarioSchedule) | **POST** /schedules/scenarios | Create a scenario schedule.
[**deleteAttackSchedule**](SchedulesApi.md#deleteAttackSchedule) | **DELETE** /schedules/attacks/{guid} | Delete an attack schedule.
[**deleteAttackScheduleLegacy**](SchedulesApi.md#deleteAttackScheduleLegacy) | **DELETE** /schedules/{guid} | This functionality has moved to DELETE /schedules/attacks/{guid}
[**deleteScenarioSchedule**](SchedulesApi.md#deleteScenarioSchedule) | **DELETE** /schedules/scenarios/{guid} | Delete a scenario schedule.
[**disableScenarioSchedule**](SchedulesApi.md#disableScenarioSchedule) | **DELETE** /schedules/scenarios/{guid}/enabled | Disable a scenario schedule.
[**enableScenarioSchedule**](SchedulesApi.md#enableScenarioSchedule) | **POST** /schedules/scenarios/{guid}/enabled | Enable a scenario schedule.
[**getAttackSchedules**](SchedulesApi.md#getAttackSchedules) | **GET** /schedules/attacks | Get all active attack schedules.
[**getAttackSchedulesLegacy**](SchedulesApi.md#getAttackSchedulesLegacy) | **GET** /schedules/active | This functionality has moved to GET /schedules/attacks.
[**getScenarioSchedules1**](SchedulesApi.md#getScenarioSchedules1) | **GET** /schedules/scenarios | Get all scenario schedules.
[**getSingleAttackSchedule**](SchedulesApi.md#getSingleAttackSchedule) | **GET** /schedules/attacks/{guid} | Get an attack schedule.
[**getSingleAttackScheduleLegacy**](SchedulesApi.md#getSingleAttackScheduleLegacy) | **GET** /schedules/{guid} | This functionality has moved to GET /schedules/attacks/{guid}.
[**getSingleScenarioSchedule**](SchedulesApi.md#getSingleScenarioSchedule) | **GET** /schedules/scenarios/{guid} | Get a scenario schedule.
[**updateScenarioSchedule**](SchedulesApi.md#updateScenarioSchedule) | **PUT** /schedules/scenarios/{guid} | Update a scenario schedule.


<a name="createAttackSchedule"></a>
# **createAttackSchedule**
> createAttackSchedule(teamId, body)

Create an attack schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
Input body = new Input(); // Input | 
try {
    apiInstance.createAttackSchedule(teamId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#createAttackSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**Input**](Input.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createAttackScheduleLegacy"></a>
# **createAttackScheduleLegacy**
> createAttackScheduleLegacy(teamId, body)

This functionality has moved to POST /schedules/attacks.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
Input body = new Input(); // Input | 
try {
    apiInstance.createAttackScheduleLegacy(teamId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#createAttackScheduleLegacy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**Input**](Input.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="createScenarioSchedule"></a>
# **createScenarioSchedule**
> String createScenarioSchedule(teamId, body)

Create a scenario schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
ScenarioScheduleInput body = new ScenarioScheduleInput(); // ScenarioScheduleInput | 
try {
    String result = apiInstance.createScenarioSchedule(teamId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#createScenarioSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**ScenarioScheduleInput**](ScenarioScheduleInput.md)|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="deleteAttackSchedule"></a>
# **deleteAttackSchedule**
> deleteAttackSchedule(guid, teamId)

Delete an attack schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.deleteAttackSchedule(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#deleteAttackSchedule");
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

<a name="deleteAttackScheduleLegacy"></a>
# **deleteAttackScheduleLegacy**
> deleteAttackScheduleLegacy(guid, teamId)

This functionality has moved to DELETE /schedules/attacks/{guid}

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.deleteAttackScheduleLegacy(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#deleteAttackScheduleLegacy");
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

<a name="deleteScenarioSchedule"></a>
# **deleteScenarioSchedule**
> deleteScenarioSchedule(guid, teamId)

Delete a scenario schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.deleteScenarioSchedule(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#deleteScenarioSchedule");
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

<a name="disableScenarioSchedule"></a>
# **disableScenarioSchedule**
> disableScenarioSchedule(guid, teamId)

Disable a scenario schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.disableScenarioSchedule(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#disableScenarioSchedule");
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

<a name="enableScenarioSchedule"></a>
# **enableScenarioSchedule**
> enableScenarioSchedule(guid, teamId)

Enable a scenario schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.enableScenarioSchedule(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#enableScenarioSchedule");
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

<a name="getAttackSchedules"></a>
# **getAttackSchedules**
> List&lt;ScheduleResponse&gt; getAttackSchedules(teamId)

Get all active attack schedules.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScheduleResponse> result = apiInstance.getAttackSchedules(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#getAttackSchedules");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScheduleResponse&gt;**](ScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAttackSchedulesLegacy"></a>
# **getAttackSchedulesLegacy**
> List&lt;ScheduleResponse&gt; getAttackSchedulesLegacy(teamId)

This functionality has moved to GET /schedules/attacks.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScheduleResponse> result = apiInstance.getAttackSchedulesLegacy(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#getAttackSchedulesLegacy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScheduleResponse&gt;**](ScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getScenarioSchedules1"></a>
# **getScenarioSchedules1**
> List&lt;ScenarioScheduleResponse&gt; getScenarioSchedules1(teamId)

Get all scenario schedules.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScenarioScheduleResponse> result = apiInstance.getScenarioSchedules1(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#getScenarioSchedules1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScenarioScheduleResponse&gt;**](ScenarioScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSingleAttackSchedule"></a>
# **getSingleAttackSchedule**
> ScheduleResponse getSingleAttackSchedule(guid, teamId)

Get an attack schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
ApiGremlinException
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ScheduleResponse result = apiInstance.getSingleAttackSchedule(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#getSingleAttackSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ScheduleResponse**](ScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSingleAttackScheduleLegacy"></a>
# **getSingleAttackScheduleLegacy**
> ScheduleResponse getSingleAttackScheduleLegacy(guid, teamId)

This functionality has moved to GET /schedules/attacks/{guid}.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ScheduleResponse result = apiInstance.getSingleAttackScheduleLegacy(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#getSingleAttackScheduleLegacy");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ScheduleResponse**](ScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSingleScenarioSchedule"></a>
# **getSingleScenarioSchedule**
> ScenarioScheduleResponse getSingleScenarioSchedule(guid, teamId)

Get a scenario schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ScenarioScheduleResponse result = apiInstance.getSingleScenarioSchedule(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#getSingleScenarioSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ScenarioScheduleResponse**](ScenarioScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="updateScenarioSchedule"></a>
# **updateScenarioSchedule**
> String updateScenarioSchedule(guid, teamId, body)

Update a scenario schedule.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import SchedulesApi;


SchedulesApi apiInstance = new SchedulesApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
UpdateScenarioScheduleRequest body = new UpdateScenarioScheduleRequest(); // UpdateScenarioScheduleRequest | 
try {
    String result = apiInstance.updateScenarioSchedule(guid, teamId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling SchedulesApi#updateScenarioSchedule");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**UpdateScenarioScheduleRequest**](UpdateScenarioScheduleRequest.md)|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

