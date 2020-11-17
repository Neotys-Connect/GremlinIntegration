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

import java.util.ArrayList;
import java.util.List;

/**
 * NewRequestRequest
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-09-22T16:18:53.536Z")



public class NewRequestRequest {
  @SerializedName("newRequests")
  private List<AccessRequest> newRequests = null;

  public NewRequestRequest newRequests(List<AccessRequest> newRequests) {
    this.newRequests = newRequests;
    return this;
  }

  public NewRequestRequest addNewRequestsItem(AccessRequest newRequestsItem) {
    if (this.newRequests == null) {
      this.newRequests = new ArrayList<AccessRequest>();
    }
    this.newRequests.add(newRequestsItem);
    return this;
  }

   /**
   * Get newRequests
   * @return newRequests
  **/
  @ApiModelProperty(value = "")
  public List<AccessRequest> getNewRequests() {
    return newRequests;
  }

  public void setNewRequests(List<AccessRequest> newRequests) {
    this.newRequests = newRequests;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NewRequestRequest newRequestRequest = (NewRequestRequest) o;
    return Objects.equals(this.newRequests, newRequestRequest.newRequests);
  }

  @Override
  public int hashCode() {
    return Objects.hash(newRequests);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NewRequestRequest {\n");
    
    sb.append("    newRequests: ").append(toIndentedString(newRequests)).append("\n");
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
