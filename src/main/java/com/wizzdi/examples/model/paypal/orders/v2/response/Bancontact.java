package com.wizzdi.examples.model.paypal.orders.v2.response;

public class Bancontact {

  private String name;

  private String country_code;

  private String bic;

  private String iban_last_chars;

  private String card_last_digits;

  private Object attributes;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return Bancontact
   */
  public <T extends Bancontact> T setName(String name) {
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
   * @return Bancontact
   */
  public <T extends Bancontact> T setCountry_code(String country_code) {
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
   * @return Bancontact
   */
  public <T extends Bancontact> T setBic(String bic) {
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
   * @return Bancontact
   */
  public <T extends Bancontact> T setIban_last_chars(String iban_last_chars) {
    this.iban_last_chars = iban_last_chars;
    return (T) this;
  }

  /**
   * @return card_last_digits
   */
  public String getCard_last_digits() {
    return this.card_last_digits;
  }

  /**
   * @param card_last_digits card_last_digits to set
   * @return Bancontact
   */
  public <T extends Bancontact> T setCard_last_digits(String card_last_digits) {
    this.card_last_digits = card_last_digits;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public Object getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return Bancontact
   */
  public <T extends Bancontact> T setAttributes(Object attributes) {
    this.attributes = attributes;
    return (T) this;
  }
}
