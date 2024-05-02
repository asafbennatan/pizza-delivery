package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.DisbursementMode;
import com.wizzdi.examples.runtime.api.request.Money;
import com.wizzdi.examples.runtime.api.request.NetworkTransactionReference;
import java.util.List;

public class Capture {

  private DisbursementMode disbursement_mode;

  private Money amount;

  private SellerProtection seller_protection;

  private String create_time;

  private NetworkTransactionReference network_transaction_reference;

  private String custom_id;

  private String update_time;

  private Boolean final_capture;

  private SellerReceivableBreakdown seller_receivable_breakdown;

  private String invoice_id;

  private List<LinkDescription> links;

  private ProcessorResponse processor_response;

  private String id;

  private CaptureStatusDetails status_details;

  private CaptureStatusStatus status;

  /**
   * @return disbursement_mode
   */
  public DisbursementMode getDisbursement_mode() {
    return this.disbursement_mode;
  }

  /**
   * @param disbursement_mode disbursement_mode to set
   * @return Capture
   */
  public <T extends Capture> T setDisbursement_mode(DisbursementMode disbursement_mode) {
    this.disbursement_mode = disbursement_mode;
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
   * @return Capture
   */
  public <T extends Capture> T setAmount(Money amount) {
    this.amount = amount;
    return (T) this;
  }

  /**
   * @return seller_protection
   */
  public SellerProtection getSeller_protection() {
    return this.seller_protection;
  }

  /**
   * @param seller_protection seller_protection to set
   * @return Capture
   */
  public <T extends Capture> T setSeller_protection(SellerProtection seller_protection) {
    this.seller_protection = seller_protection;
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
   * @return Capture
   */
  public <T extends Capture> T setCreate_time(String create_time) {
    this.create_time = create_time;
    return (T) this;
  }

  /**
   * @return network_transaction_reference
   */
  public NetworkTransactionReference getNetwork_transaction_reference() {
    return this.network_transaction_reference;
  }

  /**
   * @param network_transaction_reference network_transaction_reference to set
   * @return Capture
   */
  public <T extends Capture> T setNetwork_transaction_reference(
      NetworkTransactionReference network_transaction_reference) {
    this.network_transaction_reference = network_transaction_reference;
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
   * @return Capture
   */
  public <T extends Capture> T setCustom_id(String custom_id) {
    this.custom_id = custom_id;
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
   * @return Capture
   */
  public <T extends Capture> T setUpdate_time(String update_time) {
    this.update_time = update_time;
    return (T) this;
  }

  /**
   * @return final_capture
   */
  public Boolean getFinal_capture() {
    return this.final_capture;
  }

  /**
   * @param final_capture final_capture to set
   * @return Capture
   */
  public <T extends Capture> T setFinal_capture(Boolean final_capture) {
    this.final_capture = final_capture;
    return (T) this;
  }

  /**
   * @return seller_receivable_breakdown
   */
  public SellerReceivableBreakdown getSeller_receivable_breakdown() {
    return this.seller_receivable_breakdown;
  }

  /**
   * @param seller_receivable_breakdown seller_receivable_breakdown to set
   * @return Capture
   */
  public <T extends Capture> T setSeller_receivable_breakdown(
      SellerReceivableBreakdown seller_receivable_breakdown) {
    this.seller_receivable_breakdown = seller_receivable_breakdown;
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
   * @return Capture
   */
  public <T extends Capture> T setInvoice_id(String invoice_id) {
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
   * @return Capture
   */
  public <T extends Capture> T setLinks(List<LinkDescription> links) {
    this.links = links;
    return (T) this;
  }

  /**
   * @return processor_response
   */
  public ProcessorResponse getProcessor_response() {
    return this.processor_response;
  }

  /**
   * @param processor_response processor_response to set
   * @return Capture
   */
  public <T extends Capture> T setProcessor_response(ProcessorResponse processor_response) {
    this.processor_response = processor_response;
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
   * @return Capture
   */
  public <T extends Capture> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return status_details
   */
  public CaptureStatusDetails getStatus_details() {
    return this.status_details;
  }

  /**
   * @param status_details status_details to set
   * @return Capture
   */
  public <T extends Capture> T setStatus_details(CaptureStatusDetails status_details) {
    this.status_details = status_details;
    return (T) this;
  }

  /**
   * @return status
   */
  public CaptureStatusStatus getStatus() {
    return this.status;
  }

  /**
   * @param status status to set
   * @return Capture
   */
  public <T extends Capture> T setStatus(CaptureStatusStatus status) {
    this.status = status;
    return (T) this;
  }
}
