
# PredicateObject

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**comparator** | [**HasCompareFunctionObject**](HasCompareFunctionObject.md) |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) | The type of primitive this predicate operates on |  [optional]
**jpQuery** | **String** | The json path query to run to read from the response body |  [optional]
**rValue** | **Object** | The right hand value of the predicate |  [optional]


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
STRING | &quot;String&quot;
NUMBER | &quot;Number&quot;
BOOLEAN | &quot;Boolean&quot;



