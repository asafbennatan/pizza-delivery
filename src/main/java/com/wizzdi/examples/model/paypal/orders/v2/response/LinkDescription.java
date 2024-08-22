package com.wizzdi.examples.model.paypal.orders.v2.response;

public class LinkDescription {

  private String href;

  private String rel;

  private LinkDescriptionMethod method;

  /**
   * @return href
   */
  public String getHref() {
    return this.href;
  }

  /**
   * @param href href to set
   * @return LinkDescription
   */
  public <T extends LinkDescription> T setHref(String href) {
    this.href = href;
    return (T) this;
  }

  /**
   * @return rel
   */
  public String getRel() {
    return this.rel;
  }

  /**
   * @param rel rel to set
   * @return LinkDescription
   */
  public <T extends LinkDescription> T setRel(String rel) {
    this.rel = rel;
    return (T) this;
  }

  /**
   * @return method
   */
  public LinkDescriptionMethod getMethod() {
    return this.method;
  }

  /**
   * @param method method to set
   * @return LinkDescription
   */
  public <T extends LinkDescription> T setMethod(LinkDescriptionMethod method) {
    this.method = method;
    return (T) this;
  }
}
