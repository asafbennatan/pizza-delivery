package com.wizzdi.examples.runtime.api.request;

public class PayeeBase {

  private String email_address;

  private String merchant_id;

  /**
   * @return email_address
   */
  public String getEmail_address() {
    return this.email_address;
  }

  /**
   * @param email_address email_address to set
   * @return PayeeBase
   */
  public <T extends PayeeBase> T setEmail_address(String email_address) {
    this.email_address = email_address;
    return (T) this;
  }

  /**
   * @return merchant_id
   */
  public String getMerchant_id() {
    return this.merchant_id;
  }

  /**
   * @param merchant_id merchant_id to set
   * @return PayeeBase
   */
  public <T extends PayeeBase> T setMerchant_id(String merchant_id) {
    this.merchant_id = merchant_id;
    return (T) this;
  }
}
