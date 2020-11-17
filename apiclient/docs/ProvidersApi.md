# ProvidersApi

All URIs are relative to *https://api.gremlin.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**aws**](ProvidersApi.md#aws) | **GET** /providers/aws | Returns the list of supported AWS services.
[**providers**](ProvidersApi.md#providers) | **GET** /providers | Returns a list of supported infrastructure providers.


<a name="aws"></a>
# **aws**
> List&lt;String&gt; aws()

Returns the list of supported AWS services.

# Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ProvidersApi;


ProvidersApi apiInstance = new ProvidersApi();
try {
    List<String> result = apiInstance.aws();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#aws");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="providers"></a>
# **providers**
> List&lt;String&gt; providers()

Returns a list of supported infrastructure providers.

Currently supports &#39;aws&#39;  # Authorization Schema ## [__Bearer Tokens__](https://www.gremlin.com/docs/api-reference/examples/#authentication-and-access-tokens) ### Role Based Access Control [&#x60;COMPANY_DEFAULT&#x60;](https://www.gremlin.com/docs/user-management/access-control/#privileges) 

### Example
```java
// Import classes:
//import ApiException;
//import ProvidersApi;


ProvidersApi apiInstance = new ProvidersApi();
try {
    List<String> result = apiInstance.providers();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling ProvidersApi#providers");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

**List&lt;String&gt;**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

