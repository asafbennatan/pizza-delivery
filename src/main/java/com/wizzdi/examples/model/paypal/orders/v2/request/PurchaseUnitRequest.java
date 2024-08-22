package com.wizzdi.examples.model.paypal.orders.v2.request;

import java.util.List;

public class PurchaseUnitRequest {

  private String reference_id;

  private AmountWithBreakdown amount;

  private Payee payee;

  private PaymentInstruction payment_instruction;

  private String description;

  private String custom_id;

  private String invoice_id;

  private String soft_descriptor;

  private List<Item> items;

  private ShippingDetail shipping;

  private SupplementaryData supplementary_data;

  /**
   * @return reference_id
   */
  public String getReference_id() {
    return this.reference_id;
  }

  /**
   * @param reference_id reference_id to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setReference_id(String reference_id) {
    this.reference_id = reference_id;
    return (T) this;
  }

  /**
   * @return amount
   */
  public AmountWithBreakdown getAmount() {
    return this.amount;
  }

  /**
   * @param amount amount to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setAmount(AmountWithBreakdown amount) {
    this.amount = amount;
    return (T) this;
  }

  /**
   * @return payee
   */
  public Payee getPayee() {
    return this.payee;
  }

  /**
   * @param payee payee to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setPayee(Payee payee) {
    this.payee = payee;
    return (T) this;
  }

  /**
   * @return payment_instruction
   */
  public PaymentInstruction getPayment_instruction() {
    return this.payment_instruction;
  }

  /**
   * @param payment_instruction payment_instruction to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setPayment_instruction(
      PaymentInstruction payment_instruction) {
    this.payment_instruction = payment_instruction;
    return (T) this;
  }

  /**
   * @return description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * @param description description to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setDescription(String description) {
    this.description = description;
    return (T) this;
  }

  /**
   * @return custom_id
   */
  public String getCustom_id() {
    return this.custom_id;
  }

  /**
   * @param custom_id custom_id to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setCustom_id(String custom_id) {
    this.custom_id = custom_id;
    return (T) this;
  }

  /**
   * @return invoice_id
   */
  public String getInvoice_id() {
    return this.invoice_id;
  }

  /**
   * @param invoice_id invoice_id to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setInvoice_id(String invoice_id) {
    this.invoice_id = invoice_id;
    return (T) this;
  }

  /**
   * @return soft_descriptor
   */
  public String getSoft_descriptor() {
    return this.soft_descriptor;
  }

  /**
   * @param soft_descriptor soft_descriptor to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setSoft_descriptor(String soft_descriptor) {
    this.soft_descriptor = soft_descriptor;
    return (T) this;
  }

  /**
   * @return items
   */
  public List<Item> getItems() {
    return this.items;
  }

  /**
   * @param items items to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setItems(List<Item> items) {
    this.items = items;
    return (T) this;
  }

  /**
   * @return shipping
   */
  public ShippingDetail getShipping() {
    return this.shipping;
  }

  /**
   * @param shipping shipping to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setShipping(ShippingDetail shipping) {
    this.shipping = shipping;
    return (T) this;
  }

  /**
   * @return supplementary_data
   */
  public SupplementaryData getSupplementary_data() {
    return this.supplementary_data;
  }

  /**
   * @param supplementary_data supplementary_data to set
   * @return PurchaseUnitRequest
   */
  public <T extends PurchaseUnitRequest> T setSupplementary_data(
      SupplementaryData supplementary_data) {
    this.supplementary_data = supplementary_data;
    return (T) this;
  }
}
