package com.wizzdi.examples.runtime.api.request;

public class PaypalWalletCustomer {

  private String email_address;

  private PhoneWithType phone;

  private String id;

  /**
   * @return email_address
   */
  public String getEmail_address() {
    return this.email_address;
  }

  /**
   * @param email_address email_address to set
   * @return PaypalWalletCustomer
   */
  public <T extends PaypalWalletCustomer> T setEmail_address(String email_address) {
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
   * @return PaypalWalletCustomer
   */
  public <T extends PaypalWalletCustomer> T setPhone(PhoneWithType phone) {
    this.phone = phone;
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
   * @return PaypalWalletCustomer
   */
  public <T extends PaypalWalletCustomer> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
