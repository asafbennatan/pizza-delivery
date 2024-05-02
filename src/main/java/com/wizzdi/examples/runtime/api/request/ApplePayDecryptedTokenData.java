package com.wizzdi.examples.runtime.api.request;

public class ApplePayDecryptedTokenData {

  private Money2 transaction_amount;

  private Card tokenized_card;

  private String device_manufacturer_id;

  private ApplePayDecryptedTokenDataPaymentDataType payment_data_type;

  private ApplePayPaymentData payment_data;

  /**
   * @return transaction_amount
   */
  public Money2 getTransaction_amount() {
    return this.transaction_amount;
  }

  /**
   * @param transaction_amount transaction_amount to set
   * @return ApplePayDecryptedTokenData
   */
  public <T extends ApplePayDecryptedTokenData> T setTransaction_amount(Money2 transaction_amount) {
    this.transaction_amount = transaction_amount;
    return (T) this;
  }

  /**
   * @return tokenized_card
   */
  public Card getTokenized_card() {
    return this.tokenized_card;
  }

  /**
   * @param tokenized_card tokenized_card to set
   * @return ApplePayDecryptedTokenData
   */
  public <T extends ApplePayDecryptedTokenData> T setTokenized_card(Card tokenized_card) {
    this.tokenized_card = tokenized_card;
    return (T) this;
  }

  /**
   * @return device_manufacturer_id
   */
  public String getDevice_manufacturer_id() {
    return this.device_manufacturer_id;
  }

  /**
   * @param device_manufacturer_id device_manufacturer_id to set
   * @return ApplePayDecryptedTokenData
   */
  public <T extends ApplePayDecryptedTokenData> T setDevice_manufacturer_id(
      String device_manufacturer_id) {
    this.device_manufacturer_id = device_manufacturer_id;
    return (T) this;
  }

  /**
   * @return payment_data_type
   */
  public ApplePayDecryptedTokenDataPaymentDataType getPayment_data_type() {
    return this.payment_data_type;
  }

  /**
   * @param payment_data_type payment_data_type to set
   * @return ApplePayDecryptedTokenData
   */
  public <T extends ApplePayDecryptedTokenData> T setPayment_data_type(
      ApplePayDecryptedTokenDataPaymentDataType payment_data_type) {
    this.payment_data_type = payment_data_type;
    return (T) this;
  }

  /**
   * @return payment_data
   */
  public ApplePayPaymentData getPayment_data() {
    return this.payment_data;
  }

  /**
   * @param payment_data payment_data to set
   * @return ApplePayDecryptedTokenData
   */
  public <T extends ApplePayDecryptedTokenData> T setPayment_data(
      ApplePayPaymentData payment_data) {
    this.payment_data = payment_data;
    return (T) this;
  }
}
