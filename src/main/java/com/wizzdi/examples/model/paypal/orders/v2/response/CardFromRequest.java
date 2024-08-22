package com.wizzdi.examples.model.paypal.orders.v2.response;

public class CardFromRequest {

  private String expiry;

  private String last_digits;

  /**
   * @return expiry
   */
  public String getExpiry() {
    return this.expiry;
  }

  /**
   * @param expiry expiry to set
   * @return CardFromRequest
   */
  public <T extends CardFromRequest> T setExpiry(String expiry) {
    this.expiry = expiry;
    return (T) this;
  }

  /**
   * @return last_digits
   */
  public String getLast_digits() {
    return this.last_digits;
  }

  /**
   * @param last_digits last_digits to set
   * @return CardFromRequest
   */
  public <T extends CardFromRequest> T setLast_digits(String last_digits) {
    this.last_digits = last_digits;
    return (T) this;
  }
}
