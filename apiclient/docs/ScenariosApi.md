# ScenariosApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**archive**](ScenariosApi.md#archive) | **POST** /scenarios/{guid}/archive | Archive a scenario.
[**createNewScenario**](ScenariosApi.md#createNewScenario) | **POST** /scenarios | Create a new scenario.
[**createNewSharedScenario**](ScenariosApi.md#createNewSharedScenario) | **POST** /scenarios/shared | Create new shared scenarios.
[**getActive1**](ScenariosApi.md#getActive1) | **GET** /scenarios/active | List all active scenarios.
[**getAllRunsForTeam**](ScenariosApi.md#getAllRunsForTeam) | **GET** /scenarios/runs | List all scenario runs for your team.
[**getArchived**](ScenariosApi.md#getArchived) | **GET** /scenarios/archived | List all archived scenarios.
[**getDrafts**](ScenariosApi.md#getDrafts) | **GET** /scenarios/drafts | List all draft scenarios.
[**getRunnable**](ScenariosApi.md#getRunnable) | **GET** /scenarios | List all runnable scenarios.
[**getRuns**](ScenariosApi.md#getRuns) | **GET** /scenarios/{guid}/runs | List all runs for a scenario.
[**getScenario**](ScenariosApi.md#getScenario) | **GET** /scenarios/{guid} | Get details about a scenario.
[**getScenarioRun**](ScenariosApi.md#getScenarioRun) | **GET** /scenarios/{guid}/runs/{runNumber} | Get details about a scenario run.
[**getScenarioSchedules**](ScenariosApi.md#getScenarioSchedules) | **GET** /scenarios/{guid}/schedules | Get all schedules for a scenario.
[**getSharedScenario**](ScenariosApi.md#getSharedScenario) | **GET** /scenarios/shared/{guid} | Get details on a shared scenarios.
[**getSharedScenariosForCompany**](ScenariosApi.md#getSharedScenariosForCompany) | **GET** /scenarios/shared | Get all company shared scenarios.
[**haltAsPost**](ScenariosApi.md#haltAsPost) | **POST** /scenarios/halt/{guid}/runs/{runNumber} | Idempotently halt the specified scenario run.
[**restore**](ScenariosApi.md#restore) | **POST** /scenarios/{guid}/restore | Restore an archived scenario.
[**runScenario**](ScenariosApi.md#runScenario) | **POST** /scenarios/{guid}/runs | Run a scenario.
[**setScenarioRunResultFlags**](ScenariosApi.md#setScenarioRunResultFlags) | **PUT** /scenarios/{guid}/runs/{runNumber}/resultFlags | This functionality has been replaced by PUT /{guid}/runs/{runNumber}/results.
[**setScenarioRunResultNotes**](ScenariosApi.md#setScenarioRunResultNotes) | **PUT** /scenarios/{guid}/runs/{runNumber}/resultNotes | Update the result notes of a scenario run.
[**setScenarioRunResults**](ScenariosApi.md#setScenarioRunResults) | **PUT** /scenarios/{guid}/runs/{runNumber}/results | Update the results of a scenario run.
[**unshareScenario**](ScenariosApi.md#unshareScenario) | **DELETE** /scenarios/shared/{guid} | Unshare a company shared scenario.
[**updateScenario**](ScenariosApi.md#updateScenario) | **PUT** /scenarios/{guid} | Update a scenario


<a name="archive"></a>
# **archive**
> archive(guid, teamId)

Archive a scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.archive(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#archive");
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

<a name="createNewScenario"></a>
# **createNewScenario**
> String createNewScenario(teamId, body)

Create a new scenario.

Please note that if the &#x60;labels&#x60; or &#x60;tags&#x60; fields are not provided, no filtering will be employed and a scenario will target all active clients within your team.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
ApiGremlinException
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
ScenarioInput body = new ScenarioInput(); // ScenarioInput | 
try {
    String result = apiInstance.createNewScenario(teamId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#createNewScenario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**ScenarioInput**](ScenarioInput.md)|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="createNewSharedScenario"></a>
# **createNewSharedScenario**
> createNewSharedScenario(teamId, body)

Create new shared scenarios.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;SHARE_SCENARIO&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
List<Object> body = Arrays.asList(new List<Object>()); // List<Object> | 
try {
    apiInstance.createNewSharedScenario(teamId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#createNewSharedScenario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | **List&lt;Object&gt;**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json, text/plain

<a name="getActive1"></a>
# **getActive1**
> List&lt;ScenarioResponse&gt; getActive1(teamId)

List all active scenarios.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScenarioResponse> result = apiInstance.getActive1(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getActive1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScenarioResponse&gt;**](ScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAllRunsForTeam"></a>
# **getAllRunsForTeam**
> List&lt;ScenarioRunResponse&gt; getAllRunsForTeam(state, includeArchived, startDate, endDate, teamId)

List all scenario runs for your team.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String state = "state_example"; // String | 
String includeArchived = "includeArchived_example"; // String | 
String startDate = "startDate_example"; // String | 
String endDate = "endDate_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScenarioRunResponse> result = apiInstance.getAllRunsForTeam(state, includeArchived, startDate, endDate, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getAllRunsForTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **state** | **String**|  | [optional]
 **includeArchived** | **String**|  | [optional]
 **startDate** | **String**|  | [optional]
 **endDate** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScenarioRunResponse&gt;**](ScenarioRunResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getArchived"></a>
# **getArchived**
> List&lt;ScenarioResponse&gt; getArchived(teamId)

List all archived scenarios.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScenarioResponse> result = apiInstance.getArchived(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getArchived");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScenarioResponse&gt;**](ScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getDrafts"></a>
# **getDrafts**
> List&lt;ScenarioResponse&gt; getDrafts(teamId)

List all draft scenarios.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScenarioResponse> result = apiInstance.getDrafts(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getDrafts");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScenarioResponse&gt;**](ScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRunnable"></a>
# **getRunnable**
> List&lt;ScenarioResponse&gt; getRunnable(teamId)

List all runnable scenarios.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScenarioResponse> result = apiInstance.getRunnable(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getRunnable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScenarioResponse&gt;**](ScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getRuns"></a>
# **getRuns**
> List&lt;ScenarioRunResponse&gt; getRuns(guid, startDate, endDate, teamId)

List all runs for a scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
String startDate = "startDate_example"; // String | 
String endDate = "endDate_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScenarioRunResponse> result = apiInstance.getRuns(guid, startDate, endDate, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getRuns");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **startDate** | **String**|  | [optional]
 **endDate** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScenarioRunResponse&gt;**](ScenarioRunResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getScenario"></a>
# **getScenario**
> ScenarioResponse getScenario(guid, teamId)

Get details about a scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ScenarioResponse result = apiInstance.getScenario(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getScenario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ScenarioResponse**](ScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getScenarioRun"></a>
# **getScenarioRun**
> ScenarioRunResponse getScenarioRun(guid, runNumber, teamId)

Get details about a scenario run.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Long runNumber = 789L; // Long | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ScenarioRunResponse result = apiInstance.getScenarioRun(guid, runNumber, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getScenarioRun");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **runNumber** | **Long**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ScenarioRunResponse**](ScenarioRunResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getScenarioSchedules"></a>
# **getScenarioSchedules**
> List&lt;ScenarioScheduleResponse&gt; getScenarioSchedules(guid, teamId)

Get all schedules for a scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<ScenarioScheduleResponse> result = apiInstance.getScenarioSchedules(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getScenarioSchedules");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;ScenarioScheduleResponse&gt;**](ScenarioScheduleResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getSharedScenario"></a>
# **getSharedScenario**
> SharedScenarioResponse getSharedScenario(guid)

Get details on a shared scenarios.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
try {
    SharedScenarioResponse result = apiInstance.getSharedScenario(guid);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getSharedScenario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |

### Return type

[**SharedScenarioResponse**](SharedScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="getSharedScenariosForCompany"></a>
# **getSharedScenariosForCompany**
> List&lt;SharedScenarioResponse&gt; getSharedScenariosForCompany()

Get all company shared scenarios.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
try {
    List<SharedScenarioResponse> result = apiInstance.getSharedScenariosForCompany();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#getSharedScenariosForCompany");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;SharedScenarioResponse&gt;**](SharedScenarioResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

<a name="haltAsPost"></a>
# **haltAsPost**
> haltAsPost(guid, runNumber, body, teamId)

Idempotently halt the specified scenario run.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Long runNumber = 789L; // Long | 
HaltRequest body = new HaltRequest(); // HaltRequest | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.haltAsPost(guid, runNumber, body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#haltAsPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **runNumber** | **Long**|  |
 **body** | [**HaltRequest**](HaltRequest.md)|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="restore"></a>
# **restore**
> restore(guid, teamId)

Restore an archived scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.restore(guid, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#restore");
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

<a name="runScenario"></a>
# **runScenario**
> String runScenario(guid, teamId, body)

Run a scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
ScenarioRunInput body = new ScenarioRunInput(); // ScenarioRunInput | 
try {
    String result = apiInstance.runScenario(guid, teamId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#runScenario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**ScenarioRunInput**](ScenarioRunInput.md)|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="setScenarioRunResultFlags"></a>
# **setScenarioRunResultFlags**
> setScenarioRunResultFlags(guid, runNumber, teamId, body)

This functionality has been replaced by PUT /{guid}/runs/{runNumber}/results.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Long runNumber = 789L; // Long | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
Object body = null; // Object | 
try {
    apiInstance.setScenarioRunResultFlags(guid, runNumber, teamId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#setScenarioRunResultFlags");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **runNumber** | **Long**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | **Object**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="setScenarioRunResultNotes"></a>
# **setScenarioRunResultNotes**
> setScenarioRunResultNotes(guid, runNumber, body, teamId)

Update the result notes of a scenario run.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Long runNumber = 789L; // Long | 
String body = "body_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.setScenarioRunResultNotes(guid, runNumber, body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#setScenarioRunResultNotes");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **runNumber** | **Long**|  |
 **body** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: text/plain
 - **Accept**: text/plain

<a name="setScenarioRunResults"></a>
# **setScenarioRunResults**
> setScenarioRunResults(guid, runNumber, teamId, body)

Update the results of a scenario run.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Long runNumber = 789L; // Long | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
ScenarioRunResults body = new ScenarioRunResults(); // ScenarioRunResults | 
try {
    apiInstance.setScenarioRunResults(guid, runNumber, teamId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#setScenarioRunResults");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **runNumber** | **Long**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**ScenarioRunResults**](ScenarioRunResults.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="unshareScenario"></a>
# **unshareScenario**
> unshareScenario(guid)

Unshare a company shared scenario.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;UNSHARE_SCENARIO&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
try {
    apiInstance.unshareScenario(guid);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#unshareScenario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="updateScenario"></a>
# **updateScenario**
> updateScenario(guid, teamId, body)

Update a scenario

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ScenariosApi;


ScenariosApi apiInstance = new ScenariosApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
UpdateScenarioInput body = new UpdateScenarioInput(); // UpdateScenarioInput | 
try {
    apiInstance.updateScenario(guid, teamId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ScenariosApi#updateScenario");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**UpdateScenarioInput**](UpdateScenarioInput.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

