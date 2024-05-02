package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.Money;
import com.wizzdi.examples.runtime.api.request.PayeeBase;
import java.util.List;

public class Refund {

  private RefundParent2SellerPayableBreakdown seller_payable_breakdown;

  private String update_time;

  private Money amount;

  private String acquirer_reference_number;

  private String create_time;

  private String custom_id;

  private String invoice_id;

  private List<LinkDescription> links;

  private String id;

  private RefundStatusDetails status_details;

  private String note_to_payer;

  private PayeeBase payer;

  private RefundStatusStatus status;

  /**
   * @return seller_payable_breakdown
   */
  public RefundParent2SellerPayableBreakdown getSeller_payable_breakdown() {
    return this.seller_payable_breakdown;
  }

  /**
   * @param seller_payable_breakdown seller_payable_breakdown to set
   * @return Refund
   */
  public <T extends Refund> T setSeller_payable_breakdown(
      RefundParent2SellerPayableBreakdown seller_payable_breakdown) {
    this.seller_payable_breakdown = seller_payable_breakdown;
    return (T) this;
  }

  /**
   * @return update_time
   */
  public String getUpdate_time() {
    return this.update_time;
  }

  /**
   * @param update_time update_time to set
   * @return Refund
   */
  public <T extends Refund> T setUpdate_time(String update_time) {
    this.update_time = update_time;
    return (T) this;
  }

  /**
   * @return amount
   */
  public Money getAmount() {
    return this.amount;
  }

  /**
   * @param amount amount to set
   * @return Refund
   */
  public <T extends Refund> T setAmount(Money amount) {
    this.amount = amount;
    return (T) this;
  }

  /**
   * @return acquirer_reference_number
   */
  public String getAcquirer_reference_number() {
    return this.acquirer_reference_number;
  }

  /**
   * @param acquirer_reference_number acquirer_reference_number to set
   * @return Refund
   */
  public <T extends Refund> T setAcquirer_reference_number(String acquirer_reference_number) {
    this.acquirer_reference_number = acquirer_reference_number;
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
   * @return Refund
   */
  public <T extends Refund> T setCreate_time(String create_time) {
    this.create_time = create_time;
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
   * @return Refund
   */
  public <T extends Refund> T setCustom_id(String custom_id) {
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
   * @return Refund
   */
  public <T extends Refund> T setInvoice_id(String invoice_id) {
    this.invoice_id = invoice_id;
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
   * @return Refund
   */
  public <T extends Refund> T setLinks(List<LinkDescription> links) {
    this.links = links;
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
   * @return Refund
   */
  public <T extends Refund> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return status_details
   */
  public RefundStatusDetails getStatus_details() {
    return this.status_details;
  }

  /**
   * @param status_details status_details to set
   * @return Refund
   */
  public <T extends Refund> T setStatus_details(RefundStatusDetails status_details) {
    this.status_details = status_details;
    return (T) this;
  }

  /**
   * @return note_to_payer
   */
  public String getNote_to_payer() {
    return this.note_to_payer;
  }

  /**
   * @param note_to_payer note_to_payer to set
   * @return Refund
   */
  public <T extends Refund> T setNote_to_payer(String note_to_payer) {
    this.note_to_payer = note_to_payer;
    return (T) this;
  }

  /**
   * @return payer
   */
  public PayeeBase getPayer() {
    return this.payer;
  }

  /**
   * @param payer payer to set
   * @return Refund
   */
  public <T extends Refund> T setPayer(PayeeBase payer) {
    this.payer = payer;
    return (T) this;
  }

  /**
   * @return status
   */
  public RefundStatusStatus getStatus() {
    return this.status;
  }

  /**
   * @param status status to set
   * @return Refund
   */
  public <T extends Refund> T setStatus(RefundStatusStatus status) {
    this.status = status;
    return (T) this;
  }
}
