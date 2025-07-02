

# ScheduledTransactionSummary


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  |
|**dateFirst** | **LocalDate** | The first date for which the Scheduled Transaction was scheduled. |  |
|**dateNext** | **LocalDate** | The next date for which the Scheduled Transaction is scheduled. |  |
|**frequency** | [**FrequencyEnum**](#FrequencyEnum) |  |  |
|**amount** | **Long** | The scheduled transaction amount in milliunits format |  |
|**memo** | **String** |  |  [optional] |
|**flagColor** | **TransactionFlagColor** |  |  [optional] |
|**flagName** | **String** | The customized name of a transaction flag |  [optional] |
|**accountId** | **UUID** |  |  |
|**payeeId** | **UUID** |  |  [optional] |
|**categoryId** | **UUID** |  |  [optional] |
|**transferAccountId** | **UUID** | If a transfer, the account_id which the scheduled transaction transfers to |  [optional] |
|**deleted** | **Boolean** | Whether or not the scheduled transaction has been deleted.  Deleted scheduled transactions will only be included in delta requests. |  |



## Enum: FrequencyEnum

| Name | Value |
|---- | -----|
| NEVER | &quot;never&quot; |
| DAILY | &quot;daily&quot; |
| WEEKLY | &quot;weekly&quot; |
| EVERY_OTHER_WEEK | &quot;everyOtherWeek&quot; |
| TWICE_A_MONTH | &quot;twiceAMonth&quot; |
| EVERY4_WEEKS | &quot;every4Weeks&quot; |
| MONTHLY | &quot;monthly&quot; |
| EVERY_OTHER_MONTH | &quot;everyOtherMonth&quot; |
| EVERY3_MONTHS | &quot;every3Months&quot; |
| EVERY4_MONTHS | &quot;every4Months&quot; |
| TWICE_A_YEAR | &quot;twiceAYear&quot; |
| YEARLY | &quot;yearly&quot; |
| EVERY_OTHER_YEAR | &quot;everyOtherYear&quot; |



