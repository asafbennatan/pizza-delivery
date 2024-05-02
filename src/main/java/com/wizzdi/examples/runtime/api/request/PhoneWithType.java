package com.wizzdi.examples.runtime.api.request;

public class PhoneWithType {

  private PhoneType phone_type;

  private Phone phone_number;

  /**
   * @return phone_type
   */
  public PhoneType getPhone_type() {
    return this.phone_type;
  }

  /**
   * @param phone_type phone_type to set
   * @return PhoneWithType
   */
  public <T extends PhoneWithType> T setPhone_type(PhoneType phone_type) {
    this.phone_type = phone_type;
    return (T) this;
  }

  /**
   * @return phone_number
   */
  public Phone getPhone_number() {
    return this.phone_number;
  }

  /**
   * @param phone_number phone_number to set
   * @return PhoneWithType
   */
  public <T extends PhoneWithType> T setPhone_number(Phone phone_number) {
    this.phone_number = phone_number;
    return (T) this;
  }
}
