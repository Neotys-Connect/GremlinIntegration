# ContractsApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**requestChange**](ContractsApi.md#requestChange) | **PATCH** /companies/{identifier}/contracts/current | Requests a change to your company contract (i.e. request an upgrade or downgrade to your service)


<a name="requestChange"></a>
# **requestChange**
> requestChange(identifier, body)

Requests a change to your company contract (i.e. request an upgrade or downgrade to your service)

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ContractsApi;


ContractsApi apiInstance = new ContractsApi();
String identifier = "identifier_example"; // String | 
String body = "body_example"; // String | 
try {
    apiInstance.requestChange(identifier, body);
} catch (ApiException e) {
    System.err.println("Exception when calling ContractsApi#requestChange");
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

