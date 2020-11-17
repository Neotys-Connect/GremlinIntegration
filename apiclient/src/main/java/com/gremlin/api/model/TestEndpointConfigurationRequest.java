/*
 * The Gremlin API
 * The API for interacting with Gremlin's 'Failure as a Service'
 *
 * OpenAPI spec version: v1
 * Contact: support@gremlin.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package com.gremlin.api.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;
import io.swagger.annotations.ApiModelProperty;

/**
 * TestEndpointConfigurationRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-09-22T16:18:53.536Z")



public class TestEndpointConfigurationRequest {
  @SerializedName("endpointConfiguration")
  private EndpointConfiguration endpointConfiguration = null;

  public TestEndpointConfigurationRequest endpointConfiguration(EndpointConfiguration endpointConfiguration) {
    this.endpointConfiguration = endpointConfiguration;
    return this;
  }

   /**
   * Get endpointConfiguration
   * @return endpointConfiguration
  **/
  @ApiModelProperty(value = "")
  public EndpointConfiguration getEndpointConfiguration() {
    return endpointConfiguration;
  }

  public void setEndpointConfiguration(EndpointConfiguration endpointConfiguration) {
    this.endpointConfiguration = endpointConfiguration;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TestEndpointConfigurationRequest testEndpointConfigurationRequest = (TestEndpointConfigurationRequest) o;
    return Objects.equals(this.endpointConfiguration, testEndpointConfigurationRequest.endpointConfiguration);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpointConfiguration);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TestEndpointConfigurationRequest {\n");
    
    sb.append("    endpointConfiguration: ").append(toIndentedString(endpointConfiguration)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
