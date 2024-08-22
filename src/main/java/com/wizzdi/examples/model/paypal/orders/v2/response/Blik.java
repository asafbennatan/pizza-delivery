package com.wizzdi.examples.model.paypal.orders.v2.response;

public class Blik {

  private String name;

  private String country_code;

  private String email;

  private BlikOneClickResponse one_click;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return Blik
   */
  public <T extends Blik> T setName(String name) {
    this.name = name;
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
   * @return Blik
   */
  public <T extends Blik> T setCountry_code(String country_code) {
    this.country_code = country_code;
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
   * @return Blik
   */
  public <T extends Blik> T setEmail(String email) {
    this.email = email;
    return (T) this;
  }

  /**
   * @return one_click
   */
  public BlikOneClickResponse getOne_click() {
    return this.one_click;
  }

  /**
   * @param one_click one_click to set
   * @return Blik
   */
  public <T extends Blik> T setOne_click(BlikOneClickResponse one_click) {
    this.one_click = one_click;
    return (T) this;
  }
}
