package com.wizzdi.examples.model.paypal.orders.v2.request;

public class AddressPortableAddressDetails {

  private String street_number;

  private String street_name;

  private String street_type;

  private String delivery_service;

  private String building_name;

  private String sub_building;

  /**
   * @return street_number
   */
  public String getStreet_number() {
    return this.street_number;
  }

  /**
   * @param street_number street_number to set
   * @return AddressPortableAddressDetails
   */
  public <T extends AddressPortableAddressDetails> T setStreet_number(String street_number) {
    this.street_number = street_number;
    return (T) this;
  }

  /**
   * @return street_name
   */
  public String getStreet_name() {
    return this.street_name;
  }

  /**
   * @param street_name street_name to set
   * @return AddressPortableAddressDetails
   */
  public <T extends AddressPortableAddressDetails> T setStreet_name(String street_name) {
    this.street_name = street_name;
    return (T) this;
  }

  /**
   * @return street_type
   */
  public String getStreet_type() {
    return this.street_type;
  }

  /**
   * @param street_type street_type to set
   * @return AddressPortableAddressDetails
   */
  public <T extends AddressPortableAddressDetails> T setStreet_type(String street_type) {
    this.street_type = street_type;
    return (T) this;
  }

  /**
   * @return delivery_service
   */
  public String getDelivery_service() {
    return this.delivery_service;
  }

  /**
   * @param delivery_service delivery_service to set
   * @return AddressPortableAddressDetails
   */
  public <T extends AddressPortableAddressDetails> T setDelivery_service(String delivery_service) {
    this.delivery_service = delivery_service;
    return (T) this;
  }

  /**
   * @return building_name
   */
  public String getBuilding_name() {
    return this.building_name;
  }

  /**
   * @param building_name building_name to set
   * @return AddressPortableAddressDetails
   */
  public <T extends AddressPortableAddressDetails> T setBuilding_name(String building_name) {
    this.building_name = building_name;
    return (T) this;
  }

  /**
   * @return sub_building
   */
  public String getSub_building() {
    return this.sub_building;
  }

  /**
   * @param sub_building sub_building to set
   * @return AddressPortableAddressDetails
   */
  public <T extends AddressPortableAddressDetails> T setSub_building(String sub_building) {
    this.sub_building = sub_building;
    return (T) this;
  }
}
