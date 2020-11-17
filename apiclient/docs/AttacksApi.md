# AttacksApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**active1**](AttacksApi.md#active1) | **GET** /attacks/active | List all active attacks.
[**all**](AttacksApi.md#all) | **GET** /attacks | List all attacks.
[**completed1**](AttacksApi.md#completed1) | **GET** /attacks/completed | List all completed attacks.
[**create**](AttacksApi.md#create) | **POST** /attacks/new | Create a new attack.
[**get**](AttacksApi.md#get) | **GET** /attacks/{guid} | Get details about an attack.
[**halt**](AttacksApi.md#halt) | **DELETE** /attacks/{guid} | Idempotently halt the specified active attack.
[**halt1**](AttacksApi.md#halt1) | **DELETE** /attacks | Idempotently halt all active attacks


<a name="active1"></a>
# **active1**
> List&lt;Task&gt; active1(source, pageSize, teamId)

List all active attacks.

This endpoint will return all active attacks for the team.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AttacksApi;


AttacksApi apiInstance = new AttacksApi();
String source = "Adhoc"; // String | Filter attacks to either adhoc or scenario.
Integer pageSize = 56; // Integer | This value determines how many results will be returned per call.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Task> result = apiInstance.active1(source, pageSize, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttacksApi#active1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **source** | **String**| Filter attacks to either adhoc or scenario. | [optional] [default to Adhoc] [enum: Adhoc, Scenario]
 **pageSize** | **Integer**| This value determines how many results will be returned per call. | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="all"></a>
# **all**
> List&lt;Task&gt; all(source, pageSize, teamId)

List all attacks.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AttacksApi;


AttacksApi apiInstance = new AttacksApi();
String source = "Adhoc"; // String | Filter attacks to either adhoc or scenario.
Integer pageSize = 56; // Integer | This value determines how many results will be returned per call.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Task> result = apiInstance.all(source, pageSize, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttacksApi#all");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **source** | **String**| Filter attacks to either adhoc or scenario. | [optional] [default to Adhoc] [enum: Adhoc, Scenario]
 **pageSize** | **Integer**| This value determines how many results will be returned per call. | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="completed1"></a>
# **completed1**
> List&lt;Task&gt; completed1(source, pageSize, teamId)

List all completed attacks.

This endpoint will return all completed attacks that the team has performed.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
ApiGremlinException
//import AttacksApi;


AttacksApi apiInstance = new AttacksApi();
String source = "Adhoc"; // String | Filter attacks to either adhoc or scenario.
Integer pageSize = 56; // Integer | This value determines how many results will be returned per call.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Task> result = apiInstance.completed1(source, pageSize, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttacksApi#completed1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **source** | **String**| Filter attacks to either adhoc or scenario. | [optional] [default to Adhoc] [enum: Adhoc, Scenario]
 **pageSize** | **Integer**| This value determines how many results will be returned per call. | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="create"></a>
# **create**
> String create(teamId, body)

Create a new attack.

For a list of attack parameters, please visit: https://www.gremlin.com/docs/infrastructure-layer/attacks/#parameter-reference. Please note that if the &#x60;labels&#x60; or &#x60;tags&#x60; fields are not provided, no filtering will be employed and an attack will target all active clients within your team. For more infomation on creating a new attack using the API, please visit: https://www.gremlin.com/docs/api-reference/examples/  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AttacksApi;


AttacksApi apiInstance = new AttacksApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
TaskInput body = new TaskInput(); // TaskInput | 
try {
    String result = apiInstance.create(teamId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttacksApi#create");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**TaskInput**](TaskInput.md)|  | [optional]

### Return type

**String**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="get"></a>
# **get**
> Task get(guid, teamId)

Get details about an attack.

This endpoint will allow you to get info on a specific attack based on its guid.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AttacksApi;


AttacksApi apiInstance = new AttacksApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    Task result = apiInstance.get(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttacksApi#get");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**Task**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="halt"></a>
# **halt**
> List&lt;Task&gt; halt(guid, teamId)

Idempotently halt the specified active attack.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AttacksApi;


AttacksApi apiInstance = new AttacksApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Task> result = apiInstance.halt(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttacksApi#halt");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="halt1"></a>
# **halt1**
> List&lt;Task&gt; halt1(teamId)

Idempotently halt all active attacks

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import AttacksApi;


AttacksApi apiInstance = new AttacksApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<Task> result = apiInstance.halt1(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling AttacksApi#halt1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;Task&gt;**](Task.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

