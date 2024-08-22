package com.wizzdi.examples.model.paypal.orders.v2.request;

public class Customer {

  private String id;

  private String email_address;

  private PhoneWithType phone;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return Customer
   */
  public <T extends Customer> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return email_address
   */
  public String getEmail_address() {
    return this.email_address;
  }

  /**
   * @param email_address email_address to set
   * @return Customer
   */
  public <T extends Customer> T setEmail_address(String email_address) {
    this.email_address = email_address;
    return (T) this;
  }

  /**
   * @return phone
   */
  public PhoneWithType getPhone() {
    return this.phone;
  }

  /**
   * @param phone phone to set
   * @return Customer
   */
  public <T extends Customer> T setPhone(PhoneWithType phone) {
    this.phone = phone;
    return (T) this;
  }
}
