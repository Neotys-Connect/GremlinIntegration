# StatusChecksApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createWebhook**](StatusChecksApi.md#createWebhook) | **POST** /{parameter} | 
[**delete1**](StatusChecksApi.md#delete1) | **DELETE** /{parameter}/{identifier} | 
[**getStatusCheck**](StatusChecksApi.md#getStatusCheck) | **GET** /{parameter}/{identifier} | 
[**getStatusChecks**](StatusChecksApi.md#getStatusChecks) | **GET** /{parameter} | 
[**testEvaluationConfiguration**](StatusChecksApi.md#testEvaluationConfiguration) | **POST** /{parameter}/{parameter} | Test an evaluation configuration.
[**update1**](StatusChecksApi.md#update1) | **PUT** /{parameter}/{identifier} | 


<a name="createWebhook"></a>
# **createWebhook**
> createWebhook(body, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import StatusChecksApi;


StatusChecksApi apiInstance = new StatusChecksApi();
StatusCheckRequest body = new StatusCheckRequest(); // StatusCheckRequest | status check to create
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.createWebhook(body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling StatusChecksApi#createWebhook");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**StatusCheckRequest**](StatusCheckRequest.md)| status check to create | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="delete1"></a>
# **delete1**
> delete1(identifier, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import StatusChecksApi;


StatusChecksApi apiInstance = new StatusChecksApi();
String identifier = "identifier_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.delete1(identifier, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling StatusChecksApi#delete1");
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
 - **Accept**: application/json

<a name="getStatusCheck"></a>
# **getStatusCheck**
> StatusCheck getStatusCheck(identifier, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import StatusChecksApi;


StatusChecksApi apiInstance = new StatusChecksApi();
String identifier = "identifier_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    StatusCheck result = apiInstance.getStatusCheck(identifier, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StatusChecksApi#getStatusCheck");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**StatusCheck**](StatusCheck.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getStatusChecks"></a>
# **getStatusChecks**
> List&lt;StatusCheck&gt; getStatusChecks(teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import StatusChecksApi;


StatusChecksApi apiInstance = new StatusChecksApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<StatusCheck> result = apiInstance.getStatusChecks(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StatusChecksApi#getStatusChecks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;StatusCheck&gt;**](StatusCheck.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="testEvaluationConfiguration"></a>
# **testEvaluationConfiguration**
> TestEvaluationConfigurationResponse testEvaluationConfiguration(teamId, body)

Test an evaluation configuration.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import StatusChecksApi;


StatusChecksApi apiInstance = new StatusChecksApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
TestEvaluationConfigurationRequest body = new TestEvaluationConfigurationRequest(); // TestEvaluationConfigurationRequest | 
try {
    TestEvaluationConfigurationResponse result = apiInstance.testEvaluationConfiguration(teamId, body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling StatusChecksApi#testEvaluationConfiguration");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**TestEvaluationConfigurationRequest**](TestEvaluationConfigurationRequest.md)|  | [optional]

### Return type

[**TestEvaluationConfigurationResponse**](TestEvaluationConfigurationResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="update1"></a>
# **update1**
> update1(identifier, body, teamId)



# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import StatusChecksApi;


StatusChecksApi apiInstance = new StatusChecksApi();
String identifier = "identifier_example"; // String | 
StatusCheckRequest body = new StatusCheckRequest(); // StatusCheckRequest | update status check request
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.update1(identifier, body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling StatusChecksApi#update1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **body** | [**StatusCheckRequest**](StatusCheckRequest.md)| update status check request | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

