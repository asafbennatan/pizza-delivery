package com.wizzdi.examples.runtime.api.response;

public class BlikOneClickResponse {

  private String consumer_reference;

  /**
   * @return consumer_reference
   */
  public String getConsumer_reference() {
    return this.consumer_reference;
  }

  /**
   * @param consumer_reference consumer_reference to set
   * @return BlikOneClickResponse
   */
  public <T extends BlikOneClickResponse> T setConsumer_reference(String consumer_reference) {
    this.consumer_reference = consumer_reference;
    return (T) this;
  }
}
