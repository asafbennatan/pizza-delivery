package com.wizzdi.examples.model.paypal.orders.v2.request;

public class Phone {

  private String country_code;

  private String national_number;

  private String extension_number;

  /**
   * @return country_code
   */
  public String getCountry_code() {
    return this.country_code;
  }

  /**
   * @param country_code country_code to set
   * @return Phone
   */
  public <T extends Phone> T setCountry_code(String country_code) {
    this.country_code = country_code;
    return (T) this;
  }

  /**
   * @return national_number
   */
  public String getNational_number() {
    return this.national_number;
  }

  /**
   * @param national_number national_number to set
   * @return Phone
   */
  public <T extends Phone> T setNational_number(String national_number) {
    this.national_number = national_number;
    return (T) this;
  }

  /**
   * @return extension_number
   */
  public String getExtension_number() {
    return this.extension_number;
  }

  /**
   * @param extension_number extension_number to set
   * @return Phone
   */
  public <T extends Phone> T setExtension_number(String extension_number) {
    this.extension_number = extension_number;
    return (T) this;
  }
}
