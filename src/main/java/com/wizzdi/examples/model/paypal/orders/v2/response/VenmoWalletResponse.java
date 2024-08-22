package com.wizzdi.examples.model.paypal.orders.v2.response;

import com.wizzdi.examples.model.paypal.orders.v2.request.AddressPortable2;
import com.wizzdi.examples.model.paypal.orders.v2.request.Name2;

public class VenmoWalletResponse {

  private String email_address;

  private String account_id;

  private String user_name;

  private Name2 name;

  private Phone2 phone_number;

  private AddressPortable2 address;

  private VenmoWalletAttributesResponse attributes;

  /**
   * @return email_address
   */
  public String getEmail_address() {
    return this.email_address;
  }

  /**
   * @param email_address email_address to set
   * @return VenmoWalletResponse
   */
  public <T extends VenmoWalletResponse> T setEmail_address(String email_address) {
    this.email_address = email_address;
    return (T) this;
  }

  /**
   * @return account_id
   */
  public String getAccount_id() {
    return this.account_id;
  }

  /**
   * @param account_id account_id to set
   * @return VenmoWalletResponse
   */
  public <T extends VenmoWalletResponse> T setAccount_id(String account_id) {
    this.account_id = account_id;
    return (T) this;
  }

  /**
   * @return user_name
   */
  public String getUser_name() {
    return this.user_name;
  }

  /**
   * @param user_name user_name to set
   * @return VenmoWalletResponse
   */
  public <T extends VenmoWalletResponse> T setUser_name(String user_name) {
    this.user_name = user_name;
    return (T) this;
  }

  /**
   * @return name
   */
  public Name2 getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return VenmoWalletResponse
   */
  public <T extends VenmoWalletResponse> T setName(Name2 name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return phone_number
   */
  public Phone2 getPhone_number() {
    return this.phone_number;
  }

  /**
   * @param phone_number phone_number to set
   * @return VenmoWalletResponse
   */
  public <T extends VenmoWalletResponse> T setPhone_number(Phone2 phone_number) {
    this.phone_number = phone_number;
    return (T) this;
  }

  /**
   * @return address
   */
  public AddressPortable2 getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return VenmoWalletResponse
   */
  public <T extends VenmoWalletResponse> T setAddress(AddressPortable2 address) {
    this.address = address;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public VenmoWalletAttributesResponse getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return VenmoWalletResponse
   */
  public <T extends VenmoWalletResponse> T setAttributes(VenmoWalletAttributesResponse attributes) {
    this.attributes = attributes;
    return (T) this;
  }
}
