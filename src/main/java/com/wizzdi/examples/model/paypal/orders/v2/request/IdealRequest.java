package com.wizzdi.examples.model.paypal.orders.v2.request;

public class IdealRequest {

  private String name;

  private String country_code;

  private String bic;

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
   * @return IdealRequest
   */
  public <T extends IdealRequest> T setName(String name) {
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
   * @return IdealRequest
   */
  public <T extends IdealRequest> T setCountry_code(String country_code) {
    this.country_code = country_code;
    return (T) this;
  }

  /**
   * @return bic
   */
  public String getBic() {
    return this.bic;
  }

  /**
   * @param bic bic to set
   * @return IdealRequest
   */
  public <T extends IdealRequest> T setBic(String bic) {
    this.bic = bic;
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
   * @return IdealRequest
   */
  public <T extends IdealRequest> T setExperience_context(
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
   * @return IdealRequest
   */
  public <T extends IdealRequest> T setAttributes(Object attributes) {
    this.attributes = attributes;
    return (T) this;
  }
}
