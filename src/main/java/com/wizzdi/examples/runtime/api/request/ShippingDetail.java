package com.wizzdi.examples.runtime.api.request;

import java.util.List;

public class ShippingDetail {

  private Name name;

  private ShippingDetailType type;

  private List<ShippingOption> options;

  private AddressPortable address;

  /**
   * @return name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return ShippingDetail
   */
  public <T extends ShippingDetail> T setName(Name name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return type
   */
  public ShippingDetailType getType() {
    return this.type;
  }

  /**
   * @param type type to set
   * @return ShippingDetail
   */
  public <T extends ShippingDetail> T setType(ShippingDetailType type) {
    this.type = type;
    return (T) this;
  }

  /**
   * @return options
   */
  public List<ShippingOption> getOptions() {
    return this.options;
  }

  /**
   * @param options options to set
   * @return ShippingDetail
   */
  public <T extends ShippingDetail> T setOptions(List<ShippingOption> options) {
    this.options = options;
    return (T) this;
  }

  /**
   * @return address
   */
  public AddressPortable getAddress() {
    return this.address;
  }

  /**
   * @param address address to set
   * @return ShippingDetail
   */
  public <T extends ShippingDetail> T setAddress(AddressPortable address) {
    this.address = address;
    return (T) this;
  }
}
