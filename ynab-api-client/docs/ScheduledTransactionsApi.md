# ScheduledTransactionsApi

All URIs are relative to *https://api.ynab.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createScheduledTransaction**](ScheduledTransactionsApi.md#createScheduledTransaction) | **POST** /budgets/{budget_id}/scheduled_transactions | Create a single scheduled transaction |
| [**createScheduledTransactionWithHttpInfo**](ScheduledTransactionsApi.md#createScheduledTransactionWithHttpInfo) | **POST** /budgets/{budget_id}/scheduled_transactions | Create a single scheduled transaction |
| [**deleteScheduledTransaction**](ScheduledTransactionsApi.md#deleteScheduledTransaction) | **DELETE** /budgets/{budget_id}/scheduled_transactions/{scheduled_transaction_id} | Deletes an existing scheduled transaction |
| [**deleteScheduledTransactionWithHttpInfo**](ScheduledTransactionsApi.md#deleteScheduledTransactionWithHttpInfo) | **DELETE** /budgets/{budget_id}/scheduled_transactions/{scheduled_transaction_id} | Deletes an existing scheduled transaction |
| [**getScheduledTransactionById**](ScheduledTransactionsApi.md#getScheduledTransactionById) | **GET** /budgets/{budget_id}/scheduled_transactions/{scheduled_transaction_id} | Single scheduled transaction |
| [**getScheduledTransactionByIdWithHttpInfo**](ScheduledTransactionsApi.md#getScheduledTransactionByIdWithHttpInfo) | **GET** /budgets/{budget_id}/scheduled_transactions/{scheduled_transaction_id} | Single scheduled transaction |
| [**getScheduledTransactions**](ScheduledTransactionsApi.md#getScheduledTransactions) | **GET** /budgets/{budget_id}/scheduled_transactions | List scheduled transactions |
| [**getScheduledTransactionsWithHttpInfo**](ScheduledTransactionsApi.md#getScheduledTransactionsWithHttpInfo) | **GET** /budgets/{budget_id}/scheduled_transactions | List scheduled transactions |
| [**updateScheduledTransaction**](ScheduledTransactionsApi.md#updateScheduledTransaction) | **PUT** /budgets/{budget_id}/scheduled_transactions/{scheduled_transaction_id} | Updates an existing scheduled transaction |
| [**updateScheduledTransactionWithHttpInfo**](ScheduledTransactionsApi.md#updateScheduledTransactionWithHttpInfo) | **PUT** /budgets/{budget_id}/scheduled_transactions/{scheduled_transaction_id} | Updates an existing scheduled transaction |



## createScheduledTransaction

> ScheduledTransactionResponse createScheduledTransaction(budgetId, data)

Create a single scheduled transaction

Creates a single scheduled transaction (a transaction with a future date).

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        PostScheduledTransactionWrapper data = new PostScheduledTransactionWrapper(); // PostScheduledTransactionWrapper | The scheduled transaction to create
        try {
            ScheduledTransactionResponse result = apiInstance.createScheduledTransaction(budgetId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#createScheduledTransaction");
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
| **data** | [**PostScheduledTransactionWrapper**](PostScheduledTransactionWrapper.md)| The scheduled transaction to create | |

### Return type

[**ScheduledTransactionResponse**](ScheduledTransactionResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The scheduled transaction was successfully created |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s). |  -  |

## createScheduledTransactionWithHttpInfo

> ApiResponse<ScheduledTransactionResponse> createScheduledTransaction createScheduledTransactionWithHttpInfo(budgetId, data)

Create a single scheduled transaction

Creates a single scheduled transaction (a transaction with a future date).

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        PostScheduledTransactionWrapper data = new PostScheduledTransactionWrapper(); // PostScheduledTransactionWrapper | The scheduled transaction to create
        try {
            ApiResponse<ScheduledTransactionResponse> response = apiInstance.createScheduledTransactionWithHttpInfo(budgetId, data);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#createScheduledTransaction");
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
| **data** | [**PostScheduledTransactionWrapper**](PostScheduledTransactionWrapper.md)| The scheduled transaction to create | |

### Return type

ApiResponse<[**ScheduledTransactionResponse**](ScheduledTransactionResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The scheduled transaction was successfully created |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s). |  -  |


## deleteScheduledTransaction

> ScheduledTransactionResponse deleteScheduledTransaction(budgetId, scheduledTransactionId)

Deletes an existing scheduled transaction

Deletes a scheduled transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String scheduledTransactionId = "scheduledTransactionId_example"; // String | The id of the scheduled transaction
        try {
            ScheduledTransactionResponse result = apiInstance.deleteScheduledTransaction(budgetId, scheduledTransactionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#deleteScheduledTransaction");
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
| **scheduledTransactionId** | **String**| The id of the scheduled transaction | |

### Return type

[**ScheduledTransactionResponse**](ScheduledTransactionResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The scheduled transaction was successfully deleted |  -  |
| **404** | The scheduled transaction was not found |  -  |

## deleteScheduledTransactionWithHttpInfo

> ApiResponse<ScheduledTransactionResponse> deleteScheduledTransaction deleteScheduledTransactionWithHttpInfo(budgetId, scheduledTransactionId)

Deletes an existing scheduled transaction

Deletes a scheduled transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String scheduledTransactionId = "scheduledTransactionId_example"; // String | The id of the scheduled transaction
        try {
            ApiResponse<ScheduledTransactionResponse> response = apiInstance.deleteScheduledTransactionWithHttpInfo(budgetId, scheduledTransactionId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#deleteScheduledTransaction");
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
| **scheduledTransactionId** | **String**| The id of the scheduled transaction | |

### Return type

ApiResponse<[**ScheduledTransactionResponse**](ScheduledTransactionResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The scheduled transaction was successfully deleted |  -  |
| **404** | The scheduled transaction was not found |  -  |


## getScheduledTransactionById

> ScheduledTransactionResponse getScheduledTransactionById(budgetId, scheduledTransactionId)

Single scheduled transaction

Returns a single scheduled transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String scheduledTransactionId = "scheduledTransactionId_example"; // String | The id of the scheduled transaction
        try {
            ScheduledTransactionResponse result = apiInstance.getScheduledTransactionById(budgetId, scheduledTransactionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#getScheduledTransactionById");
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
| **scheduledTransactionId** | **String**| The id of the scheduled transaction | |

### Return type

[**ScheduledTransactionResponse**](ScheduledTransactionResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The requested Scheduled Transaction |  -  |
| **404** | The scheduled transaction was not found |  -  |
| **0** | An error occurred |  -  |

## getScheduledTransactionByIdWithHttpInfo

> ApiResponse<ScheduledTransactionResponse> getScheduledTransactionById getScheduledTransactionByIdWithHttpInfo(budgetId, scheduledTransactionId)

Single scheduled transaction

Returns a single scheduled transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String scheduledTransactionId = "scheduledTransactionId_example"; // String | The id of the scheduled transaction
        try {
            ApiResponse<ScheduledTransactionResponse> response = apiInstance.getScheduledTransactionByIdWithHttpInfo(budgetId, scheduledTransactionId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#getScheduledTransactionById");
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
| **scheduledTransactionId** | **String**| The id of the scheduled transaction | |

### Return type

ApiResponse<[**ScheduledTransactionResponse**](ScheduledTransactionResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The requested Scheduled Transaction |  -  |
| **404** | The scheduled transaction was not found |  -  |
| **0** | An error occurred |  -  |


## getScheduledTransactions

> ScheduledTransactionsResponse getScheduledTransactions(budgetId, lastKnowledgeOfServer)

List scheduled transactions

Returns all scheduled transactions

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ScheduledTransactionsResponse result = apiInstance.getScheduledTransactions(budgetId, lastKnowledgeOfServer);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#getScheduledTransactions");
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

[**ScheduledTransactionsResponse**](ScheduledTransactionsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested scheduled transactions |  -  |
| **404** | No scheduled transactions were found |  -  |
| **0** | An error occurred |  -  |

## getScheduledTransactionsWithHttpInfo

> ApiResponse<ScheduledTransactionsResponse> getScheduledTransactions getScheduledTransactionsWithHttpInfo(budgetId, lastKnowledgeOfServer)

List scheduled transactions

Returns all scheduled transactions

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ApiResponse<ScheduledTransactionsResponse> response = apiInstance.getScheduledTransactionsWithHttpInfo(budgetId, lastKnowledgeOfServer);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#getScheduledTransactions");
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

ApiResponse<[**ScheduledTransactionsResponse**](ScheduledTransactionsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested scheduled transactions |  -  |
| **404** | No scheduled transactions were found |  -  |
| **0** | An error occurred |  -  |


## updateScheduledTransaction

> ScheduledTransactionResponse updateScheduledTransaction(budgetId, scheduledTransactionId, putScheduledTransactionWrapper)

Updates an existing scheduled transaction

Updates a single scheduled transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String scheduledTransactionId = "scheduledTransactionId_example"; // String | The id of the scheduled transaction
        PutScheduledTransactionWrapper putScheduledTransactionWrapper = new PutScheduledTransactionWrapper(); // PutScheduledTransactionWrapper | The scheduled transaction to update
        try {
            ScheduledTransactionResponse result = apiInstance.updateScheduledTransaction(budgetId, scheduledTransactionId, putScheduledTransactionWrapper);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#updateScheduledTransaction");
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
| **scheduledTransactionId** | **String**| The id of the scheduled transaction | |
| **putScheduledTransactionWrapper** | [**PutScheduledTransactionWrapper**](PutScheduledTransactionWrapper.md)| The scheduled transaction to update | |

### Return type

[**ScheduledTransactionResponse**](ScheduledTransactionResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The scheduled transaction was successfully updated |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s) |  -  |

## updateScheduledTransactionWithHttpInfo

> ApiResponse<ScheduledTransactionResponse> updateScheduledTransaction updateScheduledTransactionWithHttpInfo(budgetId, scheduledTransactionId, putScheduledTransactionWrapper)

Updates an existing scheduled transaction

Updates a single scheduled transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.ScheduledTransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        ScheduledTransactionsApi apiInstance = new ScheduledTransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String scheduledTransactionId = "scheduledTransactionId_example"; // String | The id of the scheduled transaction
        PutScheduledTransactionWrapper putScheduledTransactionWrapper = new PutScheduledTransactionWrapper(); // PutScheduledTransactionWrapper | The scheduled transaction to update
        try {
            ApiResponse<ScheduledTransactionResponse> response = apiInstance.updateScheduledTransactionWithHttpInfo(budgetId, scheduledTransactionId, putScheduledTransactionWrapper);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling ScheduledTransactionsApi#updateScheduledTransaction");
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
| **scheduledTransactionId** | **String**| The id of the scheduled transaction | |
| **putScheduledTransactionWrapper** | [**PutScheduledTransactionWrapper**](PutScheduledTransactionWrapper.md)| The scheduled transaction to update | |

### Return type

ApiResponse<[**ScheduledTransactionResponse**](ScheduledTransactionResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The scheduled transaction was successfully updated |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s) |  -  |

