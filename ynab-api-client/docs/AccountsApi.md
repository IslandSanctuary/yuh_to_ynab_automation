# AccountsApi

All URIs are relative to *https://api.ynab.com/v1*

| Method | HTTP request | Description |
|------------- | ------------- | -------------|
| [**createAccount**](AccountsApi.md#createAccount) | **POST** /budgets/{budget_id}/accounts | Create a new account |
| [**createAccountWithHttpInfo**](AccountsApi.md#createAccountWithHttpInfo) | **POST** /budgets/{budget_id}/accounts | Create a new account |
| [**getAccountById**](AccountsApi.md#getAccountById) | **GET** /budgets/{budget_id}/accounts/{account_id} | Single account |
| [**getAccountByIdWithHttpInfo**](AccountsApi.md#getAccountByIdWithHttpInfo) | **GET** /budgets/{budget_id}/accounts/{account_id} | Single account |
| [**getAccounts**](AccountsApi.md#getAccounts) | **GET** /budgets/{budget_id}/accounts | Account list |
| [**getAccountsWithHttpInfo**](AccountsApi.md#getAccountsWithHttpInfo) | **GET** /budgets/{budget_id}/accounts | Account list |



## createAccount

> AccountResponse createAccount(budgetId, data)

Create a new account

Creates a new account

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.AccountsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        AccountsApi apiInstance = new AccountsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget (\"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget)
        PostAccountWrapper data = new PostAccountWrapper(); // PostAccountWrapper | The account to create.
        try {
            AccountResponse result = apiInstance.createAccount(budgetId, data);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsApi#createAccount");
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
| **budgetId** | **String**| The id of the budget (\&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget) | |
| **data** | [**PostAccountWrapper**](PostAccountWrapper.md)| The account to create. | |

### Return type

[**AccountResponse**](AccountResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The account was successfully created |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s). |  -  |

## createAccountWithHttpInfo

> ApiResponse<AccountResponse> createAccount createAccountWithHttpInfo(budgetId, data)

Create a new account

Creates a new account

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.AccountsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        AccountsApi apiInstance = new AccountsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget (\"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget)
        PostAccountWrapper data = new PostAccountWrapper(); // PostAccountWrapper | The account to create.
        try {
            ApiResponse<AccountResponse> response = apiInstance.createAccountWithHttpInfo(budgetId, data);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsApi#createAccount");
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
| **budgetId** | **String**| The id of the budget (\&quot;last-used\&quot; can be used to specify the last used budget and \&quot;default\&quot; can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget) | |
| **data** | [**PostAccountWrapper**](PostAccountWrapper.md)| The account to create. | |

### Return type

ApiResponse<[**AccountResponse**](AccountResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: application/json
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **201** | The account was successfully created |  -  |
| **400** | The request could not be understood due to malformed syntax or validation error(s). |  -  |


## getAccountById

> AccountResponse getAccountById(budgetId, accountId)

Single account

Returns a single account

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.AccountsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        AccountsApi apiInstance = new AccountsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        UUID accountId = UUID.randomUUID(); // UUID | The id of the account
        try {
            AccountResponse result = apiInstance.getAccountById(budgetId, accountId);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsApi#getAccountById");
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
| **accountId** | **UUID**| The id of the account | |

### Return type

[**AccountResponse**](AccountResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The requested account |  -  |
| **404** | The requested account was not found |  -  |
| **0** | An error occurred |  -  |

## getAccountByIdWithHttpInfo

> ApiResponse<AccountResponse> getAccountById getAccountByIdWithHttpInfo(budgetId, accountId)

Single account

Returns a single account

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.AccountsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        AccountsApi apiInstance = new AccountsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        UUID accountId = UUID.randomUUID(); // UUID | The id of the account
        try {
            ApiResponse<AccountResponse> response = apiInstance.getAccountByIdWithHttpInfo(budgetId, accountId);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsApi#getAccountById");
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
| **accountId** | **UUID**| The id of the account | |

### Return type

ApiResponse<[**AccountResponse**](AccountResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The requested account |  -  |
| **404** | The requested account was not found |  -  |
| **0** | An error occurred |  -  |


## getAccounts

> AccountsResponse getAccounts(budgetId, lastKnowledgeOfServer)

Account list

Returns all accounts

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.AccountsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        AccountsApi apiInstance = new AccountsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            AccountsResponse result = apiInstance.getAccounts(budgetId, lastKnowledgeOfServer);
            System.out.println(result);
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsApi#getAccounts");
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

[**AccountsResponse**](AccountsResponse.md)


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested accounts |  -  |
| **404** | No accounts were found |  -  |
| **0** | An error occurred |  -  |

## getAccountsWithHttpInfo

> ApiResponse<AccountsResponse> getAccounts getAccountsWithHttpInfo(budgetId, lastKnowledgeOfServer)

Account list

Returns all accounts

### Example

```java
// Import classes:
import com.example.ynab_api_client.client.invoker.ApiClient;
import com.example.ynab_api_client.client.invoker.ApiException;
import com.example.ynab_api_client.client.invoker.ApiResponse;
import com.example.ynab_api_client.client.invoker.Configuration;
import com.example.ynab_api_client.client.invoker.auth.*;
import com.example.ynab_api_client.client.invoker.models.*;
import com.example.ynab_api_client.client.api.AccountsApi;

public class Example {
    public static void main(String[] args) {
        ApiClient defaultClient = Configuration.getDefaultApiClient();
        defaultClient.setBasePath("https://api.ynab.com/v1");
        
        // Configure HTTP bearer authorization: bearer
        HttpBearerAuth bearer = (HttpBearerAuth) defaultClient.getAuthentication("bearer");
        bearer.setBearerToken("BEARER TOKEN");

        AccountsApi apiInstance = new AccountsApi(defaultClient);
        String budgetId = "budgetId_example"; // String | The id of the budget. \"last-used\" can be used to specify the last used budget and \"default\" can be used if default budget selection is enabled (see: https://api.ynab.com/#oauth-default-budget).
        Long lastKnowledgeOfServer = 56L; // Long | The starting server knowledge.  If provided, only entities that have changed since `last_knowledge_of_server` will be included.
        try {
            ApiResponse<AccountsResponse> response = apiInstance.getAccountsWithHttpInfo(budgetId, lastKnowledgeOfServer);
            System.out.println("Status code: " + response.getStatusCode());
            System.out.println("Response headers: " + response.getHeaders());
            System.out.println("Response body: " + response.getData());
        } catch (ApiException e) {
            System.err.println("Exception when calling AccountsApi#getAccounts");
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

ApiResponse<[**AccountsResponse**](AccountsResponse.md)>


### Authorization

[bearer](../README.md#bearer)

### HTTP request headers

- **Content-Type**: Not defined
- **Accept**: application/json

### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
| **200** | The list of requested accounts |  -  |
| **404** | No accounts were found |  -  |
| **0** | An error occurred |  -  |

