package com.wizzdi.examples.model.paypal.orders.v2.response;

public class AuthorizationStatusDetails {

  private AuthorizationStatusDetailsReason reason;

  /**
   * @return reason
   */
  public AuthorizationStatusDetailsReason getReason() {
    return this.reason;
  }

  /**
   * @param reason reason to set
   * @return AuthorizationStatusDetails
   */
  public <T extends AuthorizationStatusDetails> T setReason(
      AuthorizationStatusDetailsReason reason) {
    this.reason = reason;
    return (T) this;
  }
}
