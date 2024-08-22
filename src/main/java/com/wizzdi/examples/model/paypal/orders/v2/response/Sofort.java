package com.wizzdi.examples.model.paypal.orders.v2.response;

public class Sofort {

  private String name;

  private String country_code;

  private String bic;

  private String iban_last_chars;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return Sofort
   */
  public <T extends Sofort> T setName(String name) {
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
   * @return Sofort
   */
  public <T extends Sofort> T setCountry_code(String country_code) {
    this.country_code = country_code;
    return (T) this;
  }

  /**
   * @return bic
   */
  public String getBic() {
    return this.bic;
  }

  /**
   * @param bic bic to set
   * @return Sofort
   */
  public <T extends Sofort> T setBic(String bic) {
    this.bic = bic;
    return (T) this;
  }

  /**
   * @return iban_last_chars
   */
  public String getIban_last_chars() {
    return this.iban_last_chars;
  }

  /**
   * @param iban_last_chars iban_last_chars to set
   * @return Sofort
   */
  public <T extends Sofort> T setIban_last_chars(String iban_last_chars) {
    this.iban_last_chars = iban_last_chars;
    return (T) this;
  }
}
