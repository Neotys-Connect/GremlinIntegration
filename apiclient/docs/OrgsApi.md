# OrgsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**addNewCertificate**](OrgsApi.md#addNewCertificate) | **POST** /orgs/auth/certificate | Rolls over to use a new certificate.  The current certificate will be saved and still valid for authentication, providing a transition period.
[**create2**](OrgsApi.md#create2) | **POST** /orgs | Creates a new org with provided name.
[**info**](OrgsApi.md#info) | **GET** /orgs/{identifier} | Get the specified Org.
[**info1**](OrgsApi.md#info1) | **GET** /orgs | Get all Orgs.
[**invalidateOldCertificate**](OrgsApi.md#invalidateOldCertificate) | **DELETE** /orgs/auth/certificate/old | Deletes the old certificate for this org.  This is intended for when a transition to new certificates has been completed, or when the old certificate has been compromised.
[**replaceCertificate**](OrgsApi.md#replaceCertificate) | **DELETE** /orgs/auth/certificate | Deletes the current credentials and generates new.  For use when the current credentials are compromised.
[**secretReset**](OrgsApi.md#secretReset) | **POST** /orgs/auth/secret/reset | Resets the secret for this Org.


<a name="addNewCertificate"></a>
# **addNewCertificate**
> addNewCertificate(teamId)

Rolls over to use a new certificate.  The current certificate will be saved and still valid for authentication, providing a transition period.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_TEAM_CREDENTIALS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import OrgsApi;


OrgsApi apiInstance = new OrgsApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.addNewCertificate(teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrgsApi#addNewCertificate");
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
 - **Accept**: application/octet-stream

<a name="create2"></a>
# **create2**
> create2(name, addUser)

Creates a new org with provided name.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;CREATE_REMOVE_TEAM&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import OrgsApi;


OrgsApi apiInstance = new OrgsApi();
String name = "name_example"; // String | 
Boolean addUser = true; // Boolean | 
try {
    apiInstance.create2(name, addUser);
} catch (ApiException e) {
    System.err.println("Exception when calling OrgsApi#create2");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **name** | **String**|  | [optional]
 **addUser** | **Boolean**|  | [optional] [default to true]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="info"></a>
# **info**
> Org info(identifier, prefs)

Get the specified Org.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import OrgsApi;


OrgsApi apiInstance = new OrgsApi();
String identifier = "identifier_example"; // String | 
Boolean prefs = true; // Boolean | 
try {
    Org result = apiInstance.info(identifier, prefs);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrgsApi#info");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **prefs** | **Boolean**|  | [optional]

### Return type

[**Org**](Org.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="info1"></a>
# **info1**
> List&lt;Org&gt; info1(prefs)

Get all Orgs.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import OrgsApi;


OrgsApi apiInstance = new OrgsApi();
Boolean prefs = true; // Boolean | 
try {
    List<Org> result = apiInstance.info1(prefs);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling OrgsApi#info1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **prefs** | **Boolean**|  | [optional]

### Return type

[**List&lt;Org&gt;**](Org.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="invalidateOldCertificate"></a>
# **invalidateOldCertificate**
> invalidateOldCertificate(teamId)

Deletes the old certificate for this org.  This is intended for when a transition to new certificates has been completed, or when the old certificate has been compromised.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_TEAM_CREDENTIALS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import OrgsApi;


OrgsApi apiInstance = new OrgsApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.invalidateOldCertificate(teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrgsApi#invalidateOldCertificate");
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

<a name="replaceCertificate"></a>
# **replaceCertificate**
> replaceCertificate(teamId)

Deletes the current credentials and generates new.  For use when the current credentials are compromised.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_TEAM_CREDENTIALS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import OrgsApi;


OrgsApi apiInstance = new OrgsApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.replaceCertificate(teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrgsApi#replaceCertificate");
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
 - **Accept**: application/octet-stream

<a name="secretReset"></a>
# **secretReset**
> secretReset(identifier, teamId)

Resets the secret for this Org.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_TEAM_CREDENTIALS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import OrgsApi;


OrgsApi apiInstance = new OrgsApi();
String identifier = "identifier_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.secretReset(identifier, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling OrgsApi#secretReset");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

