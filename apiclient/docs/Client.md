
# Client

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**containers** | [**List&lt;Container&gt;**](Container.md) |  |  [optional]
**osName** | **String** |  |  [optional]
**osVersion** | **String** |  |  [optional]
**cloud** | **String** |  |  [optional]
**serviceOrDefault** | **String** |  |  [optional]
**containerRuntime** | **String** |  |  [optional]
**containerRuntimeVersion** | **String** |  |  [optional]
**kubernetesVersion** | **String** |  |  [optional]
**osType** | **String** |  |  [optional]
**dockerVersion** | **String** |  |  [optional]
**metricsEnabled** | **Boolean** |  |  [optional]
**containerHash** | **Integer** |  |  [optional]
**service** | **String** |  |  [optional]
**gremlinClientVersion** | **String** |  |  [optional]
**authType** | [**AuthTypeEnum**](#AuthTypeEnum) |  |  [optional]
**proxied** | **Boolean** |  |  [optional]
**instanceStartTime** | **String** |  |  [optional]
**tags** | **Map&lt;String, String&gt;** |  |  [optional]
**id** | **String** |  |  [optional]
**type** | [**TypeEnum**](#TypeEnum) |  |  [optional]
**labels** | **Map&lt;String, String&gt;** |  |  [optional]
**state** | [**StateEnum**](#StateEnum) |  |  [optional]
**active** | **Boolean** |  |  [optional]
**revokedBy** | **String** |  |  [optional]
**revoked** | **Boolean** |  |  [optional]
**idle** | **Boolean** |  |  [optional]
**identifier** | **String** |  |  [optional]
**attributes** | **Map&lt;String, Object&gt;** |  |  [optional]
**orgId** | **String** |  |  [optional]
**lastSeen** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**lastActiveEmitted** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**createdAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**updatedAt** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]


<a name="AuthTypeEnum"></a>
## Enum: AuthTypeEnum
Name | Value
---- | -----
SECRET | &quot;SECRET&quot;
CERTIFICATE | &quot;CERTIFICATE&quot;


<a name="TypeEnum"></a>
## Enum: TypeEnum
Name | Value
---- | -----
HOST | &quot;Host&quot;
CONTAINER | &quot;Container&quot;
DOCKER | &quot;Docker&quot;
KUBERNETES | &quot;Kubernetes&quot;


<a name="StateEnum"></a>
## Enum: StateEnum
Name | Value
---- | -----
ACTIVE | &quot;ACTIVE&quot;
IDLE | &quot;IDLE&quot;
REVOKED | &quot;REVOKED&quot;
INVITED | &quot;INVITED&quot;



