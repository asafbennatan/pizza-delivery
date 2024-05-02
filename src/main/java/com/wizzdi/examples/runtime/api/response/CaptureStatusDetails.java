package com.wizzdi.examples.runtime.api.response;

public class CaptureStatusDetails {

  private CaptureStatusDetailsReason reason;

  /**
   * @return reason
   */
  public CaptureStatusDetailsReason getReason() {
    return this.reason;
  }

  /**
   * @param reason reason to set
   * @return CaptureStatusDetails
   */
  public <T extends CaptureStatusDetails> T setReason(CaptureStatusDetailsReason reason) {
    this.reason = reason;
    return (T) this;
  }
}
