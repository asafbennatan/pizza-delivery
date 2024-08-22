package com.wizzdi.examples.model.paypal.orders.v2.request;

public class SupplementaryData {

  private CardSupplementaryData card;

  /**
   * @return card
   */
  public CardSupplementaryData getCard() {
    return this.card;
  }

  /**
   * @param card card to set
   * @return SupplementaryData
   */
  public <T extends SupplementaryData> T setCard(CardSupplementaryData card) {
    this.card = card;
    return (T) this;
  }
}
