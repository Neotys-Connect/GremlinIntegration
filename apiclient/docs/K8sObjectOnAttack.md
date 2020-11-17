
# K8sObjectOnAttack

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clusterId** | **String** |  |  [optional]
**uid** | **String** |  |  [optional]
**namespace** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**kind** | [**KindEnum**](#KindEnum) |  |  [optional]
**labels** | **Map&lt;String, String&gt;** |  |  [optional]
**annotations** | **Map&lt;String, String&gt;** |  |  [optional]
**ownerReferences** | **String** |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**resolvedContainers** | **List&lt;String&gt;** |  |  [optional]
**data** | **String** |  |  [optional]
**clientId** | **String** |  |  [optional]
**attackUid** | **String** |  |  [optional]
**teamId** | **String** |  |  [optional]
**resolved** | **Boolean** |  |  [optional]


<a name="KindEnum"></a>
## Enum: KindEnum
Name | Value
---- | -----
DEPLOYMENT | &quot;DEPLOYMENT&quot;
REPLICASET | &quot;REPLICASET&quot;
POD | &quot;POD&quot;
DAEMONSET | &quot;DAEMONSET&quot;
STATEFULSET | &quot;STATEFULSET&quot;



