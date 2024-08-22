package com.wizzdi.examples.model.paypal.orders.v2.request;

public class PaymentMethod {

  private PayeePaymentMethodPreference payee_preferred;

  private PaymentMethodStandardEntryClassCode standard_entry_class_code;

  /**
   * @return payee_preferred
   */
  public PayeePaymentMethodPreference getPayee_preferred() {
    return this.payee_preferred;
  }

  /**
   * @param payee_preferred payee_preferred to set
   * @return PaymentMethod
   */
  public <T extends PaymentMethod> T setPayee_preferred(
      PayeePaymentMethodPreference payee_preferred) {
    this.payee_preferred = payee_preferred;
    return (T) this;
  }

  /**
   * @return standard_entry_class_code
   */
  public PaymentMethodStandardEntryClassCode getStandard_entry_class_code() {
    return this.standard_entry_class_code;
  }

  /**
   * @param standard_entry_class_code standard_entry_class_code to set
   * @return PaymentMethod
   */
  public <T extends PaymentMethod> T setStandard_entry_class_code(
      PaymentMethodStandardEntryClassCode standard_entry_class_code) {
    this.standard_entry_class_code = standard_entry_class_code;
    return (T) this;
  }
}
