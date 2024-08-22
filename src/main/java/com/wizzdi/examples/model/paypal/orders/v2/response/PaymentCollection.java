package com.wizzdi.examples.model.paypal.orders.v2.response;

import java.util.List;

public class PaymentCollection {

  private List<AuthorizationWithAdditionalData> authorizations;

  private List<Capture> captures;

  private List<Refund> refunds;

  /**
   * @return authorizations
   */
  public List<AuthorizationWithAdditionalData> getAuthorizations() {
    return this.authorizations;
  }

  /**
   * @param authorizations authorizations to set
   * @return PaymentCollection
   */
  public <T extends PaymentCollection> T setAuthorizations(
      List<AuthorizationWithAdditionalData> authorizations) {
    this.authorizations = authorizations;
    return (T) this;
  }

  /**
   * @return captures
   */
  public List<Capture> getCaptures() {
    return this.captures;
  }

  /**
   * @param captures captures to set
   * @return PaymentCollection
   */
  public <T extends PaymentCollection> T setCaptures(List<Capture> captures) {
    this.captures = captures;
    return (T) this;
  }

  /**
   * @return refunds
   */
  public List<Refund> getRefunds() {
    return this.refunds;
  }

  /**
   * @param refunds refunds to set
   * @return PaymentCollection
   */
  public <T extends PaymentCollection> T setRefunds(List<Refund> refunds) {
    this.refunds = refunds;
    return (T) this;
  }
}
