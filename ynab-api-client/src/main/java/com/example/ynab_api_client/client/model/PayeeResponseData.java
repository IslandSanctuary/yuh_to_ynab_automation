/*
 * YNAB API Endpoints
 * Our API uses a REST based design, leverages the JSON data format, and relies upon HTTPS for transport. We respond with meaningful HTTP response codes and if an error occurs, we include error details in the response body.  API Documentation is at https://api.ynab.com
 *
 * The version of the OpenAPI document: 1.75.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */


package com.example.ynab_api_client.client.model;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.StringJoiner;
import java.util.Objects;
import java.util.Map;
import java.util.HashMap;
import com.example.ynab_api_client.client.model.Payee;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.example.ynab_api_client.client.invoker.ApiClient;
/**
 * PayeeResponseData
 */
@JsonPropertyOrder({
  PayeeResponseData.JSON_PROPERTY_PAYEE
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-01T21:45:22.500220+02:00[Europe/Zurich]", comments = "Generator version: 7.14.0")
public class PayeeResponseData {
  public static final String JSON_PROPERTY_PAYEE = "payee";
  @jakarta.annotation.Nonnull
  private Payee payee;

  public PayeeResponseData() { 
  }

  public PayeeResponseData payee(@jakarta.annotation.Nonnull Payee payee) {
    this.payee = payee;
    return this;
  }

  /**
   * Get payee
   * @return payee
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_PAYEE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Payee getPayee() {
    return payee;
  }


  @JsonProperty(JSON_PROPERTY_PAYEE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setPayee(@jakarta.annotation.Nonnull Payee payee) {
    this.payee = payee;
  }


  /**
   * Return true if this PayeeResponse_data object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PayeeResponseData payeeResponseData = (PayeeResponseData) o;
    return Objects.equals(this.payee, payeeResponseData.payee);
  }

  @Override
  public int hashCode() {
    return Objects.hash(payee);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PayeeResponseData {\n");
    sb.append("    payee: ").append(toIndentedString(payee)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @return URL query string
   */
  public String toUrlQueryString() {
    return toUrlQueryString(null);
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    String suffix = "";
    String containerSuffix = "";
    String containerPrefix = "";
    if (prefix == null) {
      // style=form, explode=true, e.g. /pet?name=cat&type=manx
      prefix = "";
    } else {
      // deepObject style e.g. /pet?id[name]=cat&id[type]=manx
      prefix = prefix + "[";
      suffix = "]";
      containerSuffix = "]";
      containerPrefix = "[";
    }

    StringJoiner joiner = new StringJoiner("&");

    // add `payee` to the URL query string
    if (getPayee() != null) {
      joiner.add(getPayee().toUrlQueryString(prefix + "payee" + suffix));
    }

    return joiner.toString();
  }
}

