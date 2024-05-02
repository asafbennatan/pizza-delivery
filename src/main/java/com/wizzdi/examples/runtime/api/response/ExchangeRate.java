package com.wizzdi.examples.runtime.api.response;

public class ExchangeRate {

  private String source_currency;

  private String target_currency;

  private String value;

  /**
   * @return source_currency
   */
  public String getSource_currency() {
    return this.source_currency;
  }

  /**
   * @param source_currency source_currency to set
   * @return ExchangeRate
   */
  public <T extends ExchangeRate> T setSource_currency(String source_currency) {
    this.source_currency = source_currency;
    return (T) this;
  }

  /**
   * @return target_currency
   */
  public String getTarget_currency() {
    return this.target_currency;
  }

  /**
   * @param target_currency target_currency to set
   * @return ExchangeRate
   */
  public <T extends ExchangeRate> T setTarget_currency(String target_currency) {
    this.target_currency = target_currency;
    return (T) this;
  }

  /**
   * @return value
   */
  public String getValue() {
    return this.value;
  }

  /**
   * @param value value to set
   * @return ExchangeRate
   */
  public <T extends ExchangeRate> T setValue(String value) {
    this.value = value;
    return (T) this;
  }
}
