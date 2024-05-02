package com.wizzdi.examples.runtime.api.request;

public class AmountWithBreakdown {

  private AmountBreakdown breakdown;

  private String value;

  private String currency_code;

  /**
   * @return breakdown
   */
  public AmountBreakdown getBreakdown() {
    return this.breakdown;
  }

  /**
   * @param breakdown breakdown to set
   * @return AmountWithBreakdown
   */
  public <T extends AmountWithBreakdown> T setBreakdown(AmountBreakdown breakdown) {
    this.breakdown = breakdown;
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
   * @return AmountWithBreakdown
   */
  public <T extends AmountWithBreakdown> T setValue(String value) {
    this.value = value;
    return (T) this;
  }

  /**
   * @return currency_code
   */
  public String getCurrency_code() {
    return this.currency_code;
  }

  /**
   * @param currency_code currency_code to set
   * @return AmountWithBreakdown
   */
  public <T extends AmountWithBreakdown> T setCurrency_code(String currency_code) {
    this.currency_code = currency_code;
    return (T) this;
  }
}
