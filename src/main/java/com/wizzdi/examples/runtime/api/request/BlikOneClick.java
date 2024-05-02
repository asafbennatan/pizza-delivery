package com.wizzdi.examples.runtime.api.request;

public class BlikOneClick {

  private String auth_code;

  private String consumer_reference;

  private String alias_label;

  private String alias_key;

  /**
   * @return auth_code
   */
  public String getAuth_code() {
    return this.auth_code;
  }

  /**
   * @param auth_code auth_code to set
   * @return BlikOneClick
   */
  public <T extends BlikOneClick> T setAuth_code(String auth_code) {
    this.auth_code = auth_code;
    return (T) this;
  }

  /**
   * @return consumer_reference
   */
  public String getConsumer_reference() {
    return this.consumer_reference;
  }

  /**
   * @param consumer_reference consumer_reference to set
   * @return BlikOneClick
   */
  public <T extends BlikOneClick> T setConsumer_reference(String consumer_reference) {
    this.consumer_reference = consumer_reference;
    return (T) this;
  }

  /**
   * @return alias_label
   */
  public String getAlias_label() {
    return this.alias_label;
  }

  /**
   * @param alias_label alias_label to set
   * @return BlikOneClick
   */
  public <T extends BlikOneClick> T setAlias_label(String alias_label) {
    this.alias_label = alias_label;
    return (T) this;
  }

  /**
   * @return alias_key
   */
  public String getAlias_key() {
    return this.alias_key;
  }

  /**
   * @param alias_key alias_key to set
   * @return BlikOneClick
   */
  public <T extends BlikOneClick> T setAlias_key(String alias_key) {
    this.alias_key = alias_key;
    return (T) this;
  }
}
