package com.wizzdi.examples.model.paypal.webhooks.v1.request;

import java.time.OffsetDateTime;

public class VerifyWebhookSignature {

  private String auth_algo;

  private String cert_url;

  private String transmission_id;

  private String transmission_sig;

  private OffsetDateTime transmission_time;

  private String webhook_id;

  private Event webhook_event;

  /**
   * @return auth_algo
   */
  public String getAuth_algo() {
    return this.auth_algo;
  }

  /**
   * @param auth_algo auth_algo to set
   * @return VerifyWebhookSignature
   */
  public <T extends VerifyWebhookSignature> T setAuth_algo(String auth_algo) {
    this.auth_algo = auth_algo;
    return (T) this;
  }

  /**
   * @return cert_url
   */
  public String getCert_url() {
    return this.cert_url;
  }

  /**
   * @param cert_url cert_url to set
   * @return VerifyWebhookSignature
   */
  public <T extends VerifyWebhookSignature> T setCert_url(String cert_url) {
    this.cert_url = cert_url;
    return (T) this;
  }

  /**
   * @return transmission_id
   */
  public String getTransmission_id() {
    return this.transmission_id;
  }

  /**
   * @param transmission_id transmission_id to set
   * @return VerifyWebhookSignature
   */
  public <T extends VerifyWebhookSignature> T setTransmission_id(String transmission_id) {
    this.transmission_id = transmission_id;
    return (T) this;
  }

  /**
   * @return transmission_sig
   */
  public String getTransmission_sig() {
    return this.transmission_sig;
  }

  /**
   * @param transmission_sig transmission_sig to set
   * @return VerifyWebhookSignature
   */
  public <T extends VerifyWebhookSignature> T setTransmission_sig(String transmission_sig) {
    this.transmission_sig = transmission_sig;
    return (T) this;
  }

  /**
   * @return transmission_time
   */
  public OffsetDateTime getTransmission_time() {
    return this.transmission_time;
  }

  /**
   * @param transmission_time transmission_time to set
   * @return VerifyWebhookSignature
   */
  public <T extends VerifyWebhookSignature> T setTransmission_time(
      OffsetDateTime transmission_time) {
    this.transmission_time = transmission_time;
    return (T) this;
  }

  /**
   * @return webhook_id
   */
  public String getWebhook_id() {
    return this.webhook_id;
  }

  /**
   * @param webhook_id webhook_id to set
   * @return VerifyWebhookSignature
   */
  public <T extends VerifyWebhookSignature> T setWebhook_id(String webhook_id) {
    this.webhook_id = webhook_id;
    return (T) this;
  }

  /**
   * @return webhook_event
   */
  public Event getWebhook_event() {
    return this.webhook_event;
  }

  /**
   * @param webhook_event webhook_event to set
   * @return VerifyWebhookSignature
   */
  public <T extends VerifyWebhookSignature> T setWebhook_event(Event webhook_event) {
    this.webhook_event = webhook_event;
    return (T) this;
  }
}
