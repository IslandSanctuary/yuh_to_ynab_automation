# MonthsApi

All URIs are relative to *https://api.ynab.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**getBudgetMonth**](MonthsApi.md#getBudgetMonth) | **GET** /budgets/{budget_id}/months/{month} | Single budget month |
| [**getBudgetMonthWithHttpInfo**](MonthsApi.md#getBudgetMonthWithHttpInfo) | **GET** /budgets/{budget_id}/months/{month} | Single budget month |
| [**getBudgetMonths**](MonthsApi.md#getBudgetMonths) | **GET** /budgets/{budget_id}/months | List budget months |
| [**getBudgetMonthsWithHttpInfo**](MonthsApi.md#getBudgetMonthsWithHttpInfo) | **GET** /budgets/{budget_id}/months | List budget months |



## getBudgetMonth

> MonthDetailResponse getBudgetMonth(budgetId, month)

Single budget month

Returns a single budget month

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.MonthsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        MonthsApi apiInstance = new MonthsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        LocalDate month = LocalDate.now(); // LocalDate | The budget month in ISO format (e.g. 2016-12-01) (\"current\" can also be used to specify the current calendar month (UTC))
        try {
            MonthDetailResponse result = apiInstance.getBudgetMonth(budgetId, month);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonthsApi#getBudgetMonth");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **budgetId** | **String**| The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget). | |
| **month** | **LocalDate**| The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) | |

### Return type

[**MonthDetailResponse**](MonthDetailResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The budget month detail |  -  |
| **404** | The budget month was not found |  -  |
| **0** | An error occurred |  -  |

## getBudgetMonthWithHttpInfo

> ApiResponse<MonthDetailResponse> getBudgetMonth getBudgetMonthWithHttpInfo(budgetId, month)

Single budget month

Returns a single budget month

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.MonthsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        MonthsApi apiInstance = new MonthsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        LocalDate month = LocalDate.now(); // LocalDate | The budget month in ISO format (e.g. 2016-12-01) (\"current\" can also be used to specify the current calendar month (UTC))
        try {
            ApiResponse<MonthDetailResponse> response = apiInstance.getBudgetMonthWithHttpInfo(budgetId, month);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MonthsApi#getBudgetMonth");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **budgetId** | **String**| The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget). | |
| **month** | **LocalDate**| The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) | |

### Return type

ApiResponse<[**MonthDetailResponse**](MonthDetailResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The budget month detail |  -  |
| **404** | The budget month was not found |  -  |
| **0** | An error occurred |  -  |


## getBudgetMonths

> MonthSummariesResponse getBudgetMonths(budgetId, lastKnowledgeOfServer)

List budget months

Returns all budget months

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.MonthsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        MonthsApi apiInstance = new MonthsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            MonthSummariesResponse result = apiInstance.getBudgetMonths(budgetId, lastKnowledgeOfServer);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling MonthsApi#getBudgetMonths");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Reason: " + e.getResponseBody());
            System.err.println("Response headers: " + e.getResponseHeaders());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **budgetId** | **String**| The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget). | |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

[**MonthSummariesResponse**](MonthSummariesResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of budget months |  -  |
| **404** | No budget months were found |  -  |
| **0** | An error occurred |  -  |

## getBudgetMonthsWithHttpInfo

> ApiResponse<MonthSummariesResponse> getBudgetMonths getBudgetMonthsWithHttpInfo(budgetId, lastKnowledgeOfServer)

List budget months

Returns all budget months

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.MonthsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        MonthsApi apiInstance = new MonthsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ApiResponse<MonthSummariesResponse> response = apiInstance.getBudgetMonthsWithHttpInfo(budgetId, lastKnowledgeOfServer);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling MonthsApi#getBudgetMonths");
            System.err.println("Status code: " + e.getCode());
            System.err.println("Response headers: " + e.getResponseHeaders());
            System.err.println("Reason: " + e.getResponseBody());
            e.printStackTrace();
        }
    }
}
```

### Parameters


| Name | Type | Description  | Notes |
|------------- | ------------- | ------------- | -------------|
| **budgetId** | **String**| The id of the budget. \&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget). | |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

ApiResponse<[**MonthSummariesResponse**](MonthSummariesResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of budget months |  -  |
| **404** | No budget months were found |  -  |
| **0** | An error occurred |  -  |

