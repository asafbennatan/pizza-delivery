package com.wizzdi.examples.runtime.api.request;

public class Money {

  private String currency_code;

  private String value;

  /**
   * @return currency_code
   */
  public String getCurrency_code() {
    return this.currency_code;
  }

  /**
   * @param currency_code currency_code to set
   * @return Money
   */
  public <T extends Money> T setCurrency_code(String currency_code) {
    this.currency_code = currency_code;
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
   * @return Money
   */
  public <T extends Money> T setValue(String value) {
    this.value = value;
    return (T) this;
  }
}
