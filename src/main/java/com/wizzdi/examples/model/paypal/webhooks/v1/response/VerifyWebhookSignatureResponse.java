package com.wizzdi.examples.model.paypal.webhooks.v1.response;

public class VerifyWebhookSignatureResponse {

  private VerifyWebhookSignatureResponseVerificationStatus verification_status;

  /**
   * @return verification_status
   */
  public VerifyWebhookSignatureResponseVerificationStatus getVerification_status() {
    return this.verification_status;
  }

  /**
   * @param verification_status verification_status to set
   * @return VerifyWebhookSignatureResponse
   */
  public <T extends VerifyWebhookSignatureResponse> T setVerification_status(
      VerifyWebhookSignatureResponseVerificationStatus verification_status) {
    this.verification_status = verification_status;
    return (T) this;
  }
}
