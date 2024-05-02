package com.wizzdi.examples.runtime.api.request;

public class Name2 {

  private String prefix;

  private String given_name;

  private String surname;

  private String middle_name;

  private String suffix;

  private String full_name;

  /**
   * @return prefix
   */
  public String getPrefix() {
    return this.prefix;
  }

  /**
   * @param prefix prefix to set
   * @return Name2
   */
  public <T extends Name2> T setPrefix(String prefix) {
    this.prefix = prefix;
    return (T) this;
  }

  /**
   * @return given_name
   */
  public String getGiven_name() {
    return this.given_name;
  }

  /**
   * @param given_name given_name to set
   * @return Name2
   */
  public <T extends Name2> T setGiven_name(String given_name) {
    this.given_name = given_name;
    return (T) this;
  }

  /**
   * @return surname
   */
  public String getSurname() {
    return this.surname;
  }

  /**
   * @param surname surname to set
   * @return Name2
   */
  public <T extends Name2> T setSurname(String surname) {
    this.surname = surname;
    return (T) this;
  }

  /**
   * @return middle_name
   */
  public String getMiddle_name() {
    return this.middle_name;
  }

  /**
   * @param middle_name middle_name to set
   * @return Name2
   */
  public <T extends Name2> T setMiddle_name(String middle_name) {
    this.middle_name = middle_name;
    return (T) this;
  }

  /**
   * @return suffix
   */
  public String getSuffix() {
    return this.suffix;
  }

  /**
   * @param suffix suffix to set
   * @return Name2
   */
  public <T extends Name2> T setSuffix(String suffix) {
    this.suffix = suffix;
    return (T) this;
  }

  /**
   * @return full_name
   */
  public String getFull_name() {
    return this.full_name;
  }

  /**
   * @param full_name full_name to set
   * @return Name2
   */
  public <T extends Name2> T setFull_name(String full_name) {
    this.full_name = full_name;
    return (T) this;
  }
}
