package com.wizzdi.examples.runtime.api.request;

public class CardStoredCredential {

  private PaymentInitiator payment_initiator;

  private StoredPaymentSourcePaymentType payment_type;

  private StoredPaymentSourceUsageType usage;

  private NetworkTransactionReference previous_network_transaction_reference;

  /**
   * @return payment_initiator
   */
  public PaymentInitiator getPayment_initiator() {
    return this.payment_initiator;
  }

  /**
   * @param payment_initiator payment_initiator to set
   * @return CardStoredCredential
   */
  public <T extends CardStoredCredential> T setPayment_initiator(
      PaymentInitiator payment_initiator) {
    this.payment_initiator = payment_initiator;
    return (T) this;
  }

  /**
   * @return payment_type
   */
  public StoredPaymentSourcePaymentType getPayment_type() {
    return this.payment_type;
  }

  /**
   * @param payment_type payment_type to set
   * @return CardStoredCredential
   */
  public <T extends CardStoredCredential> T setPayment_type(
      StoredPaymentSourcePaymentType payment_type) {
    this.payment_type = payment_type;
    return (T) this;
  }

  /**
   * @return usage
   */
  public StoredPaymentSourceUsageType getUsage() {
    return this.usage;
  }

  /**
   * @param usage usage to set
   * @return CardStoredCredential
   */
  public <T extends CardStoredCredential> T setUsage(StoredPaymentSourceUsageType usage) {
    this.usage = usage;
    return (T) this;
  }

  /**
   * @return previous_network_transaction_reference
   */
  public NetworkTransactionReference getPrevious_network_transaction_reference() {
    return this.previous_network_transaction_reference;
  }

  /**
   * @param previous_network_transaction_reference previous_network_transaction_reference to set
   * @return CardStoredCredential
   */
  public <T extends CardStoredCredential> T setPrevious_network_transaction_reference(
      NetworkTransactionReference previous_network_transaction_reference) {
    this.previous_network_transaction_reference = previous_network_transaction_reference;
    return (T) this;
  }
}
