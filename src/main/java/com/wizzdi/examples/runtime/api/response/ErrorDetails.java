package com.wizzdi.examples.runtime.api.response;

public class ErrorDetails {

  private String field;

  private String value;

  private String location;

  private String issue;

  private String description;

  /**
   * @return field
   */
  public String getField() {
    return this.field;
  }

  /**
   * @param field field to set
   * @return ErrorDetails
   */
  public <T extends ErrorDetails> T setField(String field) {
    this.field = field;
    return (T) this;
  }

  /**
   * @return value
   */
  public String getValue() {
    return this.value;
  }

  /**
   * @param value value to set
   * @return ErrorDetails
   */
  public <T extends ErrorDetails> T setValue(String value) {
    this.value = value;
    return (T) this;
  }

  /**
   * @return location
   */
  public String getLocation() {
    return this.location;
  }

  /**
   * @param location location to set
   * @return ErrorDetails
   */
  public <T extends ErrorDetails> T setLocation(String location) {
    this.location = location;
    return (T) this;
  }

  /**
   * @return issue
   */
  public String getIssue() {
    return this.issue;
  }

  /**
   * @param issue issue to set
   * @return ErrorDetails
   */
  public <T extends ErrorDetails> T setIssue(String issue) {
    this.issue = issue;
    return (T) this;
  }

  /**
   * @return description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * @param description description to set
   * @return ErrorDetails
   */
  public <T extends ErrorDetails> T setDescription(String description) {
    this.description = description;
    return (T) this;
  }
}
