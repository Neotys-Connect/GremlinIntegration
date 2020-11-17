
# K8sObjectResponse

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**clusterId** | **String** |  |  [optional]
**ownerReferences** | **String** |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**resolvedContainers** | **List&lt;String&gt;** |  |  [optional]
**uid** | **String** |  |  [optional]
**namespace** | **String** |  |  [optional]
**name** | **String** |  |  [optional]
**kind** | [**KindEnum**](#KindEnum) |  |  [optional]
**labels** | **Map&lt;String, String&gt;** |  |  [optional]
**annotations** | **Map&lt;String, String&gt;** |  |  [optional]
**podPhase** | [**PodPhaseEnum**](#PodPhaseEnum) |  |  [optional]


<a name="KindEnum"></a>
## Enum: KindEnum
Name | Value
---- | -----
DEPLOYMENT | &quot;DEPLOYMENT&quot;
REPLICASET | &quot;REPLICASET&quot;
POD | &quot;POD&quot;
DAEMONSET | &quot;DAEMONSET&quot;
STATEFULSET | &quot;STATEFULSET&quot;


<a name="PodPhaseEnum"></a>
## Enum: PodPhaseEnum
Name | Value
---- | -----
PENDING | &quot;Pending&quot;
RUNNING | &quot;Running&quot;
SUCCEEDED | &quot;Succeeded&quot;
FAILED | &quot;Failed&quot;
UNKNOWN | &quot;Unknown&quot;



