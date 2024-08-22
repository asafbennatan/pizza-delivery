package com.wizzdi.examples.model;

public class PaypalWebhookResponse {

  private boolean success;

  /**
   * @return success
   */
  public boolean isSuccess() {
    return this.success;
  }

  /**
   * @param success success to set
   * @return PaypalWebhookResponse
   */
  public <T extends PaypalWebhookResponse> T setSuccess(boolean success) {
    this.success = success;
    return (T) this;
  }
}
