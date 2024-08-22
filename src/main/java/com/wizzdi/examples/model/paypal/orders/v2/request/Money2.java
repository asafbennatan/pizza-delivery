package com.wizzdi.examples.model.paypal.orders.v2.request;

public class Money2 {

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
   * @return Money2
   */
  public <T extends Money2> T setCurrency_code(String currency_code) {
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
   * @return Money2
   */
  public <T extends Money2> T setValue(String value) {
    this.value = value;
    return (T) this;
  }
}
