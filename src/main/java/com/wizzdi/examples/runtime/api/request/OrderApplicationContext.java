package com.wizzdi.examples.runtime.api.request;

public class OrderApplicationContext {

  private String brand_name;

  private String locale;

  private OrderApplicationContextLandingPage landing_page;

  private OrderApplicationContextShippingPreference shipping_preference;

  private OrderApplicationContextUserAction user_action;

  private PaymentMethod payment_method;

  private String return_url;

  private String cancel_url;

  private StoredPaymentSource stored_payment_source;

  /**
   * @return brand_name
   */
  public String getBrand_name() {
    return this.brand_name;
  }

  /**
   * @param brand_name brand_name to set
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setBrand_name(String brand_name) {
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
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setLocale(String locale) {
    this.locale = locale;
    return (T) this;
  }

  /**
   * @return landing_page
   */
  public OrderApplicationContextLandingPage getLanding_page() {
    return this.landing_page;
  }

  /**
   * @param landing_page landing_page to set
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setLanding_page(
      OrderApplicationContextLandingPage landing_page) {
    this.landing_page = landing_page;
    return (T) this;
  }

  /**
   * @return shipping_preference
   */
  public OrderApplicationContextShippingPreference getShipping_preference() {
    return this.shipping_preference;
  }

  /**
   * @param shipping_preference shipping_preference to set
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setShipping_preference(
      OrderApplicationContextShippingPreference shipping_preference) {
    this.shipping_preference = shipping_preference;
    return (T) this;
  }

  /**
   * @return user_action
   */
  public OrderApplicationContextUserAction getUser_action() {
    return this.user_action;
  }

  /**
   * @param user_action user_action to set
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setUser_action(
      OrderApplicationContextUserAction user_action) {
    this.user_action = user_action;
    return (T) this;
  }

  /**
   * @return payment_method
   */
  public PaymentMethod getPayment_method() {
    return this.payment_method;
  }

  /**
   * @param payment_method payment_method to set
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setPayment_method(PaymentMethod payment_method) {
    this.payment_method = payment_method;
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
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setReturn_url(String return_url) {
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
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setCancel_url(String cancel_url) {
    this.cancel_url = cancel_url;
    return (T) this;
  }

  /**
   * @return stored_payment_source
   */
  public StoredPaymentSource getStored_payment_source() {
    return this.stored_payment_source;
  }

  /**
   * @param stored_payment_source stored_payment_source to set
   * @return OrderApplicationContext
   */
  public <T extends OrderApplicationContext> T setStored_payment_source(
      StoredPaymentSource stored_payment_source) {
    this.stored_payment_source = stored_payment_source;
    return (T) this;
  }
}
