
# K8sTarget

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clusterId** | **String** |  |  [optional]
**ownerReferences** | **String** |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**uid** | **String** |  |  [optional]
**namespace** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**kind** | [**KindEnum**](#KindEnum) |  |  [optional]
**labels** | **Map&lt;String, String&gt;** |  |  [optional]
**annotations** | **Map&lt;String, String&gt;** |  |  [optional]


<a name="KindEnum"></a>
## Enum: KindEnum
Name | Value
---- | -----
DEPLOYMENT | &quot;DEPLOYMENT&quot;
REPLICASET | &quot;REPLICASET&quot;
POD | &quot;POD&quot;
DAEMONSET | &quot;DAEMONSET&quot;
STATEFULSET | &quot;STATEFULSET&quot;



