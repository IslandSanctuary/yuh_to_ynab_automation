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
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * The type of account
 */
public enum AccountType {
  
  CHECKING("checking"),
  
  SAVINGS("savings"),
  
  CASH("cash"),
  
  CREDIT_CARD("creditCard"),
  
  LINE_OF_CREDIT("lineOfCredit"),
  
  OTHER_ASSET("otherAsset"),
  
  OTHER_LIABILITY("otherLiability"),
  
  MORTGAGE("mortgage"),
  
  AUTO_LOAN("autoLoan"),
  
  STUDENT_LOAN("studentLoan"),
  
  PERSONAL_LOAN("personalLoan"),
  
  MEDICAL_DEBT("medicalDebt"),
  
  OTHER_DEBT("otherDebt");

  private String value;

  AccountType(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static AccountType fromValue(String value) {
    for (AccountType b : AccountType.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }

  /**
   * Convert the instance into URL query string.
   *
   * @param prefix prefix of the query string
   * @return URL query string
   */
  public String toUrlQueryString(String prefix) {
    if (prefix == null) {
      prefix = "";
    }

    return String.format("%s=%s", prefix, this.toString());
  }

}

