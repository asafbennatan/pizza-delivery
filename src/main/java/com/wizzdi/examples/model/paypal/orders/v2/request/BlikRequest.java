package com.wizzdi.examples.model.paypal.orders.v2.request;

public class BlikRequest {

  private String name;

  private String country_code;

  private String email;

  private BlikExperienceContext experience_context;

  private BlikSeamless level_0;

  private BlikOneClick one_click;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return BlikRequest
   */
  public <T extends BlikRequest> T setName(String name) {
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
   * @return BlikRequest
   */
  public <T extends BlikRequest> T setCountry_code(String country_code) {
    this.country_code = country_code;
    return (T) this;
  }

  /**
   * @return email
   */
  public String getEmail() {
    return this.email;
  }

  /**
   * @param email email to set
   * @return BlikRequest
   */
  public <T extends BlikRequest> T setEmail(String email) {
    this.email = email;
    return (T) this;
  }

  /**
   * @return experience_context
   */
  public BlikExperienceContext getExperience_context() {
    return this.experience_context;
  }

  /**
   * @param experience_context experience_context to set
   * @return BlikRequest
   */
  public <T extends BlikRequest> T setExperience_context(BlikExperienceContext experience_context) {
    this.experience_context = experience_context;
    return (T) this;
  }

  /**
   * @return level_0
   */
  public BlikSeamless getLevel_0() {
    return this.level_0;
  }

  /**
   * @param level_0 level_0 to set
   * @return BlikRequest
   */
  public <T extends BlikRequest> T setLevel_0(BlikSeamless level_0) {
    this.level_0 = level_0;
    return (T) this;
  }

  /**
   * @return one_click
   */
  public BlikOneClick getOne_click() {
    return this.one_click;
  }

  /**
   * @param one_click one_click to set
   * @return BlikRequest
   */
  public <T extends BlikRequest> T setOne_click(BlikOneClick one_click) {
    this.one_click = one_click;
    return (T) this;
  }
}
