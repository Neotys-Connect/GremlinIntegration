# ReportsSecurityApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**accessSummary**](ReportsSecurityApi.md#accessSummary) | **GET** /reports/security/access | Loads the Access Summary for the specified company in the time period requested.


<a name="accessSummary"></a>
# **accessSummary**
> accessSummary(start, end, format)

Loads the Access Summary for the specified company in the time period requested.

SUPER users only  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;ACCESS_SECURITY_LOGS&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ReportsSecurityApi;


ReportsSecurityApi apiInstance = new ReportsSecurityApi();
String start = "start_example"; // String | Start date in format 'YYYY-MM-DD'
String end = "end_example"; // String | End date in format 'YYYY-MM-DD'
String format = "format_example"; // String | Format of the report (JSON or CSV)
try {
    apiInstance.accessSummary(start, end, format);
} catch (ApiException e) {
    System.err.println("Exception when calling ReportsSecurityApi#accessSummary");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **start** | **String**| Start date in format &#39;YYYY-MM-DD&#39; |
 **end** | **String**| End date in format &#39;YYYY-MM-DD&#39; |
 **format** | **String**| Format of the report (JSON or CSV) |

### Return type

null (empty response body)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json, text/plain

