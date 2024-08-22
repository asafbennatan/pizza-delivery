package com.wizzdi.examples.model.paypal.orders.v2.response;

public class Phone2 {

  private String national_number;

  /**
   * @return national_number
   */
  public String getNational_number() {
    return this.national_number;
  }

  /**
   * @param national_number national_number to set
   * @return Phone2
   */
  public <T extends Phone2> T setNational_number(String national_number) {
    this.national_number = national_number;
    return (T) this;
  }
}
