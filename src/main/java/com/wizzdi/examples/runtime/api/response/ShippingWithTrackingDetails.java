package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.AddressPortable;
import com.wizzdi.examples.runtime.api.request.Name;
import com.wizzdi.examples.runtime.api.request.ShippingDetailType;
import com.wizzdi.examples.runtime.api.request.ShippingOption;
import java.util.List;

public class ShippingWithTrackingDetails {

  private List<Tracker> trackers;

  private AddressPortable address;

  private Name name;

  private List<ShippingOption> options;

  private ShippingDetailType type;

  /**
   * @return trackers
   */
  public List<Tracker> getTrackers() {
    return this.trackers;
  }

  /**
   * @param trackers trackers to set
   * @return ShippingWithTrackingDetails
   */
  public <T extends ShippingWithTrackingDetails> T setTrackers(List<Tracker> trackers) {
    this.trackers = trackers;
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
   * @return ShippingWithTrackingDetails
   */
  public <T extends ShippingWithTrackingDetails> T setAddress(AddressPortable address) {
    this.address = address;
    return (T) this;
  }

  /**
   * @return name
   */
  public Name getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return ShippingWithTrackingDetails
   */
  public <T extends ShippingWithTrackingDetails> T setName(Name name) {
    this.name = name;
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
   * @return ShippingWithTrackingDetails
   */
  public <T extends ShippingWithTrackingDetails> T setOptions(List<ShippingOption> options) {
    this.options = options;
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
   * @return ShippingWithTrackingDetails
   */
  public <T extends ShippingWithTrackingDetails> T setType(ShippingDetailType type) {
    this.type = type;
    return (T) this;
  }
}
