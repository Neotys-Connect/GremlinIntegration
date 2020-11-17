# ReportsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**attackSummary**](ReportsApi.md#attackSummary) | **GET** /reports/attacks | Loads the Attacks Summary for the specified time period.
[**clientSummary**](ReportsApi.md#clientSummary) | **GET** /reports/clients | Loads the Client Summary for the specified time period.
[**companySummary**](ReportsApi.md#companySummary) | **GET** /reports/companies | Loads the Company Summary for the specified month.
[**teamSummaries**](ReportsApi.md#teamSummaries) | **GET** /reports/teams | Loads the Team Summary for the specified month.
[**userSummary**](ReportsApi.md#userSummary) | **GET** /reports/users | Loads the User Summary for the specified time period.


<a name="attackSummary"></a>
# **attackSummary**
> ReportData attackSummary(start, end, period, teamId)

Loads the Attacks Summary for the specified time period.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ReportsApi;


ReportsApi apiInstance = new ReportsApi();
String start = "start_example"; // String | 
String end = "end_example"; // String | 
String period = "period_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ReportData result = apiInstance.attackSummary(start, end, period, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApi#attackSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **String**|  | [optional]
 **end** | **String**|  | [optional]
 **period** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ReportData**](ReportData.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="clientSummary"></a>
# **clientSummary**
> ReportData clientSummary(start, end, period, teamId)

Loads the Client Summary for the specified time period.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ReportsApi;


ReportsApi apiInstance = new ReportsApi();
String start = "start_example"; // String | 
String end = "end_example"; // String | 
String period = "period_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ReportData result = apiInstance.clientSummary(start, end, period, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApi#clientSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **String**|  | [optional]
 **end** | **String**|  | [optional]
 **period** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ReportData**](ReportData.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="companySummary"></a>
# **companySummary**
> CompanyUsageReport companySummary(startDate, endDate)

Loads the Company Summary for the specified month.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ReportsApi;


ReportsApi apiInstance = new ReportsApi();
String startDate = "startDate_example"; // String | 
String endDate = "endDate_example"; // String | 
try {
    CompanyUsageReport result = apiInstance.companySummary(startDate, endDate);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApi#companySummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **String**|  | [optional]
 **endDate** | **String**|  | [optional]

### Return type

[**CompanyUsageReport**](CompanyUsageReport.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="teamSummaries"></a>
# **teamSummaries**
> List&lt;TeamUsageReport&gt; teamSummaries(startDate, endDate, teamId)

Loads the Team Summary for the specified month.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ReportsApi;


ReportsApi apiInstance = new ReportsApi();
String startDate = "startDate_example"; // String | 
String endDate = "endDate_example"; // String | 
String teamId = "teamId_example"; // String | 
try {
    List<TeamUsageReport> result = apiInstance.teamSummaries(startDate, endDate, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApi#teamSummaries");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startDate** | **String**|  | [optional]
 **endDate** | **String**|  | [optional]
 **teamId** | **String**|  | [optional]

### Return type

[**List&lt;TeamUsageReport&gt;**](TeamUsageReport.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="userSummary"></a>
# **userSummary**
> ReportData userSummary(start, end, period, teamId)

Loads the User Summary for the specified time period.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;TEAM_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ReportsApi;


ReportsApi apiInstance = new ReportsApi();
String start = "start_example"; // String | 
String end = "end_example"; // String | 
String period = "period_example"; // String | 
Object teamId = null; // Object | Required when using company session token (RBAC only).
try {
    ReportData result = apiInstance.userSummary(start, end, period, teamId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsApi#userSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **String**|  | [optional]
 **end** | **String**|  | [optional]
 **period** | **String**|  | [optional]
 **teamId** | [**Object**](.md)| Required when using company session token (RBAC only). | [optional]

### Return type

[**ReportData**](ReportData.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

