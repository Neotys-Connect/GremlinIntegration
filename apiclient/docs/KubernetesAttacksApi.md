# KubernetesAttacksApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**createAttack**](KubernetesAttacksApi.md#createAttack) | **POST** /kubernetes/attacks/new | Create an attack
[**getAttack**](KubernetesAttacksApi.md#getAttack) | **GET** /kubernetes/attacks/{guid} | Get an attack by it&#39;s guid
[**getAttacks**](KubernetesAttacksApi.md#getAttacks) | **GET** /kubernetes/attacks | List all attacks.
[**haltAllAttacks**](KubernetesAttacksApi.md#haltAllAttacks) | **POST** /kubernetes/attacks/halt | Halt all active attacks
[**haltAttack**](KubernetesAttacksApi.md#haltAttack) | **POST** /kubernetes/attacks/{uid}/halt | Halt an active attack


<a name="createAttack"></a>
# **createAttack**
> createAttack(teamId, body)

Create an attack

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import KubernetesAttacksApi;


KubernetesAttacksApi apiInstance = new KubernetesAttacksApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
Attack body = new Attack(); // Attack | 
try {
    apiInstance.createAttack(teamId, body);
} catch (ApiException e) {
    System.err.println("Exception when calling KubernetesAttacksApi#createAttack");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]
 **body** | [**Attack**](Attack.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="getAttack"></a>
# **getAttack**
> AttackResponse getAttack(guid, teamId)

Get an attack by it&#39;s guid

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import KubernetesAttacksApi;


KubernetesAttacksApi apiInstance = new KubernetesAttacksApi();
String guid = "guid_example"; // String | This value represents the globally unique identifier of the record to fetch.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    AttackResponse result = apiInstance.getAttack(guid, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling KubernetesAttacksApi#getAttack");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **guid** | **String**| This value represents the globally unique identifier of the record to fetch. |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**AttackResponse**](AttackResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getAttacks"></a>
# **getAttacks**
> List&lt;AttackResponse&gt; getAttacks(source, teamId)

List all attacks.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import KubernetesAttacksApi;


KubernetesAttacksApi apiInstance = new KubernetesAttacksApi();
String source = "Adhoc"; // String | Filter Kubernetes attacks to either Adhoc or Scenario.
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<AttackResponse> result = apiInstance.getAttacks(source, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling KubernetesAttacksApi#getAttacks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **source** | **String**| Filter Kubernetes attacks to either Adhoc or Scenario. | [optional] [default to Adhoc] [enum: Adhoc, Scenario]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;AttackResponse&gt;**](AttackResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="haltAllAttacks"></a>
# **haltAllAttacks**
> haltAllAttacks(body, teamId)

Halt all active attacks

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import KubernetesAttacksApi;


KubernetesAttacksApi apiInstance = new KubernetesAttacksApi();
HaltRequest body = new HaltRequest(); // HaltRequest | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.haltAllAttacks(body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling KubernetesAttacksApi#haltAllAttacks");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**HaltRequest**](HaltRequest.md)|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

<a name="haltAttack"></a>
# **haltAttack**
> haltAttack(uid, body, teamId)

Halt an active attack

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import KubernetesAttacksApi;


KubernetesAttacksApi apiInstance = new KubernetesAttacksApi();
String uid = "uid_example"; // String | 
HaltRequest body = new HaltRequest(); // HaltRequest | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.haltAttack(uid, body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling KubernetesAttacksApi#haltAttack");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **uid** | **String**|  |
 **body** | [**HaltRequest**](HaltRequest.md)|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: Not defined

