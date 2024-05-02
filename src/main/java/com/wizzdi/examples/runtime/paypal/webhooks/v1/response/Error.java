package com.wizzdi.examples.runtime.paypal.webhooks.v1.response;

import java.util.List;

public class Error {

  private String name;

  private String message;

  private String debug_id;

  private String information_link;

  private List<ErrorDetails> details;

  private List<LinkDescription> links;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return Error
   */
  public <T extends Error> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return message
   */
  public String getMessage() {
    return this.message;
  }

  /**
   * @param message message to set
   * @return Error
   */
  public <T extends Error> T setMessage(String message) {
    this.message = message;
    return (T) this;
  }

  /**
   * @return debug_id
   */
  public String getDebug_id() {
    return this.debug_id;
  }

  /**
   * @param debug_id debug_id to set
   * @return Error
   */
  public <T extends Error> T setDebug_id(String debug_id) {
    this.debug_id = debug_id;
    return (T) this;
  }

  /**
   * @return information_link
   */
  public String getInformation_link() {
    return this.information_link;
  }

  /**
   * @param information_link information_link to set
   * @return Error
   */
  public <T extends Error> T setInformation_link(String information_link) {
    this.information_link = information_link;
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
   * @return Error
   */
  public <T extends Error> T setDetails(List<ErrorDetails> details) {
    this.details = details;
    return (T) this;
  }

  /**
   * @return links
   */
  public List<LinkDescription> getLinks() {
    return this.links;
  }

  /**
   * @param links links to set
   * @return Error
   */
  public <T extends Error> T setLinks(List<LinkDescription> links) {
    this.links = links;
    return (T) this;
  }
}
