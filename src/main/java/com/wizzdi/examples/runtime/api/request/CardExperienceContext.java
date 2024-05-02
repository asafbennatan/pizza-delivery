package com.wizzdi.examples.runtime.api.request;

public class CardExperienceContext {

  private String return_url;

  private String cancel_url;

  /**
   * @return return_url
   */
  public String getReturn_url() {
    return this.return_url;
  }

  /**
   * @param return_url return_url to set
   * @return CardExperienceContext
   */
  public <T extends CardExperienceContext> T setReturn_url(String return_url) {
    this.return_url = return_url;
    return (T) this;
  }

  /**
   * @return cancel_url
   */
  public String getCancel_url() {
    return this.cancel_url;
  }

  /**
   * @param cancel_url cancel_url to set
   * @return CardExperienceContext
   */
  public <T extends CardExperienceContext> T setCancel_url(String cancel_url) {
    this.cancel_url = cancel_url;
    return (T) this;
  }
}
