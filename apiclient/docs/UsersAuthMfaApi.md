# UsersAuthMfaApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**auth**](UsersAuthMfaApi.md#auth) | **POST** /users/auth/mfa/auth | Authenticate a user with MFA.
[**disable**](UsersAuthMfaApi.md#disable) | **POST** /users/auth/mfa/disable | Removes the MFA provider and secret, disabling MFA login.
[**enable**](UsersAuthMfaApi.md#enable) | **POST** /users/auth/mfa/enable | Generate a secret key and enables it for the user.
[**forceDisable**](UsersAuthMfaApi.md#forceDisable) | **POST** /users/auth/mfa/forceDisable | Removes the MFA provider and secret, disabling MFA login.
[**getInfo**](UsersAuthMfaApi.md#getInfo) | **GET** /users/auth/mfa/info | Returns the enabled/disabled status and provider if set, of MFA for the user.
[**isEnabled**](UsersAuthMfaApi.md#isEnabled) | **GET** /users/auth/mfa/{email}/enabled | Returns the enabled/disabled status of MFA for a user.
[**validate**](UsersAuthMfaApi.md#validate) | **POST** /users/auth/mfa/validate | Validate a MFA token for a user


<a name="auth"></a>
# **auth**
> auth(email, password, token, companyName, getCompanySession)

Authenticate a user with MFA.



### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthMfaApi;


UsersAuthMfaApi apiInstance = new UsersAuthMfaApi();
String email = "email_example"; // String | 
String password = "password_example"; // String | 
Integer token = 56; // Integer | 
String companyName = "companyName_example"; // String | 
Boolean getCompanySession = true; // Boolean | 
try {
    apiInstance.auth(email, password, token, companyName, getCompanySession);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthMfaApi#auth");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]
 **password** | **String**|  | [optional]
 **token** | **Integer**|  | [optional]
 **companyName** | **String**|  | [optional]
 **getCompanySession** | **Boolean**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="disable"></a>
# **disable**
> disable(email, password, token)

Removes the MFA provider and secret, disabling MFA login.



### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthMfaApi;


UsersAuthMfaApi apiInstance = new UsersAuthMfaApi();
String email = "email_example"; // String | 
String password = "password_example"; // String | 
Integer token = 56; // Integer | 
try {
    apiInstance.disable(email, password, token);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthMfaApi#disable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]
 **password** | **String**|  | [optional]
 **token** | **Integer**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: text/plain

<a name="enable"></a>
# **enable**
> enable(email, password, provider)

Generate a secret key and enables it for the user.



### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthMfaApi;


UsersAuthMfaApi apiInstance = new UsersAuthMfaApi();
String email = "email_example"; // String | 
String password = "password_example"; // String | 
String provider = "provider_example"; // String | 
try {
    apiInstance.enable(email, password, provider);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthMfaApi#enable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]
 **password** | **String**|  | [optional]
 **provider** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="forceDisable"></a>
# **forceDisable**
> forceDisable(email)

Removes the MFA provider and secret, disabling MFA login.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_MFA&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthMfaApi;


UsersAuthMfaApi apiInstance = new UsersAuthMfaApi();
String email = "email_example"; // String | 
try {
    apiInstance.forceDisable(email);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthMfaApi#forceDisable");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: text/plain

<a name="getInfo"></a>
# **getInfo**
> getInfo()

Returns the enabled/disabled status and provider if set, of MFA for the user.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthMfaApi;


UsersAuthMfaApi apiInstance = new UsersAuthMfaApi();
try {
    apiInstance.getInfo();
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthMfaApi#getInfo");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="isEnabled"></a>
# **isEnabled**
> isEnabled(email)

Returns the enabled/disabled status of MFA for a user.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_MFA&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthMfaApi;


UsersAuthMfaApi apiInstance = new UsersAuthMfaApi();
String email = "email_example"; // String | 
try {
    apiInstance.isEnabled(email);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthMfaApi#isEnabled");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="validate"></a>
# **validate**
> validate(email, token)

Validate a MFA token for a user



### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthMfaApi;


UsersAuthMfaApi apiInstance = new UsersAuthMfaApi();
String email = "email_example"; // String | 
Integer token = 56; // Integer | 
try {
    apiInstance.validate(email, token);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthMfaApi#validate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]
 **token** | **Integer**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: text/plain

