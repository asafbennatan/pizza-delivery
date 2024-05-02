package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.Money;
import com.wizzdi.examples.runtime.api.request.NetworkTransactionReference;
import java.util.List;

public class AuthorizationWithAdditionalData {

  private String update_time;

  private Money amount;

  private SellerProtection seller_protection;

  private String create_time;

  private NetworkTransactionReference network_transaction_reference;

  private String custom_id;

  private String expiration_time;

  private String invoice_id;

  private ProcessorResponse processor_response;

  private List<LinkDescription> links;

  private String id;

  private AuthorizationStatusDetails status_details;

  private AuthorizationStatusStatus status;

  /**
   * @return update_time
   */
  public String getUpdate_time() {
    return this.update_time;
  }

  /**
   * @param update_time update_time to set
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setUpdate_time(String update_time) {
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setAmount(Money amount) {
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setSeller_protection(
      SellerProtection seller_protection) {
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setCreate_time(String create_time) {
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setNetwork_transaction_reference(
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setCustom_id(String custom_id) {
    this.custom_id = custom_id;
    return (T) this;
  }

  /**
   * @return expiration_time
   */
  public String getExpiration_time() {
    return this.expiration_time;
  }

  /**
   * @param expiration_time expiration_time to set
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setExpiration_time(String expiration_time) {
    this.expiration_time = expiration_time;
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setInvoice_id(String invoice_id) {
    this.invoice_id = invoice_id;
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setProcessor_response(
      ProcessorResponse processor_response) {
    this.processor_response = processor_response;
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setLinks(List<LinkDescription> links) {
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
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return status_details
   */
  public AuthorizationStatusDetails getStatus_details() {
    return this.status_details;
  }

  /**
   * @param status_details status_details to set
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setStatus_details(
      AuthorizationStatusDetails status_details) {
    this.status_details = status_details;
    return (T) this;
  }

  /**
   * @return status
   */
  public AuthorizationStatusStatus getStatus() {
    return this.status;
  }

  /**
   * @param status status to set
   * @return AuthorizationWithAdditionalData
   */
  public <T extends AuthorizationWithAdditionalData> T setStatus(AuthorizationStatusStatus status) {
    this.status = status;
    return (T) this;
  }
}
