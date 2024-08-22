package com.wizzdi.examples.model.paypal.orders.v2.response;

public class ErrorLinkDescription {

  private String href;

  private String rel;

  private ErrorLinkDescriptionMethod method;

  /**
   * @return href
   */
  public String getHref() {
    return this.href;
  }

  /**
   * @param href href to set
   * @return ErrorLinkDescription
   */
  public <T extends ErrorLinkDescription> T setHref(String href) {
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
   * @return ErrorLinkDescription
   */
  public <T extends ErrorLinkDescription> T setRel(String rel) {
    this.rel = rel;
    return (T) this;
  }

  /**
   * @return method
   */
  public ErrorLinkDescriptionMethod getMethod() {
    return this.method;
  }

  /**
   * @param method method to set
   * @return ErrorLinkDescription
   */
  public <T extends ErrorLinkDescription> T setMethod(ErrorLinkDescriptionMethod method) {
    this.method = method;
    return (T) this;
  }
}
