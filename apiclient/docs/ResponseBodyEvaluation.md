
# ResponseBodyEvaluation

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**op** | [**OpEnum**](#OpEnum) | The operation to logically combine predicates into a success or failure |  [optional]
**predicates** | [**List&lt;Predicate&gt;**](Predicate.md) | The list of predicates to evaluate against the status check response body |  [optional]


<a name="OpEnum"></a>
## Enum: OpEnum
Name | Value
---- | -----
AND | &quot;AND&quot;
OR | &quot;OR&quot;



