package com.wizzdi.examples.model.paypal.orders.v2.request;

public class PaypalWalletExperienceContext {

  private String brand_name;

  private String locale;

  private PaypalWalletExperienceContextShippingPreference shipping_preference;

  private String return_url;

  private String cancel_url;

  private PaypalWalletExperienceContextLandingPage landing_page;

  private PaypalWalletExperienceContextUserAction user_action;

  private PaypalWalletExperienceContextPaymentMethodPreference payment_method_preference;

  /**
   * @return brand_name
   */
  public String getBrand_name() {
    return this.brand_name;
  }

  /**
   * @param brand_name brand_name to set
   * @return PaypalWalletExperienceContext
   */
  public <T extends PaypalWalletExperienceContext> T setBrand_name(String brand_name) {
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
   * @return PaypalWalletExperienceContext
   */
  public <T extends PaypalWalletExperienceContext> T setLocale(String locale) {
    this.locale = locale;
    return (T) this;
  }

  /**
   * @return shipping_preference
   */
  public PaypalWalletExperienceContextShippingPreference getShipping_preference() {
    return this.shipping_preference;
  }

  /**
   * @param shipping_preference shipping_preference to set
   * @return PaypalWalletExperienceContext
   */
  public <T extends PaypalWalletExperienceContext> T setShipping_preference(
      PaypalWalletExperienceContextShippingPreference shipping_preference) {
    this.shipping_preference = shipping_preference;
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
   * @return PaypalWalletExperienceContext
   */
  public <T extends PaypalWalletExperienceContext> T setReturn_url(String return_url) {
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
   * @return PaypalWalletExperienceContext
   */
  public <T extends PaypalWalletExperienceContext> T setCancel_url(String cancel_url) {
    this.cancel_url = cancel_url;
    return (T) this;
  }

  /**
   * @return landing_page
   */
  public PaypalWalletExperienceContextLandingPage getLanding_page() {
    return this.landing_page;
  }

  /**
   * @param landing_page landing_page to set
   * @return PaypalWalletExperienceContext
   */
  public <T extends PaypalWalletExperienceContext> T setLanding_page(
      PaypalWalletExperienceContextLandingPage landing_page) {
    this.landing_page = landing_page;
    return (T) this;
  }

  /**
   * @return user_action
   */
  public PaypalWalletExperienceContextUserAction getUser_action() {
    return this.user_action;
  }

  /**
   * @param user_action user_action to set
   * @return PaypalWalletExperienceContext
   */
  public <T extends PaypalWalletExperienceContext> T setUser_action(
      PaypalWalletExperienceContextUserAction user_action) {
    this.user_action = user_action;
    return (T) this;
  }

  /**
   * @return payment_method_preference
   */
  public PaypalWalletExperienceContextPaymentMethodPreference getPayment_method_preference() {
    return this.payment_method_preference;
  }

  /**
   * @param payment_method_preference payment_method_preference to set
   * @return PaypalWalletExperienceContext
   */
  public <T extends PaypalWalletExperienceContext> T setPayment_method_preference(
      PaypalWalletExperienceContextPaymentMethodPreference payment_method_preference) {
    this.payment_method_preference = payment_method_preference;
    return (T) this;
  }
}
