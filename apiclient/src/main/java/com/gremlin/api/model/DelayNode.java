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
 * DelayNode
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2020-09-22T16:18:53.536Z")



public class DelayNode extends GraphNode {
  @SerializedName("delay")
  private Integer delay = null;

  public DelayNode delay(Integer delay) {
    this.delay = delay;
    return this;
  }

   /**
   * Get delay
   * @return delay
  **/
  @ApiModelProperty(value = "")
  public Integer getDelay() {
    return delay;
  }

  public void setDelay(Integer delay) {
    this.delay = delay;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DelayNode delayNode = (DelayNode) o;
    return Objects.equals(this.delay, delayNode.delay) &&
        super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(delay, super.hashCode());
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DelayNode {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    delay: ").append(toIndentedString(delay)).append("\n");
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
