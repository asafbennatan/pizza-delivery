package com.wizzdi.examples.runtime.api.request;

import java.util.List;

public class OrderRequest {

  private CheckoutPaymentIntent intent;

  private Payer payer;

  private List<PurchaseUnitRequest> purchase_units;

  private PaymentSource payment_source;

  private OrderApplicationContext application_context;

  /**
   * @return intent
   */
  public CheckoutPaymentIntent getIntent() {
    return this.intent;
  }

  /**
   * @param intent intent to set
   * @return OrderRequest
   */
  public <T extends OrderRequest> T setIntent(CheckoutPaymentIntent intent) {
    this.intent = intent;
    return (T) this;
  }

  /**
   * @return payer
   */
  public Payer getPayer() {
    return this.payer;
  }

  /**
   * @param payer payer to set
   * @return OrderRequest
   */
  public <T extends OrderRequest> T setPayer(Payer payer) {
    this.payer = payer;
    return (T) this;
  }

  /**
   * @return purchase_units
   */
  public List<PurchaseUnitRequest> getPurchase_units() {
    return this.purchase_units;
  }

  /**
   * @param purchase_units purchase_units to set
   * @return OrderRequest
   */
  public <T extends OrderRequest> T setPurchase_units(List<PurchaseUnitRequest> purchase_units) {
    this.purchase_units = purchase_units;
    return (T) this;
  }

  /**
   * @return payment_source
   */
  public PaymentSource getPayment_source() {
    return this.payment_source;
  }

  /**
   * @param payment_source payment_source to set
   * @return OrderRequest
   */
  public <T extends OrderRequest> T setPayment_source(PaymentSource payment_source) {
    this.payment_source = payment_source;
    return (T) this;
  }

  /**
   * @return application_context
   */
  public OrderApplicationContext getApplication_context() {
    return this.application_context;
  }

  /**
   * @param application_context application_context to set
   * @return OrderRequest
   */
  public <T extends OrderRequest> T setApplication_context(
      OrderApplicationContext application_context) {
    this.application_context = application_context;
    return (T) this;
  }
}
