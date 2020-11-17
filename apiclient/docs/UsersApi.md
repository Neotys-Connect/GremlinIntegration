# UsersApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**active3**](UsersApi.md#active3) | **GET** /users/active | Get all active users.
[**addUserToTeam**](UsersApi.md#addUserToTeam) | **POST** /users | Add an existing user to the target team
[**all3**](UsersApi.md#all3) | **GET** /users | Get all users.
[**authRenew**](UsersApi.md#authRenew) | **POST** /users/renew | Renew authorization.
[**getSelf**](UsersApi.md#getSelf) | **GET** /users/self | Get information about the authenticated user
[**invite**](UsersApi.md#invite) | **POST** /users/invite | Invite a user.
[**rbacAuthRenew**](UsersApi.md#rbacAuthRenew) | **POST** /users/renew/rbac | Renew authorization.
[**rbacUpdateSelf**](UsersApi.md#rbacUpdateSelf) | **PATCH** /users/self | Update an existing users info.
[**refreshSessions**](UsersApi.md#refreshSessions) | **GET** /users/sessions | Returns the updated user sessions list for the currently authenticated user.
[**revokeInvite**](UsersApi.md#revokeInvite) | **DELETE** /users/invite/{email} | Revoke a pending user invite.
[**revokeOrRemoveFromTeam**](UsersApi.md#revokeOrRemoveFromTeam) | **DELETE** /users/{email} | Deactivate a user.
[**update**](UsersApi.md#update) | **PUT** /users/{email} | Update an existing user.


<a name="active3"></a>
# **active3**
> List&lt;TeamUserInfo&gt; active3(teamId)

Get all active users.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;READ_TEAM_USERS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<TeamUserInfo> result = apiInstance.active3(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#active3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;TeamUserInfo&gt;**](TeamUserInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="addUserToTeam"></a>
# **addUserToTeam**
> addUserToTeam(body, teamId)

Add an existing user to the target team

User must belong to this teams company  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;ADD_REMOVE_USER_FROM_TEAM&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
String body = "body_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.addUserToTeam(body, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#addUserToTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="all3"></a>
# **all3**
> List&lt;TeamUserInfo&gt; all3(teamId)

Get all users.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;READ_TEAM_USERS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    List<TeamUserInfo> result = apiInstance.all3(teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#all3");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**List&lt;TeamUserInfo&gt;**](TeamUserInfo.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="authRenew"></a>
# **authRenew**
> authRenew(email, orgId, renewToken)

Renew authorization.



### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
String email = "email_example"; // String | 
String orgId = "orgId_example"; // String | 
String renewToken = "renewToken_example"; // String | 
try {
    apiInstance.authRenew(email, orgId, renewToken);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#authRenew");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]
 **orgId** | **String**|  | [optional]
 **renewToken** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="getSelf"></a>
# **getSelf**
> getSelf()

Get information about the authenticated user

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
try {
    apiInstance.getSelf();
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#getSelf");
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
 - **Accept**: application/json

<a name="invite"></a>
# **invite**
> invite(email, sourceDetail)

Invite a user.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;ADD_USER_TO_COMPANY&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
String email = "email_example"; // String | 
String sourceDetail = "sourceDetail_example"; // String | 
try {
    apiInstance.invite(email, sourceDetail);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#invite");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]
 **sourceDetail** | **String**|  | [optional] [enum: Onboarding]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: text/plain

<a name="rbacAuthRenew"></a>
# **rbacAuthRenew**
> rbacAuthRenew(email, companyId, teamId, renewToken)

Renew authorization.



### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
String email = "email_example"; // String | 
String companyId = "companyId_example"; // String | 
String teamId = "teamId_example"; // String | 
String renewToken = "renewToken_example"; // String | 
try {
    apiInstance.rbacAuthRenew(email, companyId, teamId, renewToken);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#rbacAuthRenew");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  | [optional]
 **companyId** | **String**|  | [optional]
 **teamId** | **String**|  | [optional]
 **renewToken** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

<a name="rbacUpdateSelf"></a>
# **rbacUpdateSelf**
> rbacUpdateSelf(body)

Update an existing users info.

User must exist.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
String body = "body_example"; // String | 
try {
    apiInstance.rbacUpdateSelf(body);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#rbacUpdateSelf");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | **String**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: text/plain

<a name="refreshSessions"></a>
# **refreshSessions**
> refreshSessions(getCompanySession)

Returns the updated user sessions list for the currently authenticated user.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
Boolean getCompanySession = true; // Boolean | 
try {
    apiInstance.refreshSessions(getCompanySession);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#refreshSessions");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **getCompanySession** | **Boolean**|  | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="revokeInvite"></a>
# **revokeInvite**
> revokeInvite(email)

Revoke a pending user invite.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;DEACTIVATE_USER&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
String email = "email_example"; // String | 
try {
    apiInstance.revokeInvite(email);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#revokeInvite");
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

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="revokeOrRemoveFromTeam"></a>
# **revokeOrRemoveFromTeam**
> revokeOrRemoveFromTeam(email, teamId)

Deactivate a user.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;ADD_REMOVE_USER_FROM_TEAM&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
String email = "email_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.revokeOrRemoveFromTeam(email, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#revokeOrRemoveFromTeam");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  |
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: text/plain

<a name="update"></a>
# **update**
> update(email, role, teamId)

Update an existing user.

User must exist.  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;MANAGE_TEAM_USER_PERMISSIONS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import UsersApi;


UsersApi apiInstance = new UsersApi();
String email = "email_example"; // String | 
List<String> role = Arrays.asList("role_example"); // List<String> | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    apiInstance.update(email, role, teamId);
} catch (ApiException e) {
    System.err.println("Exception when calling UsersApi#update");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **email** | **String**|  |
 **role** | [**List&lt;String&gt;**](String.md)|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/x-www-form-urlencoded
 - **Accept**: application/json

