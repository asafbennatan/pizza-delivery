package com.wizzdi.examples.model.paypal.orders.v2.request;

public class BlikExperienceContext {

  private String consumer_user_agent;

  private String consumer_ip;

  private String return_url;

  private String brand_name;

  private String locale;

  private String cancel_url;

  private ExperienceContextBaseShippingPreference shipping_preference;

  /**
   * @return consumer_user_agent
   */
  public String getConsumer_user_agent() {
    return this.consumer_user_agent;
  }

  /**
   * @param consumer_user_agent consumer_user_agent to set
   * @return BlikExperienceContext
   */
  public <T extends BlikExperienceContext> T setConsumer_user_agent(String consumer_user_agent) {
    this.consumer_user_agent = consumer_user_agent;
    return (T) this;
  }

  /**
   * @return consumer_ip
   */
  public String getConsumer_ip() {
    return this.consumer_ip;
  }

  /**
   * @param consumer_ip consumer_ip to set
   * @return BlikExperienceContext
   */
  public <T extends BlikExperienceContext> T setConsumer_ip(String consumer_ip) {
    this.consumer_ip = consumer_ip;
    return (T) this;
  }

  /**
   * @return return_url
   */
  public String getReturn_url() {
    return this.return_url;
  }

  /**
   * @param return_url return_url to set
   * @return BlikExperienceContext
   */
  public <T extends BlikExperienceContext> T setReturn_url(String return_url) {
    this.return_url = return_url;
    return (T) this;
  }

  /**
   * @return brand_name
   */
  public String getBrand_name() {
    return this.brand_name;
  }

  /**
   * @param brand_name brand_name to set
   * @return BlikExperienceContext
   */
  public <T extends BlikExperienceContext> T setBrand_name(String brand_name) {
    this.brand_name = brand_name;
    return (T) this;
  }

  /**
   * @return locale
   */
  public String getLocale() {
    return this.locale;
  }

  /**
   * @param locale locale to set
   * @return BlikExperienceContext
   */
  public <T extends BlikExperienceContext> T setLocale(String locale) {
    this.locale = locale;
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
   * @return BlikExperienceContext
   */
  public <T extends BlikExperienceContext> T setCancel_url(String cancel_url) {
    this.cancel_url = cancel_url;
    return (T) this;
  }

  /**
   * @return shipping_preference
   */
  public ExperienceContextBaseShippingPreference getShipping_preference() {
    return this.shipping_preference;
  }

  /**
   * @param shipping_preference shipping_preference to set
   * @return BlikExperienceContext
   */
  public <T extends BlikExperienceContext> T setShipping_preference(
      ExperienceContextBaseShippingPreference shipping_preference) {
    this.shipping_preference = shipping_preference;
    return (T) this;
  }
}
