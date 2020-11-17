# UsersAuthApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**auth1**](UsersAuthApi.md#auth1) | **POST** /users/auth | Authenticate a user.
[**companyAffiliationsEmail**](UsersAuthApi.md#companyAffiliationsEmail) | **GET** /users/auth/emailCompanies | Email active company affiliations.
[**invalidate**](UsersAuthApi.md#invalidate) | **DELETE** /users/auth | Invalidates a user&#39;s current session, if it exists.
[**samlMetadata**](UsersAuthApi.md#samlMetadata) | **GET** /users/auth/saml/metadata | Gets SAML Service Provider metadata.


<a name="auth1"></a>
# **auth1**
> auth1(email, password, companyName, getCompanySession)

Authenticate a user.



### Example
```java
// Import classes:
ApiGremlinException
//import UsersAuthApi;


UsersAuthApi apiInstance = new UsersAuthApi();
String email = "email_example"; // String | 
String password = "password_example"; // String | 
String companyName = "companyName_example"; // String | 
Boolean getCompanySession = true; // Boolean | 
try {
    apiInstance.auth1(email, password, companyName, getCompanySession);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthApi#auth1");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]
 **password** | **String**|  | [optional]
 **companyName** | **String**|  | [optional]
 **getCompanySession** | **Boolean**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="companyAffiliationsEmail"></a>
# **companyAffiliationsEmail**
> companyAffiliationsEmail(email)

Email active company affiliations.



### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthApi;


UsersAuthApi apiInstance = new UsersAuthApi();
String email = "email_example"; // String | 
try {
    apiInstance.companyAffiliationsEmail(email);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthApi#companyAffiliationsEmail");
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

<a name="invalidate"></a>
# **invalidate**
> invalidate()

Invalidates a user&#39;s current session, if it exists.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthApi;


UsersAuthApi apiInstance = new UsersAuthApi();
try {
    apiInstance.invalidate();
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthApi#invalidate");
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

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="samlMetadata"></a>
# **samlMetadata**
> samlMetadata(companyName)

Gets SAML Service Provider metadata.



### Example
```java
// Import classes:
//import ApiException;
//import UsersAuthApi;


UsersAuthApi apiInstance = new UsersAuthApi();
String companyName = "companyName_example"; // String | 
try {
    apiInstance.samlMetadata(companyName);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersAuthApi#samlMetadata");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **companyName** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/xml

