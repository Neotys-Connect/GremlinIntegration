
# X509Certificate

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**type** | **String** |  |  [optional]
**subjectX500Principal** | [**X500Principal**](X500Principal.md) |  |  [optional]
**issuerX500Principal** | [**X500Principal**](X500Principal.md) |  |  [optional]
**issuerDN** | [**Principal**](Principal.md) |  |  [optional]
**subjectDN** | [**Principal**](Principal.md) |  |  [optional]
**version** | **Integer** |  |  [optional]
**notBefore** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**notAfter** | [**OffsetDateTime**](OffsetDateTime.md) |  |  [optional]
**serialNumber** | **Integer** |  |  [optional]
**tbscertificate** | **List&lt;byte[]&gt;** |  |  [optional]
**sigAlgName** | **String** |  |  [optional]
**sigAlgOID** | **String** |  |  [optional]
**sigAlgParams** | **List&lt;byte[]&gt;** |  |  [optional]
**issuerUniqueID** | **List&lt;Boolean&gt;** |  |  [optional]
**subjectUniqueID** | **List&lt;Boolean&gt;** |  |  [optional]
**keyUsage** | **List&lt;Boolean&gt;** |  |  [optional]
**extendedKeyUsage** | **List&lt;String&gt;** |  |  [optional]
**subjectAlternativeNames** | [**List&lt;List&lt;Object&gt;&gt;**](List.md) |  |  [optional]
**issuerAlternativeNames** | [**List&lt;List&lt;Object&gt;&gt;**](List.md) |  |  [optional]
**signature** | **List&lt;byte[]&gt;** |  |  [optional]
**basicConstraints** | **Integer** |  |  [optional]
**criticalExtensionOIDs** | **List&lt;String&gt;** |  |  [optional]
**nonCriticalExtensionOIDs** | **List&lt;String&gt;** |  |  [optional]
**encoded** | **List&lt;byte[]&gt;** |  |  [optional]
**publicKey** | [**PublicKey**](PublicKey.md) |  |  [optional]



