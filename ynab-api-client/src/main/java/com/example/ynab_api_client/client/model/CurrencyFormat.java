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
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


import com.example.ynab_api_client.client.invoker.ApiClient;
/**
 * The currency format setting for the budget.  In some cases the format will not be available and will be specified as null.
 */
@JsonPropertyOrder({
  CurrencyFormat.JSON_PROPERTY_ISO_CODE,
  CurrencyFormat.JSON_PROPERTY_EXAMPLE_FORMAT,
  CurrencyFormat.JSON_PROPERTY_DECIMAL_DIGITS,
  CurrencyFormat.JSON_PROPERTY_DECIMAL_SEPARATOR,
  CurrencyFormat.JSON_PROPERTY_SYMBOL_FIRST,
  CurrencyFormat.JSON_PROPERTY_GROUP_SEPARATOR,
  CurrencyFormat.JSON_PROPERTY_CURRENCY_SYMBOL,
  CurrencyFormat.JSON_PROPERTY_DISPLAY_SYMBOL
})
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen", date = "2025-07-01T21:45:22.500220+02:00[Europe/Zurich]", comments = "Generator version: 7.14.0")
public class CurrencyFormat {
  public static final String JSON_PROPERTY_ISO_CODE = "iso_code";
  @jakarta.annotation.Nonnull
  private String isoCode;

  public static final String JSON_PROPERTY_EXAMPLE_FORMAT = "example_format";
  @jakarta.annotation.Nonnull
  private String exampleFormat;

  public static final String JSON_PROPERTY_DECIMAL_DIGITS = "decimal_digits";
  @jakarta.annotation.Nonnull
  private Integer decimalDigits;

  public static final String JSON_PROPERTY_DECIMAL_SEPARATOR = "decimal_separator";
  @jakarta.annotation.Nonnull
  private String decimalSeparator;

  public static final String JSON_PROPERTY_SYMBOL_FIRST = "symbol_first";
  @jakarta.annotation.Nonnull
  private Boolean symbolFirst;

  public static final String JSON_PROPERTY_GROUP_SEPARATOR = "group_separator";
  @jakarta.annotation.Nonnull
  private String groupSeparator;

  public static final String JSON_PROPERTY_CURRENCY_SYMBOL = "currency_symbol";
  @jakarta.annotation.Nonnull
  private String currencySymbol;

  public static final String JSON_PROPERTY_DISPLAY_SYMBOL = "display_symbol";
  @jakarta.annotation.Nonnull
  private Boolean displaySymbol;

  public CurrencyFormat() { 
  }

  public CurrencyFormat isoCode(@jakarta.annotation.Nonnull String isoCode) {
    this.isoCode = isoCode;
    return this;
  }

  /**
   * Get isoCode
   * @return isoCode
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_ISO_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getIsoCode() {
    return isoCode;
  }


  @JsonProperty(JSON_PROPERTY_ISO_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setIsoCode(@jakarta.annotation.Nonnull String isoCode) {
    this.isoCode = isoCode;
  }


  public CurrencyFormat exampleFormat(@jakarta.annotation.Nonnull String exampleFormat) {
    this.exampleFormat = exampleFormat;
    return this;
  }

  /**
   * Get exampleFormat
   * @return exampleFormat
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_EXAMPLE_FORMAT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getExampleFormat() {
    return exampleFormat;
  }


  @JsonProperty(JSON_PROPERTY_EXAMPLE_FORMAT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setExampleFormat(@jakarta.annotation.Nonnull String exampleFormat) {
    this.exampleFormat = exampleFormat;
  }


  public CurrencyFormat decimalDigits(@jakarta.annotation.Nonnull Integer decimalDigits) {
    this.decimalDigits = decimalDigits;
    return this;
  }

  /**
   * Get decimalDigits
   * @return decimalDigits
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DECIMAL_DIGITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getDecimalDigits() {
    return decimalDigits;
  }


  @JsonProperty(JSON_PROPERTY_DECIMAL_DIGITS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDecimalDigits(@jakarta.annotation.Nonnull Integer decimalDigits) {
    this.decimalDigits = decimalDigits;
  }


  public CurrencyFormat decimalSeparator(@jakarta.annotation.Nonnull String decimalSeparator) {
    this.decimalSeparator = decimalSeparator;
    return this;
  }

  /**
   * Get decimalSeparator
   * @return decimalSeparator
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DECIMAL_SEPARATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getDecimalSeparator() {
    return decimalSeparator;
  }


  @JsonProperty(JSON_PROPERTY_DECIMAL_SEPARATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDecimalSeparator(@jakarta.annotation.Nonnull String decimalSeparator) {
    this.decimalSeparator = decimalSeparator;
  }


  public CurrencyFormat symbolFirst(@jakarta.annotation.Nonnull Boolean symbolFirst) {
    this.symbolFirst = symbolFirst;
    return this;
  }

  /**
   * Get symbolFirst
   * @return symbolFirst
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_SYMBOL_FIRST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Boolean getSymbolFirst() {
    return symbolFirst;
  }


  @JsonProperty(JSON_PROPERTY_SYMBOL_FIRST)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setSymbolFirst(@jakarta.annotation.Nonnull Boolean symbolFirst) {
    this.symbolFirst = symbolFirst;
  }


  public CurrencyFormat groupSeparator(@jakarta.annotation.Nonnull String groupSeparator) {
    this.groupSeparator = groupSeparator;
    return this;
  }

  /**
   * Get groupSeparator
   * @return groupSeparator
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_GROUP_SEPARATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getGroupSeparator() {
    return groupSeparator;
  }


  @JsonProperty(JSON_PROPERTY_GROUP_SEPARATOR)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setGroupSeparator(@jakarta.annotation.Nonnull String groupSeparator) {
    this.groupSeparator = groupSeparator;
  }


  public CurrencyFormat currencySymbol(@jakarta.annotation.Nonnull String currencySymbol) {
    this.currencySymbol = currencySymbol;
    return this;
  }

  /**
   * Get currencySymbol
   * @return currencySymbol
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_CURRENCY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getCurrencySymbol() {
    return currencySymbol;
  }


  @JsonProperty(JSON_PROPERTY_CURRENCY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCurrencySymbol(@jakarta.annotation.Nonnull String currencySymbol) {
    this.currencySymbol = currencySymbol;
  }


  public CurrencyFormat displaySymbol(@jakarta.annotation.Nonnull Boolean displaySymbol) {
    this.displaySymbol = displaySymbol;
    return this;
  }

  /**
   * Get displaySymbol
   * @return displaySymbol
   */
  @jakarta.annotation.Nonnull
  @JsonProperty(JSON_PROPERTY_DISPLAY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Boolean getDisplaySymbol() {
    return displaySymbol;
  }


  @JsonProperty(JSON_PROPERTY_DISPLAY_SYMBOL)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setDisplaySymbol(@jakarta.annotation.Nonnull Boolean displaySymbol) {
    this.displaySymbol = displaySymbol;
  }


  /**
   * Return true if this CurrencyFormat object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CurrencyFormat currencyFormat = (CurrencyFormat) o;
    return Objects.equals(this.isoCode, currencyFormat.isoCode) &&
        Objects.equals(this.exampleFormat, currencyFormat.exampleFormat) &&
        Objects.equals(this.decimalDigits, currencyFormat.decimalDigits) &&
        Objects.equals(this.decimalSeparator, currencyFormat.decimalSeparator) &&
        Objects.equals(this.symbolFirst, currencyFormat.symbolFirst) &&
        Objects.equals(this.groupSeparator, currencyFormat.groupSeparator) &&
        Objects.equals(this.currencySymbol, currencyFormat.currencySymbol) &&
        Objects.equals(this.displaySymbol, currencyFormat.displaySymbol);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isoCode, exampleFormat, decimalDigits, decimalSeparator, symbolFirst, groupSeparator, currencySymbol, displaySymbol);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CurrencyFormat {\n");
    sb.append("    isoCode: ").append(toIndentedString(isoCode)).append("\n");
    sb.append("    exampleFormat: ").append(toIndentedString(exampleFormat)).append("\n");
    sb.append("    decimalDigits: ").append(toIndentedString(decimalDigits)).append("\n");
    sb.append("    decimalSeparator: ").append(toIndentedString(decimalSeparator)).append("\n");
    sb.append("    symbolFirst: ").append(toIndentedString(symbolFirst)).append("\n");
    sb.append("    groupSeparator: ").append(toIndentedString(groupSeparator)).append("\n");
    sb.append("    currencySymbol: ").append(toIndentedString(currencySymbol)).append("\n");
    sb.append("    displaySymbol: ").append(toIndentedString(displaySymbol)).append("\n");
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

    // add `iso_code` to the URL query string
    if (getIsoCode() != null) {
      joiner.add(String.format("%siso_code%s=%s", prefix, suffix, ApiClient.urlEncode(ApiClient.valueToString(getIsoCode()))));
    }

    // add `example_format` to the URL query string
    if (getExampleFormat() != null) {
      joiner.add(String.format("%sexample_format%s=%s", prefix, suffix, ApiClient.urlEncode(ApiClient.valueToString(getExampleFormat()))));
    }

    // add `decimal_digits` to the URL query string
    if (getDecimalDigits() != null) {
      joiner.add(String.format("%sdecimal_digits%s=%s", prefix, suffix, ApiClient.urlEncode(ApiClient.valueToString(getDecimalDigits()))));
    }

    // add `decimal_separator` to the URL query string
    if (getDecimalSeparator() != null) {
      joiner.add(String.format("%sdecimal_separator%s=%s", prefix, suffix, ApiClient.urlEncode(ApiClient.valueToString(getDecimalSeparator()))));
    }

    // add `symbol_first` to the URL query string
    if (getSymbolFirst() != null) {
      joiner.add(String.format("%ssymbol_first%s=%s", prefix, suffix, ApiClient.urlEncode(ApiClient.valueToString(getSymbolFirst()))));
    }

    // add `group_separator` to the URL query string
    if (getGroupSeparator() != null) {
      joiner.add(String.format("%sgroup_separator%s=%s", prefix, suffix, ApiClient.urlEncode(ApiClient.valueToString(getGroupSeparator()))));
    }

    // add `currency_symbol` to the URL query string
    if (getCurrencySymbol() != null) {
      joiner.add(String.format("%scurrency_symbol%s=%s", prefix, suffix, ApiClient.urlEncode(ApiClient.valueToString(getCurrencySymbol()))));
    }

    // add `display_symbol` to the URL query string
    if (getDisplaySymbol() != null) {
      joiner.add(String.format("%sdisplay_symbol%s=%s", prefix, suffix, ApiClient.urlEncode(ApiClient.valueToString(getDisplaySymbol()))));
    }

    return joiner.toString();
  }
}

