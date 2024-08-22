package com.wizzdi.examples.model.paypal.orders.v2.request;

public class ApplePayPaymentData {

  private String cryptogram;

  private String eci_indicator;

  private String emv_data;

  private String pin;

  /**
   * @return cryptogram
   */
  public String getCryptogram() {
    return this.cryptogram;
  }

  /**
   * @param cryptogram cryptogram to set
   * @return ApplePayPaymentData
   */
  public <T extends ApplePayPaymentData> T setCryptogram(String cryptogram) {
    this.cryptogram = cryptogram;
    return (T) this;
  }

  /**
   * @return eci_indicator
   */
  public String getEci_indicator() {
    return this.eci_indicator;
  }

  /**
   * @param eci_indicator eci_indicator to set
   * @return ApplePayPaymentData
   */
  public <T extends ApplePayPaymentData> T setEci_indicator(String eci_indicator) {
    this.eci_indicator = eci_indicator;
    return (T) this;
  }

  /**
   * @return emv_data
   */
  public String getEmv_data() {
    return this.emv_data;
  }

  /**
   * @param emv_data emv_data to set
   * @return ApplePayPaymentData
   */
  public <T extends ApplePayPaymentData> T setEmv_data(String emv_data) {
    this.emv_data = emv_data;
    return (T) this;
  }

  /**
   * @return pin
   */
  public String getPin() {
    return this.pin;
  }

  /**
   * @param pin pin to set
   * @return ApplePayPaymentData
   */
  public <T extends ApplePayPaymentData> T setPin(String pin) {
    this.pin = pin;
    return (T) this;
  }
}
