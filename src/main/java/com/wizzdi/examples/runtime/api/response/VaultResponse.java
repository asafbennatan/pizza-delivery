package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.Customer;
import java.util.List;

public class VaultResponse {

  private String id;

  private VaultResponseStatus status;

  private Customer customer;

  private List<LinkDescription> links;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return VaultResponse
   */
  public <T extends VaultResponse> T setId(String id) {
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
   * @return VaultResponse
   */
  public <T extends VaultResponse> T setStatus(VaultResponseStatus status) {
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
   * @return VaultResponse
   */
  public <T extends VaultResponse> T setCustomer(Customer customer) {
    this.customer = customer;
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
   * @return VaultResponse
   */
  public <T extends VaultResponse> T setLinks(List<LinkDescription> links) {
    this.links = links;
    return (T) this;
  }
}
