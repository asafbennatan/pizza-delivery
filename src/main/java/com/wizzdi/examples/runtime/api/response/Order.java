package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.CheckoutPaymentIntent;
import com.wizzdi.examples.runtime.api.request.Payer;
import java.util.List;

public class Order {

  private String update_time;

  private String create_time;

  private ProcessingInstruction processing_instruction;

  private List<PurchaseUnit> purchase_units;

  private List<LinkDescription> links;

  private PaymentSourceResponse payment_source;

  private String id;

  private Payer payer;

  private CheckoutPaymentIntent intent;

  private OrderStatus status;

  /**
   * @return update_time
   */
  public String getUpdate_time() {
    return this.update_time;
  }

  /**
   * @param update_time update_time to set
   * @return Order
   */
  public <T extends Order> T setUpdate_time(String update_time) {
    this.update_time = update_time;
    return (T) this;
  }

  /**
   * @return create_time
   */
  public String getCreate_time() {
    return this.create_time;
  }

  /**
   * @param create_time create_time to set
   * @return Order
   */
  public <T extends Order> T setCreate_time(String create_time) {
    this.create_time = create_time;
    return (T) this;
  }

  /**
   * @return processing_instruction
   */
  public ProcessingInstruction getProcessing_instruction() {
    return this.processing_instruction;
  }

  /**
   * @param processing_instruction processing_instruction to set
   * @return Order
   */
  public <T extends Order> T setProcessing_instruction(
      ProcessingInstruction processing_instruction) {
    this.processing_instruction = processing_instruction;
    return (T) this;
  }

  /**
   * @return purchase_units
   */
  public List<PurchaseUnit> getPurchase_units() {
    return this.purchase_units;
  }

  /**
   * @param purchase_units purchase_units to set
   * @return Order
   */
  public <T extends Order> T setPurchase_units(List<PurchaseUnit> purchase_units) {
    this.purchase_units = purchase_units;
    return (T) this;
  }

  /**
   * @return links
   */
  public List<LinkDescription> getLinks() {
    return this.links;
  }

  /**
   * @param links links to set
   * @return Order
   */
  public <T extends Order> T setLinks(List<LinkDescription> links) {
    this.links = links;
    return (T) this;
  }

  /**
   * @return payment_source
   */
  public PaymentSourceResponse getPayment_source() {
    return this.payment_source;
  }

  /**
   * @param payment_source payment_source to set
   * @return Order
   */
  public <T extends Order> T setPayment_source(PaymentSourceResponse payment_source) {
    this.payment_source = payment_source;
    return (T) this;
  }

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return Order
   */
  public <T extends Order> T setId(String id) {
    this.id = id;
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
   * @return Order
   */
  public <T extends Order> T setPayer(Payer payer) {
    this.payer = payer;
    return (T) this;
  }

  /**
   * @return intent
   */
  public CheckoutPaymentIntent getIntent() {
    return this.intent;
  }

  /**
   * @param intent intent to set
   * @return Order
   */
  public <T extends Order> T setIntent(CheckoutPaymentIntent intent) {
    this.intent = intent;
    return (T) this;
  }

  /**
   * @return status
   */
  public OrderStatus getStatus() {
    return this.status;
  }

  /**
   * @param status status to set
   * @return Order
   */
  public <T extends Order> T setStatus(OrderStatus status) {
    this.status = status;
    return (T) this;
  }
}
