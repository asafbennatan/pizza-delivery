package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.Money;
import com.wizzdi.examples.runtime.api.request.PlatformFee;
import java.util.List;

public class SellerReceivableBreakdown {

  private Money gross_amount;

  private Money paypal_fee;

  private Money paypal_fee_in_receivable_currency;

  private Money net_amount;

  private Money receivable_amount;

  private ExchangeRate exchange_rate;

  private List<PlatformFee> platform_fees;

  /**
   * @return gross_amount
   */
  public Money getGross_amount() {
    return this.gross_amount;
  }

  /**
   * @param gross_amount gross_amount to set
   * @return SellerReceivableBreakdown
   */
  public <T extends SellerReceivableBreakdown> T setGross_amount(Money gross_amount) {
    this.gross_amount = gross_amount;
    return (T) this;
  }

  /**
   * @return paypal_fee
   */
  public Money getPaypal_fee() {
    return this.paypal_fee;
  }

  /**
   * @param paypal_fee paypal_fee to set
   * @return SellerReceivableBreakdown
   */
  public <T extends SellerReceivableBreakdown> T setPaypal_fee(Money paypal_fee) {
    this.paypal_fee = paypal_fee;
    return (T) this;
  }

  /**
   * @return paypal_fee_in_receivable_currency
   */
  public Money getPaypal_fee_in_receivable_currency() {
    return this.paypal_fee_in_receivable_currency;
  }

  /**
   * @param paypal_fee_in_receivable_currency paypal_fee_in_receivable_currency to set
   * @return SellerReceivableBreakdown
   */
  public <T extends SellerReceivableBreakdown> T setPaypal_fee_in_receivable_currency(
      Money paypal_fee_in_receivable_currency) {
    this.paypal_fee_in_receivable_currency = paypal_fee_in_receivable_currency;
    return (T) this;
  }

  /**
   * @return net_amount
   */
  public Money getNet_amount() {
    return this.net_amount;
  }

  /**
   * @param net_amount net_amount to set
   * @return SellerReceivableBreakdown
   */
  public <T extends SellerReceivableBreakdown> T setNet_amount(Money net_amount) {
    this.net_amount = net_amount;
    return (T) this;
  }

  /**
   * @return receivable_amount
   */
  public Money getReceivable_amount() {
    return this.receivable_amount;
  }

  /**
   * @param receivable_amount receivable_amount to set
   * @return SellerReceivableBreakdown
   */
  public <T extends SellerReceivableBreakdown> T setReceivable_amount(Money receivable_amount) {
    this.receivable_amount = receivable_amount;
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
   * @return SellerReceivableBreakdown
   */
  public <T extends SellerReceivableBreakdown> T setExchange_rate(ExchangeRate exchange_rate) {
    this.exchange_rate = exchange_rate;
    return (T) this;
  }

  /**
   * @return platform_fees
   */
  public List<PlatformFee> getPlatform_fees() {
    return this.platform_fees;
  }

  /**
   * @param platform_fees platform_fees to set
   * @return SellerReceivableBreakdown
   */
  public <T extends SellerReceivableBreakdown> T setPlatform_fees(List<PlatformFee> platform_fees) {
    this.platform_fees = platform_fees;
    return (T) this;
  }
}
