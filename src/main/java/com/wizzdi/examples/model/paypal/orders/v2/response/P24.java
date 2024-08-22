package com.wizzdi.examples.model.paypal.orders.v2.response;

public class P24 {

  private String name;

  private String email;

  private String country_code;

  private String payment_descriptor;

  private String method_id;

  private String method_description;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return P24
   */
  public <T extends P24> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * @param email email to set
   * @return P24
   */
  public <T extends P24> T setEmail(String email) {
    this.email = email;
    return (T) this;
  }

  /**
   * @return country_code
   */
  public String getCountry_code() {
    return this.country_code;
  }

  /**
   * @param country_code country_code to set
   * @return P24
   */
  public <T extends P24> T setCountry_code(String country_code) {
    this.country_code = country_code;
    return (T) this;
  }

  /**
   * @return payment_descriptor
   */
  public String getPayment_descriptor() {
    return this.payment_descriptor;
  }

  /**
   * @param payment_descriptor payment_descriptor to set
   * @return P24
   */
  public <T extends P24> T setPayment_descriptor(String payment_descriptor) {
    this.payment_descriptor = payment_descriptor;
    return (T) this;
  }

  /**
   * @return method_id
   */
  public String getMethod_id() {
    return this.method_id;
  }

  /**
   * @param method_id method_id to set
   * @return P24
   */
  public <T extends P24> T setMethod_id(String method_id) {
    this.method_id = method_id;
    return (T) this;
  }

  /**
   * @return method_description
   */
  public String getMethod_description() {
    return this.method_description;
  }

  /**
   * @param method_description method_description to set
   * @return P24
   */
  public <T extends P24> T setMethod_description(String method_description) {
    this.method_description = method_description;
    return (T) this;
  }
}
