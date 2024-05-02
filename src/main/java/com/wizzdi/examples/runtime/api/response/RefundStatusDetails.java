package com.wizzdi.examples.runtime.api.response;

public class RefundStatusDetails {

  private RefundStatusDetailsReason reason;

  /**
   * @return reason
   */
  public RefundStatusDetailsReason getReason() {
    return this.reason;
  }

  /**
   * @param reason reason to set
   * @return RefundStatusDetails
   */
  public <T extends RefundStatusDetails> T setReason(RefundStatusDetailsReason reason) {
    this.reason = reason;
    return (T) this;
  }
}
