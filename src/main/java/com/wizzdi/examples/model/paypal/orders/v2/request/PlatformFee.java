package com.wizzdi.examples.model.paypal.orders.v2.request;

public class PlatformFee {

  private Money amount;

  private PayeeBase payee;

  /**
   * @return amount
   */
  public Money getAmount() {
    return this.amount;
  }

  /**
   * @param amount amount to set
   * @return PlatformFee
   */
  public <T extends PlatformFee> T setAmount(Money amount) {
    this.amount = amount;
    return (T) this;
  }

  /**
   * @return payee
   */
  public PayeeBase getPayee() {
    return this.payee;
  }

  /**
   * @param payee payee to set
   * @return PlatformFee
   */
  public <T extends PlatformFee> T setPayee(PayeeBase payee) {
    this.payee = payee;
    return (T) this;
  }
}
