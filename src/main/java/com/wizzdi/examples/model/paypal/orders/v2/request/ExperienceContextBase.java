package com.wizzdi.examples.model.paypal.orders.v2.request;

public class ExperienceContextBase {

  private String brand_name;

  private String locale;

  private ExperienceContextBaseShippingPreference shipping_preference;

  private String return_url;

  private String cancel_url;

  /**
   * @return brand_name
   */
  public String getBrand_name() {
    return this.brand_name;
  }

  /**
   * @param brand_name brand_name to set
   * @return ExperienceContextBase
   */
  public <T extends ExperienceContextBase> T setBrand_name(String brand_name) {
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
   * @return ExperienceContextBase
   */
  public <T extends ExperienceContextBase> T setLocale(String locale) {
    this.locale = locale;
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
   * @return ExperienceContextBase
   */
  public <T extends ExperienceContextBase> T setShipping_preference(
      ExperienceContextBaseShippingPreference shipping_preference) {
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
   * @return ExperienceContextBase
   */
  public <T extends ExperienceContextBase> T setReturn_url(String return_url) {
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
   * @return ExperienceContextBase
   */
  public <T extends ExperienceContextBase> T setCancel_url(String cancel_url) {
    this.cancel_url = cancel_url;
    return (T) this;
  }
}
