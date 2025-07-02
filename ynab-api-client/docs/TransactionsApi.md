# TransactionsApi

All URIs are relative to *https://api.ynab.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createTransaction**](TransactionsApi.md#createTransaction) | **POST** /budgets/{budget_id}/transactions | Create a single transaction or multiple transactions |
| [**createTransactionWithHttpInfo**](TransactionsApi.md#createTransactionWithHttpInfo) | **POST** /budgets/{budget_id}/transactions | Create a single transaction or multiple transactions |
| [**deleteTransaction**](TransactionsApi.md#deleteTransaction) | **DELETE** /budgets/{budget_id}/transactions/{transaction_id} | Deletes an existing transaction |
| [**deleteTransactionWithHttpInfo**](TransactionsApi.md#deleteTransactionWithHttpInfo) | **DELETE** /budgets/{budget_id}/transactions/{transaction_id} | Deletes an existing transaction |
| [**getTransactionById**](TransactionsApi.md#getTransactionById) | **GET** /budgets/{budget_id}/transactions/{transaction_id} | Single transaction |
| [**getTransactionByIdWithHttpInfo**](TransactionsApi.md#getTransactionByIdWithHttpInfo) | **GET** /budgets/{budget_id}/transactions/{transaction_id} | Single transaction |
| [**getTransactions**](TransactionsApi.md#getTransactions) | **GET** /budgets/{budget_id}/transactions | List transactions |
| [**getTransactionsWithHttpInfo**](TransactionsApi.md#getTransactionsWithHttpInfo) | **GET** /budgets/{budget_id}/transactions | List transactions |
| [**getTransactionsByAccount**](TransactionsApi.md#getTransactionsByAccount) | **GET** /budgets/{budget_id}/accounts/{account_id}/transactions | List account transactions |
| [**getTransactionsByAccountWithHttpInfo**](TransactionsApi.md#getTransactionsByAccountWithHttpInfo) | **GET** /budgets/{budget_id}/accounts/{account_id}/transactions | List account transactions |
| [**getTransactionsByCategory**](TransactionsApi.md#getTransactionsByCategory) | **GET** /budgets/{budget_id}/categories/{category_id}/transactions | List category transactions, excluding any pending transactions |
| [**getTransactionsByCategoryWithHttpInfo**](TransactionsApi.md#getTransactionsByCategoryWithHttpInfo) | **GET** /budgets/{budget_id}/categories/{category_id}/transactions | List category transactions, excluding any pending transactions |
| [**getTransactionsByMonth**](TransactionsApi.md#getTransactionsByMonth) | **GET** /budgets/{budget_id}/months/{month}/transactions | List transactions in month, excluding any pending transactions |
| [**getTransactionsByMonthWithHttpInfo**](TransactionsApi.md#getTransactionsByMonthWithHttpInfo) | **GET** /budgets/{budget_id}/months/{month}/transactions | List transactions in month, excluding any pending transactions |
| [**getTransactionsByPayee**](TransactionsApi.md#getTransactionsByPayee) | **GET** /budgets/{budget_id}/payees/{payee_id}/transactions | List payee transactions, excluding any pending transactions |
| [**getTransactionsByPayeeWithHttpInfo**](TransactionsApi.md#getTransactionsByPayeeWithHttpInfo) | **GET** /budgets/{budget_id}/payees/{payee_id}/transactions | List payee transactions, excluding any pending transactions |
| [**importTransactions**](TransactionsApi.md#importTransactions) | **POST** /budgets/{budget_id}/transactions/import | Import transactions |
| [**importTransactionsWithHttpInfo**](TransactionsApi.md#importTransactionsWithHttpInfo) | **POST** /budgets/{budget_id}/transactions/import | Import transactions |
| [**updateTransaction**](TransactionsApi.md#updateTransaction) | **PUT** /budgets/{budget_id}/transactions/{transaction_id} | Updates an existing transaction |
| [**updateTransactionWithHttpInfo**](TransactionsApi.md#updateTransactionWithHttpInfo) | **PUT** /budgets/{budget_id}/transactions/{transaction_id} | Updates an existing transaction |
| [**updateTransactions**](TransactionsApi.md#updateTransactions) | **PATCH** /budgets/{budget_id}/transactions | Update multiple transactions |
| [**updateTransactionsWithHttpInfo**](TransactionsApi.md#updateTransactionsWithHttpInfo) | **PATCH** /budgets/{budget_id}/transactions | Update multiple transactions |



## createTransaction

> SaveTransactionsResponse createTransaction(budgetId, data)

Create a single transaction or multiple transactions

Creates a single transaction or multiple transactions.  If you provide a body containing a &#x60;transaction&#x60; object, a single transaction will be created and if you provide a body containing a &#x60;transactions&#x60; array, multiple transactions will be created.  Scheduled transactions (transactions with a future date) cannot be created on this endpoint.

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        PostTransactionsWrapper data = new PostTransactionsWrapper(); // PostTransactionsWrapper | The transaction or transactions to create.  To create a single transaction you can specify a value for the `transaction` object and to create multiple transactions you can specify an array of `transactions`.  It is expected that you will only provide a value for one of these objects.
        try {
            SaveTransactionsResponse result = apiInstance.createTransaction(budgetId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#createTransaction");
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
| **data** | [**PostTransactionsWrapper**](PostTransactionsWrapper.md)| The transaction or transactions to create.  To create a single transaction you can specify a value for the &#x60;transaction&#x60; object and to create multiple transactions you can specify an array of &#x60;transactions&#x60;.  It is expected that you will only provide a value for one of these objects. | |

### Return type

[**SaveTransactionsResponse**](SaveTransactionsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The transaction or transactions were successfully created |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s). |  -  |
| **409** | A transaction on the same account with the same &#x60;import_id&#x60; already exists. |  -  |

## createTransactionWithHttpInfo

> ApiResponse<SaveTransactionsResponse> createTransaction createTransactionWithHttpInfo(budgetId, data)

Create a single transaction or multiple transactions

Creates a single transaction or multiple transactions.  If you provide a body containing a &#x60;transaction&#x60; object, a single transaction will be created and if you provide a body containing a &#x60;transactions&#x60; array, multiple transactions will be created.  Scheduled transactions (transactions with a future date) cannot be created on this endpoint.

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        PostTransactionsWrapper data = new PostTransactionsWrapper(); // PostTransactionsWrapper | The transaction or transactions to create.  To create a single transaction you can specify a value for the `transaction` object and to create multiple transactions you can specify an array of `transactions`.  It is expected that you will only provide a value for one of these objects.
        try {
            ApiResponse<SaveTransactionsResponse> response = apiInstance.createTransactionWithHttpInfo(budgetId, data);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#createTransaction");
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
| **data** | [**PostTransactionsWrapper**](PostTransactionsWrapper.md)| The transaction or transactions to create.  To create a single transaction you can specify a value for the &#x60;transaction&#x60; object and to create multiple transactions you can specify an array of &#x60;transactions&#x60;.  It is expected that you will only provide a value for one of these objects. | |

### Return type

ApiResponse<[**SaveTransactionsResponse**](SaveTransactionsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The transaction or transactions were successfully created |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s). |  -  |
| **409** | A transaction on the same account with the same &#x60;import_id&#x60; already exists. |  -  |


## deleteTransaction

> TransactionResponse deleteTransaction(budgetId, transactionId)

Deletes an existing transaction

Deletes a transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String transactionId = "transactionId_example"; // String | The id of the transaction
        try {
            TransactionResponse result = apiInstance.deleteTransaction(budgetId, transactionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#deleteTransaction");
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
| **transactionId** | **String**| The id of the transaction | |

### Return type

[**TransactionResponse**](TransactionResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The transaction was successfully deleted |  -  |
| **404** | The transaction was not found |  -  |

## deleteTransactionWithHttpInfo

> ApiResponse<TransactionResponse> deleteTransaction deleteTransactionWithHttpInfo(budgetId, transactionId)

Deletes an existing transaction

Deletes a transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String transactionId = "transactionId_example"; // String | The id of the transaction
        try {
            ApiResponse<TransactionResponse> response = apiInstance.deleteTransactionWithHttpInfo(budgetId, transactionId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#deleteTransaction");
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
| **transactionId** | **String**| The id of the transaction | |

### Return type

ApiResponse<[**TransactionResponse**](TransactionResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The transaction was successfully deleted |  -  |
| **404** | The transaction was not found |  -  |


## getTransactionById

> TransactionResponse getTransactionById(budgetId, transactionId)

Single transaction

Returns a single transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String transactionId = "transactionId_example"; // String | The id of the transaction
        try {
            TransactionResponse result = apiInstance.getTransactionById(budgetId, transactionId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionById");
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
| **transactionId** | **String**| The id of the transaction | |

### Return type

[**TransactionResponse**](TransactionResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The requested transaction |  -  |
| **404** | The transaction was not found |  -  |
| **0** | An error occurred |  -  |

## getTransactionByIdWithHttpInfo

> ApiResponse<TransactionResponse> getTransactionById getTransactionByIdWithHttpInfo(budgetId, transactionId)

Single transaction

Returns a single transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String transactionId = "transactionId_example"; // String | The id of the transaction
        try {
            ApiResponse<TransactionResponse> response = apiInstance.getTransactionByIdWithHttpInfo(budgetId, transactionId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionById");
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
| **transactionId** | **String**| The id of the transaction | |

### Return type

ApiResponse<[**TransactionResponse**](TransactionResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The requested transaction |  -  |
| **404** | The transaction was not found |  -  |
| **0** | An error occurred |  -  |


## getTransactions

> TransactionsResponse getTransactions(budgetId, sinceDate, type, lastKnowledgeOfServer)

List transactions

Returns budget transactions, excluding any pending transactions

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            TransactionsResponse result = apiInstance.getTransactions(budgetId, sinceDate, type, lastKnowledgeOfServer);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactions");
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
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

[**TransactionsResponse**](TransactionsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **400** | An error occurred |  -  |
| **404** | No transactions were found |  -  |

## getTransactionsWithHttpInfo

> ApiResponse<TransactionsResponse> getTransactions getTransactionsWithHttpInfo(budgetId, sinceDate, type, lastKnowledgeOfServer)

List transactions

Returns budget transactions, excluding any pending transactions

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ApiResponse<TransactionsResponse> response = apiInstance.getTransactionsWithHttpInfo(budgetId, sinceDate, type, lastKnowledgeOfServer);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactions");
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
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

ApiResponse<[**TransactionsResponse**](TransactionsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **400** | An error occurred |  -  |
| **404** | No transactions were found |  -  |


## getTransactionsByAccount

> TransactionsResponse getTransactionsByAccount(budgetId, accountId, sinceDate, type, lastKnowledgeOfServer)

List account transactions

Returns all transactions for a specified account, excluding any pending transactions

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String accountId = "accountId_example"; // String | The id of the account
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            TransactionsResponse result = apiInstance.getTransactionsByAccount(budgetId, accountId, sinceDate, type, lastKnowledgeOfServer);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionsByAccount");
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
| **accountId** | **String**| The id of the account | |
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

[**TransactionsResponse**](TransactionsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **404** | No transactions were found |  -  |
| **0** | An error occurred |  -  |

## getTransactionsByAccountWithHttpInfo

> ApiResponse<TransactionsResponse> getTransactionsByAccount getTransactionsByAccountWithHttpInfo(budgetId, accountId, sinceDate, type, lastKnowledgeOfServer)

List account transactions

Returns all transactions for a specified account, excluding any pending transactions

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String accountId = "accountId_example"; // String | The id of the account
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ApiResponse<TransactionsResponse> response = apiInstance.getTransactionsByAccountWithHttpInfo(budgetId, accountId, sinceDate, type, lastKnowledgeOfServer);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionsByAccount");
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
| **accountId** | **String**| The id of the account | |
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

ApiResponse<[**TransactionsResponse**](TransactionsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **404** | No transactions were found |  -  |
| **0** | An error occurred |  -  |


## getTransactionsByCategory

> HybridTransactionsResponse getTransactionsByCategory(budgetId, categoryId, sinceDate, type, lastKnowledgeOfServer)

List category transactions, excluding any pending transactions

Returns all transactions for a specified category

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String categoryId = "categoryId_example"; // String | The id of the category
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            HybridTransactionsResponse result = apiInstance.getTransactionsByCategory(budgetId, categoryId, sinceDate, type, lastKnowledgeOfServer);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionsByCategory");
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
| **categoryId** | **String**| The id of the category | |
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

[**HybridTransactionsResponse**](HybridTransactionsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **404** | No transactions were found |  -  |
| **0** | An error occurred |  -  |

## getTransactionsByCategoryWithHttpInfo

> ApiResponse<HybridTransactionsResponse> getTransactionsByCategory getTransactionsByCategoryWithHttpInfo(budgetId, categoryId, sinceDate, type, lastKnowledgeOfServer)

List category transactions, excluding any pending transactions

Returns all transactions for a specified category

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String categoryId = "categoryId_example"; // String | The id of the category
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ApiResponse<HybridTransactionsResponse> response = apiInstance.getTransactionsByCategoryWithHttpInfo(budgetId, categoryId, sinceDate, type, lastKnowledgeOfServer);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionsByCategory");
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
| **categoryId** | **String**| The id of the category | |
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

ApiResponse<[**HybridTransactionsResponse**](HybridTransactionsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **404** | No transactions were found |  -  |
| **0** | An error occurred |  -  |


## getTransactionsByMonth

> HybridTransactionsResponse getTransactionsByMonth(budgetId, month, sinceDate, type, lastKnowledgeOfServer)

List transactions in month, excluding any pending transactions

Returns all transactions for a specified month

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String month = "month_example"; // String | The budget month in ISO format (e.g. 2016-12-01) (\"current\" can also be used to specify the current calendar month (UTC))
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            HybridTransactionsResponse result = apiInstance.getTransactionsByMonth(budgetId, month, sinceDate, type, lastKnowledgeOfServer);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionsByMonth");
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
| **month** | **String**| The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) | |
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

[**HybridTransactionsResponse**](HybridTransactionsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **404** | No transactions were found |  -  |
| **0** | An error occurred |  -  |

## getTransactionsByMonthWithHttpInfo

> ApiResponse<HybridTransactionsResponse> getTransactionsByMonth getTransactionsByMonthWithHttpInfo(budgetId, month, sinceDate, type, lastKnowledgeOfServer)

List transactions in month, excluding any pending transactions

Returns all transactions for a specified month

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String month = "month_example"; // String | The budget month in ISO format (e.g. 2016-12-01) (\"current\" can also be used to specify the current calendar month (UTC))
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ApiResponse<HybridTransactionsResponse> response = apiInstance.getTransactionsByMonthWithHttpInfo(budgetId, month, sinceDate, type, lastKnowledgeOfServer);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionsByMonth");
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
| **month** | **String**| The budget month in ISO format (e.g. 2016-12-01) (\&quot;current\&quot; can also be used to specify the current calendar month (UTC)) | |
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

ApiResponse<[**HybridTransactionsResponse**](HybridTransactionsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **404** | No transactions were found |  -  |
| **0** | An error occurred |  -  |


## getTransactionsByPayee

> HybridTransactionsResponse getTransactionsByPayee(budgetId, payeeId, sinceDate, type, lastKnowledgeOfServer)

List payee transactions, excluding any pending transactions

Returns all transactions for a specified payee

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String payeeId = "payeeId_example"; // String | The id of the payee
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            HybridTransactionsResponse result = apiInstance.getTransactionsByPayee(budgetId, payeeId, sinceDate, type, lastKnowledgeOfServer);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionsByPayee");
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
| **payeeId** | **String**| The id of the payee | |
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

[**HybridTransactionsResponse**](HybridTransactionsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **404** | No transactions were found |  -  |
| **0** | An error occurred |  -  |

## getTransactionsByPayeeWithHttpInfo

> ApiResponse<HybridTransactionsResponse> getTransactionsByPayee getTransactionsByPayeeWithHttpInfo(budgetId, payeeId, sinceDate, type, lastKnowledgeOfServer)

List payee transactions, excluding any pending transactions

Returns all transactions for a specified payee

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String payeeId = "payeeId_example"; // String | The id of the payee
        LocalDate sinceDate = LocalDate.now(); // LocalDate | If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30).
        String type = "uncategorized"; // String | If specified, only transactions of the specified type will be included. \"uncategorized\" and \"unapproved\" are currently supported.
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ApiResponse<HybridTransactionsResponse> response = apiInstance.getTransactionsByPayeeWithHttpInfo(budgetId, payeeId, sinceDate, type, lastKnowledgeOfServer);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#getTransactionsByPayee");
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
| **payeeId** | **String**| The id of the payee | |
| **sinceDate** | **LocalDate**| If specified, only transactions on or after this date will be included.  The date should be ISO formatted (e.g. 2016-12-30). | [optional] |
| **type** | **String**| If specified, only transactions of the specified type will be included. \&quot;uncategorized\&quot; and \&quot;unapproved\&quot; are currently supported. | [optional] [enum: uncategorized, unapproved] |
| **lastKnowledgeOfServer** | **Long**| The starting server knowledge.  If provided, only entities that have changed since &#x60;last_knowledge_of_server&#x60; will be included. | [optional] |

### Return type

ApiResponse<[**HybridTransactionsResponse**](HybridTransactionsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested transactions |  -  |
| **404** | No transactions were found |  -  |
| **0** | An error occurred |  -  |


## importTransactions

> TransactionsImportResponse importTransactions(budgetId)

Import transactions

Imports available transactions on all linked accounts for the given budget.  Linked accounts allow transactions to be imported directly from a specified financial institution and this endpoint initiates that import.  Sending a request to this endpoint is the equivalent of clicking \&quot;Import\&quot; on each account in the web application or tapping the \&quot;New Transactions\&quot; banner in the mobile applications.  The response for this endpoint contains the transaction ids that have been imported.

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        try {
            TransactionsImportResponse result = apiInstance.importTransactions(budgetId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#importTransactions");
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

### Return type

[**TransactionsImportResponse**](TransactionsImportResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The request was successful but there were no transactions to import |  -  |
| **201** | One or more transactions were imported successfully |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s) |  -  |

## importTransactionsWithHttpInfo

> ApiResponse<TransactionsImportResponse> importTransactions importTransactionsWithHttpInfo(budgetId)

Import transactions

Imports available transactions on all linked accounts for the given budget.  Linked accounts allow transactions to be imported directly from a specified financial institution and this endpoint initiates that import.  Sending a request to this endpoint is the equivalent of clicking \&quot;Import\&quot; on each account in the web application or tapping the \&quot;New Transactions\&quot; banner in the mobile applications.  The response for this endpoint contains the transaction ids that have been imported.

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        try {
            ApiResponse<TransactionsImportResponse> response = apiInstance.importTransactionsWithHttpInfo(budgetId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#importTransactions");
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

### Return type

ApiResponse<[**TransactionsImportResponse**](TransactionsImportResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The request was successful but there were no transactions to import |  -  |
| **201** | One or more transactions were imported successfully |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s) |  -  |


## updateTransaction

> TransactionResponse updateTransaction(budgetId, transactionId, data)

Updates an existing transaction

Updates a single transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String transactionId = "transactionId_example"; // String | The id of the transaction
        PutTransactionWrapper data = new PutTransactionWrapper(); // PutTransactionWrapper | The transaction to update
        try {
            TransactionResponse result = apiInstance.updateTransaction(budgetId, transactionId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#updateTransaction");
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
| **transactionId** | **String**| The id of the transaction | |
| **data** | [**PutTransactionWrapper**](PutTransactionWrapper.md)| The transaction to update | |

### Return type

[**TransactionResponse**](TransactionResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The transaction was successfully updated |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s) |  -  |

## updateTransactionWithHttpInfo

> ApiResponse<TransactionResponse> updateTransaction updateTransactionWithHttpInfo(budgetId, transactionId, data)

Updates an existing transaction

Updates a single transaction

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        String transactionId = "transactionId_example"; // String | The id of the transaction
        PutTransactionWrapper data = new PutTransactionWrapper(); // PutTransactionWrapper | The transaction to update
        try {
            ApiResponse<TransactionResponse> response = apiInstance.updateTransactionWithHttpInfo(budgetId, transactionId, data);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#updateTransaction");
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
| **transactionId** | **String**| The id of the transaction | |
| **data** | [**PutTransactionWrapper**](PutTransactionWrapper.md)| The transaction to update | |

### Return type

ApiResponse<[**TransactionResponse**](TransactionResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The transaction was successfully updated |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s) |  -  |


## updateTransactions

> SaveTransactionsResponse updateTransactions(budgetId, data)

Update multiple transactions

Updates multiple transactions, by &#x60;id&#x60; or &#x60;import_id&#x60;.

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        PatchTransactionsWrapper data = new PatchTransactionsWrapper(); // PatchTransactionsWrapper | The transactions to update. Each transaction must have either an `id` or `import_id` specified. If `id` is specified as null an `import_id` value can be provided which will allow transaction(s) to be updated by its `import_id`. If an `id` is specified, it will always be used for lookup.  You should not specify both `id` and `import_id`.  Updating an `import_id` on an existing transaction is not allowed; if an `import_id` is specified, it will only be used to lookup the transaction.
        try {
            SaveTransactionsResponse result = apiInstance.updateTransactions(budgetId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#updateTransactions");
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
| **data** | [**PatchTransactionsWrapper**](PatchTransactionsWrapper.md)| The transactions to update. Each transaction must have either an &#x60;id&#x60; or &#x60;import_id&#x60; specified. If &#x60;id&#x60; is specified as null an &#x60;import_id&#x60; value can be provided which will allow transaction(s) to be updated by its &#x60;import_id&#x60;. If an &#x60;id&#x60; is specified, it will always be used for lookup.  You should not specify both &#x60;id&#x60; and &#x60;import_id&#x60;.  Updating an &#x60;import_id&#x60; on an existing transaction is not allowed; if an &#x60;import_id&#x60; is specified, it will only be used to lookup the transaction. | |

### Return type

[**SaveTransactionsResponse**](SaveTransactionsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **209** | The transactions were successfully updated |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s). |  -  |

## updateTransactionsWithHttpInfo

> ApiResponse<SaveTransactionsResponse> updateTransactions updateTransactionsWithHttpInfo(budgetId, data)

Update multiple transactions

Updates multiple transactions, by &#x60;id&#x60; or &#x60;import_id&#x60;.

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.TransactionsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        TransactionsApi apiInstance = new TransactionsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        PatchTransactionsWrapper data = new PatchTransactionsWrapper(); // PatchTransactionsWrapper | The transactions to update. Each transaction must have either an `id` or `import_id` specified. If `id` is specified as null an `import_id` value can be provided which will allow transaction(s) to be updated by its `import_id`. If an `id` is specified, it will always be used for lookup.  You should not specify both `id` and `import_id`.  Updating an `import_id` on an existing transaction is not allowed; if an `import_id` is specified, it will only be used to lookup the transaction.
        try {
            ApiResponse<SaveTransactionsResponse> response = apiInstance.updateTransactionsWithHttpInfo(budgetId, data);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling TransactionsApi#updateTransactions");
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
| **data** | [**PatchTransactionsWrapper**](PatchTransactionsWrapper.md)| The transactions to update. Each transaction must have either an &#x60;id&#x60; or &#x60;import_id&#x60; specified. If &#x60;id&#x60; is specified as null an &#x60;import_id&#x60; value can be provided which will allow transaction(s) to be updated by its &#x60;import_id&#x60;. If an &#x60;id&#x60; is specified, it will always be used for lookup.  You should not specify both &#x60;id&#x60; and &#x60;import_id&#x60;.  Updating an &#x60;import_id&#x60; on an existing transaction is not allowed; if an &#x60;import_id&#x60; is specified, it will only be used to lookup the transaction. | |

### Return type

ApiResponse<[**SaveTransactionsResponse**](SaveTransactionsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **209** | The transactions were successfully updated |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s). |  -  |

