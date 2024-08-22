package com.wizzdi.examples.model.paypal.orders.v2.request;

public class VenmoWalletExperienceContext {

  private String brand_name;

  private VenmoWalletExperienceContextShippingPreference shipping_preference;

  /**
   * @return brand_name
   */
  public String getBrand_name() {
    return this.brand_name;
  }

  /**
   * @param brand_name brand_name to set
   * @return VenmoWalletExperienceContext
   */
  public <T extends VenmoWalletExperienceContext> T setBrand_name(String brand_name) {
    this.brand_name = brand_name;
    return (T) this;
  }

  /**
   * @return shipping_preference
   */
  public VenmoWalletExperienceContextShippingPreference getShipping_preference() {
    return this.shipping_preference;
  }

  /**
   * @param shipping_preference shipping_preference to set
   * @return VenmoWalletExperienceContext
   */
  public <T extends VenmoWalletExperienceContext> T setShipping_preference(
      VenmoWalletExperienceContextShippingPreference shipping_preference) {
    this.shipping_preference = shipping_preference;
    return (T) this;
  }
}
