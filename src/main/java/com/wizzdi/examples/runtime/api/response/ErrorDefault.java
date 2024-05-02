package com.wizzdi.examples.runtime.api.response;

import java.util.List;

public class ErrorDefault {

  private String debug_id;

  private Error400Name name;

  private List<ErrorLinkDescription> links;

  private List<ErrorDetails> details;

  private Error400Message message;

  /**
   * @return debug_id
   */
  public String getDebug_id() {
    return this.debug_id;
  }

  /**
   * @param debug_id debug_id to set
   * @return ErrorDefault
   */
  public <T extends ErrorDefault> T setDebug_id(String debug_id) {
    this.debug_id = debug_id;
    return (T) this;
  }

  /**
   * @return name
   */
  public Error400Name getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return ErrorDefault
   */
  public <T extends ErrorDefault> T setName(Error400Name name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return links
   */
  public List<ErrorLinkDescription> getLinks() {
    return this.links;
  }

  /**
   * @param links links to set
   * @return ErrorDefault
   */
  public <T extends ErrorDefault> T setLinks(List<ErrorLinkDescription> links) {
    this.links = links;
    return (T) this;
  }

  /**
   * @return details
   */
  public List<ErrorDetails> getDetails() {
    return this.details;
  }

  /**
   * @param details details to set
   * @return ErrorDefault
   */
  public <T extends ErrorDefault> T setDetails(List<ErrorDetails> details) {
    this.details = details;
    return (T) this;
  }

  /**
   * @return message
   */
  public Error400Message getMessage() {
    return this.message;
  }

  /**
   * @param message message to set
   * @return ErrorDefault
   */
  public <T extends ErrorDefault> T setMessage(Error400Message message) {
    this.message = message;
    return (T) this;
  }
}
