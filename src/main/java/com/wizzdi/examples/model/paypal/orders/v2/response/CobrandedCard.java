package com.wizzdi.examples.model.paypal.orders.v2.response;

import com.wizzdi.examples.model.paypal.orders.v2.request.Money;
import com.wizzdi.examples.model.paypal.orders.v2.request.PayeeBase;
import java.util.List;

public class CobrandedCard {

  private List<String> labels;

  private PayeeBase payee;

  private Money amount;

  /**
   * @return labels
   */
  public List<String> getLabels() {
    return this.labels;
  }

  /**
   * @param labels labels to set
   * @return CobrandedCard
   */
  public <T extends CobrandedCard> T setLabels(List<String> labels) {
    this.labels = labels;
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
   * @return CobrandedCard
   */
  public <T extends CobrandedCard> T setPayee(PayeeBase payee) {
    this.payee = payee;
    return (T) this;
  }

  /**
   * @return amount
   */
  public Money getAmount() {
    return this.amount;
  }

  /**
   * @param amount amount to set
   * @return CobrandedCard
   */
  public <T extends CobrandedCard> T setAmount(Money amount) {
    this.amount = amount;
    return (T) this;
  }
}
