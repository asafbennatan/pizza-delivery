package com.wizzdi.examples.model.paypal.orders.v2.response;

import java.util.List;

public class OrdersCreate422Response {

  private String debug_id;

  private Error422Name name;

  private List<ErrorDetails> details;

  private List<ErrorLinkDescription> links;

  private Error422Message message;

  /**
   * @return debug_id
   */
  public String getDebug_id() {
    return this.debug_id;
  }

  /**
   * @param debug_id debug_id to set
   * @return OrdersCreate422Response
   */
  public <T extends OrdersCreate422Response> T setDebug_id(String debug_id) {
    this.debug_id = debug_id;
    return (T) this;
  }

  /**
   * @return name
   */
  public Error422Name getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return OrdersCreate422Response
   */
  public <T extends OrdersCreate422Response> T setName(Error422Name name) {
    this.name = name;
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
   * @return OrdersCreate422Response
   */
  public <T extends OrdersCreate422Response> T setDetails(List<ErrorDetails> details) {
    this.details = details;
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
   * @return OrdersCreate422Response
   */
  public <T extends OrdersCreate422Response> T setLinks(List<ErrorLinkDescription> links) {
    this.links = links;
    return (T) this;
  }

  /**
   * @return message
   */
  public Error422Message getMessage() {
    return this.message;
  }

  /**
   * @param message message to set
   * @return OrdersCreate422Response
   */
  public <T extends OrdersCreate422Response> T setMessage(Error422Message message) {
    this.message = message;
    return (T) this;
  }
}
