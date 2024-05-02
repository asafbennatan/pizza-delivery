package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.Customer;
import java.util.List;

public class PaypalWalletVaultResponse {

  private Object owner_id;

  private List<LinkDescription> links;

  private String id;

  private VaultResponseStatus status;

  private Customer customer;

  /**
   * @return owner_id
   */
  public Object getOwner_id() {
    return this.owner_id;
  }

  /**
   * @param owner_id owner_id to set
   * @return PaypalWalletVaultResponse
   */
  public <T extends PaypalWalletVaultResponse> T setOwner_id(Object owner_id) {
    this.owner_id = owner_id;
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
   * @return PaypalWalletVaultResponse
   */
  public <T extends PaypalWalletVaultResponse> T setLinks(List<LinkDescription> links) {
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
   * @return PaypalWalletVaultResponse
   */
  public <T extends PaypalWalletVaultResponse> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return status
   */
  public VaultResponseStatus getStatus() {
    return this.status;
  }

  /**
   * @param status status to set
   * @return PaypalWalletVaultResponse
   */
  public <T extends PaypalWalletVaultResponse> T setStatus(VaultResponseStatus status) {
    this.status = status;
    return (T) this;
  }

  /**
   * @return customer
   */
  public Customer getCustomer() {
    return this.customer;
  }

  /**
   * @param customer customer to set
   * @return PaypalWalletVaultResponse
   */
  public <T extends PaypalWalletVaultResponse> T setCustomer(Customer customer) {
    this.customer = customer;
    return (T) this;
  }
}
