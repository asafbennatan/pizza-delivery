package com.wizzdi.examples.model.paypal.orders.v2.request;

public class BancontactRequest {

  private String name;

  private String country_code;

  private ExperienceContextBase experience_context;

  private Object attributes;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return BancontactRequest
   */
  public <T extends BancontactRequest> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return country_code
   */
  public String getCountry_code() {
    return this.country_code;
  }

  /**
   * @param country_code country_code to set
   * @return BancontactRequest
   */
  public <T extends BancontactRequest> T setCountry_code(String country_code) {
    this.country_code = country_code;
    return (T) this;
  }

  /**
   * @return experience_context
   */
  public ExperienceContextBase getExperience_context() {
    return this.experience_context;
  }

  /**
   * @param experience_context experience_context to set
   * @return BancontactRequest
   */
  public <T extends BancontactRequest> T setExperience_context(
      ExperienceContextBase experience_context) {
    this.experience_context = experience_context;
    return (T) this;
  }

  /**
   * @return attributes
   */
  public Object getAttributes() {
    return this.attributes;
  }

  /**
   * @param attributes attributes to set
   * @return BancontactRequest
   */
  public <T extends BancontactRequest> T setAttributes(Object attributes) {
    this.attributes = attributes;
    return (T) this;
  }
}
