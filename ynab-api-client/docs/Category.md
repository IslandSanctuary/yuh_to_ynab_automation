

# Category


## Properties

| Name | Type | Description | Notes |
|------------ | ------------- | ------------- | -------------|
|**id** | **UUID** |  |  |
|**categoryGroupId** | **UUID** |  |  |
|**categoryGroupName** | **String** |  |  [optional] |
|**name** | **String** |  |  |
|**hidden** | **Boolean** | Whether or not the category is hidden |  |
|**originalCategoryGroupId** | **UUID** | DEPRECATED: No longer used.  Value will always be null. |  [optional] |
|**note** | **String** |  |  [optional] |
|**budgeted** | **Long** | Budgeted amount in milliunits format |  |
|**activity** | **Long** | Activity amount in milliunits format |  |
|**balance** | **Long** | Balance in milliunits format |  |
|**goalType** | [**GoalTypeEnum**](#GoalTypeEnum) | The type of goal, if the category has a goal (TB&#x3D;&#39;Target Category Balance&#39;, TBD&#x3D;&#39;Target Category Balance by Date&#39;, MF&#x3D;&#39;Monthly Funding&#39;, NEED&#x3D;&#39;Plan Your Spending&#39;) |  [optional] |
|**goalNeedsWholeAmount** | **Boolean** | Indicates the monthly rollover behavior for \&quot;NEED\&quot;-type goals. When \&quot;true\&quot;, the goal will always ask for the target amount in the new month (\&quot;Set Aside\&quot;). When \&quot;false\&quot;, previous month category funding is used (\&quot;Refill\&quot;). For other goal types, this field will be null. |  [optional] |
|**goalDay** | **Integer** | A day offset modifier for the goal&#39;s due date. When goal_cadence is 2 (Weekly), this value specifies which day of the week the goal is due (0 &#x3D; Sunday, 6 &#x3D; Saturday). Otherwise, this value specifies which day of the month the goal is due (1 &#x3D; 1st, 31 &#x3D; 31st, null &#x3D; Last day of Month). |  [optional] |
|**goalCadence** | **Integer** | The goal cadence. Value in range 0-14. There are two subsets of these values which behave differently. For values 0, 1, 2, and 13, the goal&#39;s due date repeats every goal_cadence * goal_cadence_frequency, where 0 &#x3D; None, 1 &#x3D; Monthly, 2 &#x3D; Weekly, and 13 &#x3D; Yearly. For example, goal_cadence 1 with goal_cadence_frequency 2 means the goal is due every other month. For values 3-12 and 14, goal_cadence_frequency is ignored and the goal&#39;s due date repeats every goal_cadence, where 3 &#x3D; Every 2 Months, 4 &#x3D; Every 3 Months, ..., 12 &#x3D; Every 11 Months, and 14 &#x3D; Every 2 Years. |  [optional] |
|**goalCadenceFrequency** | **Integer** | The goal cadence frequency. When goal_cadence is 0, 1, 2, or 13, a goal&#39;s due date repeats every goal_cadence * goal_cadence_frequency. For example, goal_cadence 1 with goal_cadence_frequency 2 means the goal is due every other month.  When goal_cadence is 3-12 or 14, goal_cadence_frequency is ignored. |  [optional] |
|**goalCreationMonth** | **LocalDate** | The month a goal was created |  [optional] |
|**goalTarget** | **Long** | The goal target amount in milliunits |  [optional] |
|**goalTargetMonth** | **LocalDate** | The original target month for the goal to be completed.  Only some goal types specify this date. |  [optional] |
|**goalPercentageComplete** | **Integer** | The percentage completion of the goal |  [optional] |
|**goalMonthsToBudget** | **Integer** | The number of months, including the current month, left in the current goal period. |  [optional] |
|**goalUnderFunded** | **Long** | The amount of funding still needed in the current month to stay on track towards completing the goal within the current goal period. This amount will generally correspond to the &#39;Underfunded&#39; amount in the web and mobile clients except when viewing a category with a Needed for Spending Goal in a future month.  The web and mobile clients will ignore any funding from a prior goal period when viewing category with a Needed for Spending Goal in a future month. |  [optional] |
|**goalOverallFunded** | **Long** | The total amount funded towards the goal within the current goal period. |  [optional] |
|**goalOverallLeft** | **Long** | The amount of funding still needed to complete the goal within the current goal period. |  [optional] |
|**deleted** | **Boolean** | Whether or not the category has been deleted.  Deleted categories will only be included in delta requests. |  |



## Enum: GoalTypeEnum

| Name | Value |
|---- | -----|
| TB | &quot;TB&quot; |
| TBD | &quot;TBD&quot; |
| MF | &quot;MF&quot; |
| NEED | &quot;NEED&quot; |
| DEBT | &quot;DEBT&quot; |



