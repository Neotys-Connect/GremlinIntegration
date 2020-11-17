# CompaniesApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**getClientsForCompany**](CompaniesApi.md#getClientsForCompany) | **GET** /companies/{identifier}/clients | Returns all clients for the supplied company
[**getCompany**](CompaniesApi.md#getCompany) | **GET** /companies/{identifier} | Gets a Company by its supplied guid
[**getUsersForCompany**](CompaniesApi.md#getUsersForCompany) | **GET** /companies/{identifier}/users | Returns all users for the supplied company
[**inviteUsersToCompany**](CompaniesApi.md#inviteUsersToCompany) | **POST** /companies/{identifier}/invites | Invite one or more users to join your Gremlin company
[**rbacRevoke**](CompaniesApi.md#rbacRevoke) | **DELETE** /companies/{identifier}/users/{email}/active | Deactivates a user.
[**rbacRevokeInvite**](CompaniesApi.md#rbacRevokeInvite) | **DELETE** /companies/{identifier}/invites/{email} | Revoke a pending user invite.
[**rbacUnrevoke**](CompaniesApi.md#rbacUnrevoke) | **POST** /companies/{identifier}/users/{email}/active | Activates a user.
[**rbacUpdate**](CompaniesApi.md#rbacUpdate) | **PUT** /companies/{identifier}/users/{email} | Update roles of existing user.
[**updateCompanyPrefs**](CompaniesApi.md#updateCompanyPrefs) | **PATCH** /companies/{identifier} | Update the prefs for company
[**updateMfaPrefs**](CompaniesApi.md#updateMfaPrefs) | **POST** /companies/{identifier}/mfaPrefs | Updates the MFA preferences associated with this Company.
[**updatePrefs**](CompaniesApi.md#updatePrefs) | **POST** /companies/{identifier}/prefs | Updates the preferences associated with this Company.
[**updateSamlProperties**](CompaniesApi.md#updateSamlProperties) | **POST** /companies/{identifier}/saml/props | Updates the preferences associated with this Company.


<a name="getClientsForCompany"></a>
# **getClientsForCompany**
> getClientsForCompany(identifier)

Returns all clients for the supplied company

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;READ_ALL_CLIENTS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
try {
    apiInstance.getClientsForCompany(identifier);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#getClientsForCompany");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getCompany"></a>
# **getCompany**
> getCompany(identifier)

Gets a Company by its supplied guid

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
try {
    apiInstance.getCompany(identifier);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#getCompany");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="getUsersForCompany"></a>
# **getUsersForCompany**
> getUsersForCompany(identifier)

Returns all users for the supplied company

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;READ_ALL_USERS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
try {
    apiInstance.getUsersForCompany(identifier);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#getUsersForCompany");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="inviteUsersToCompany"></a>
# **inviteUsersToCompany**
> inviteUsersToCompany(identifier, body)

Invite one or more users to join your Gremlin company

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;ADD_USER_TO_COMPANY&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
String body = "body_example"; // String | 
try {
    apiInstance.inviteUsersToCompany(identifier, body);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#inviteUsersToCompany");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **body** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="rbacRevoke"></a>
# **rbacRevoke**
> rbacRevoke(identifier, email)

Deactivates a user.

Once deactivated, user will not be able to do anything on company  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;DEACTIVATE_USER&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
String email = "email_example"; // String | 
try {
    apiInstance.rbacRevoke(identifier, email);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#rbacRevoke");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **email** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="rbacRevokeInvite"></a>
# **rbacRevokeInvite**
> rbacRevokeInvite(identifier, email)

Revoke a pending user invite.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;DEACTIVATE_USER&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
String email = "email_example"; // String | 
try {
    apiInstance.rbacRevokeInvite(identifier, email);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#rbacRevokeInvite");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **email** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="rbacUnrevoke"></a>
# **rbacUnrevoke**
> rbacUnrevoke(identifier, email)

Activates a user.

User must exist. This is primarily used to reactivate a deactivated user.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;ACTIVATE_USER&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
String email = "email_example"; // String | 
try {
    apiInstance.rbacUnrevoke(identifier, email);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#rbacUnrevoke");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **email** | **String**|  |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="rbacUpdate"></a>
# **rbacUpdate**
> rbacUpdate(identifier, email, body)

Update roles of existing user.

User must exist.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_COMPANY_USER_PERMISSIONS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
String email = "email_example"; // String | 
String body = "body_example"; // String | 
try {
    apiInstance.rbacUpdate(identifier, email, body);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#rbacUpdate");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **email** | **String**|  |
 **body** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="updateCompanyPrefs"></a>
# **updateCompanyPrefs**
> updateCompanyPrefs(identifier, body)

Update the prefs for company

This endpoint will allow you to update the prefs for a company based on its identifier.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_COMPANY_PREFS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
CompanyPatchInput body = new CompanyPatchInput(); // CompanyPatchInput | 
try {
    apiInstance.updateCompanyPrefs(identifier, body);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#updateCompanyPrefs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **body** | [**CompanyPatchInput**](CompanyPatchInput.md)|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="updateMfaPrefs"></a>
# **updateMfaPrefs**
> updateMfaPrefs(identifier, forceMfa, mfaProviders, defaultMfaProvider)

Updates the MFA preferences associated with this Company.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_MFA&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
Boolean forceMfa = false; // Boolean | 
List<String> mfaProviders = Arrays.asList("mfaProviders_example"); // List<String> | 
String defaultMfaProvider = "defaultMfaProvider_example"; // String | 
try {
    apiInstance.updateMfaPrefs(identifier, forceMfa, mfaProviders, defaultMfaProvider);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#updateMfaPrefs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **forceMfa** | **Boolean**|  | [optional] [default to false]
 **mfaProviders** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **defaultMfaProvider** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: text/plain

<a name="updatePrefs"></a>
# **updatePrefs**
> updatePrefs(identifier, domain)

Updates the preferences associated with this Company.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_COMPANY_PREFS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
String domain = "domain_example"; // String | 
try {
    apiInstance.updatePrefs(identifier, domain);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#updatePrefs");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **domain** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: text/plain

<a name="updateSamlProperties"></a>
# **updateSamlProperties**
> updateSamlProperties(identifier, enabled, entityId, idpUrl, certificate, forced)

Updates the preferences associated with this Company.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_SAML&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import CompaniesApi;


CompaniesApi apiInstance = new CompaniesApi();
String identifier = "identifier_example"; // String | 
String enabled = "enabled_example"; // String | 
String entityId = "entityId_example"; // String | 
String idpUrl = "idpUrl_example"; // String | 
String certificate = "certificate_example"; // String | 
String forced = "forced_example"; // String | 
try {
    apiInstance.updateSamlProperties(identifier, enabled, entityId, idpUrl, certificate, forced);
} catch (ApiException e) {
    System.err.println("Exception when calling CompaniesApi#updateSamlProperties");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **identifier** | **String**|  |
 **enabled** | **String**|  | [optional]
 **entityId** | **String**|  | [optional]
 **idpUrl** | **String**|  | [optional]
 **certificate** | **String**|  | [optional]
 **forced** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: text/plain

