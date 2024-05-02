package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.Money;

public class NetAmountBreakdownItem {

  private Money payable_amount;

  private Money converted_amount;

  private ExchangeRate exchange_rate;

  /**
   * @return payable_amount
   */
  public Money getPayable_amount() {
    return this.payable_amount;
  }

  /**
   * @param payable_amount payable_amount to set
   * @return NetAmountBreakdownItem
   */
  public <T extends NetAmountBreakdownItem> T setPayable_amount(Money payable_amount) {
    this.payable_amount = payable_amount;
    return (T) this;
  }

  /**
   * @return converted_amount
   */
  public Money getConverted_amount() {
    return this.converted_amount;
  }

  /**
   * @param converted_amount converted_amount to set
   * @return NetAmountBreakdownItem
   */
  public <T extends NetAmountBreakdownItem> T setConverted_amount(Money converted_amount) {
    this.converted_amount = converted_amount;
    return (T) this;
  }

  /**
   * @return exchange_rate
   */
  public ExchangeRate getExchange_rate() {
    return this.exchange_rate;
  }

  /**
   * @param exchange_rate exchange_rate to set
   * @return NetAmountBreakdownItem
   */
  public <T extends NetAmountBreakdownItem> T setExchange_rate(ExchangeRate exchange_rate) {
    this.exchange_rate = exchange_rate;
    return (T) this;
  }
}
