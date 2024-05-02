package com.wizzdi.examples.runtime.api.response;

import com.wizzdi.examples.runtime.api.request.Money;
import com.wizzdi.examples.runtime.api.request.PlatformFee;
import java.util.List;

public class RefundParent2SellerPayableBreakdown {

  private Money gross_amount;

  private Money paypal_fee;

  private Money paypal_fee_in_receivable_currency;

  private Money net_amount;

  private Money net_amount_in_receivable_currency;

  private List<PlatformFee> platform_fees;

  private List<NetAmountBreakdownItem> net_amount_breakdown;

  private Money total_refunded_amount;

  /**
   * @return gross_amount
   */
  public Money getGross_amount() {
    return this.gross_amount;
  }

  /**
   * @param gross_amount gross_amount to set
   * @return RefundParent2SellerPayableBreakdown
   */
  public <T extends RefundParent2SellerPayableBreakdown> T setGross_amount(Money gross_amount) {
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
   * @return RefundParent2SellerPayableBreakdown
   */
  public <T extends RefundParent2SellerPayableBreakdown> T setPaypal_fee(Money paypal_fee) {
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
   * @return RefundParent2SellerPayableBreakdown
   */
  public <T extends RefundParent2SellerPayableBreakdown> T setPaypal_fee_in_receivable_currency(
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
   * @return RefundParent2SellerPayableBreakdown
   */
  public <T extends RefundParent2SellerPayableBreakdown> T setNet_amount(Money net_amount) {
    this.net_amount = net_amount;
    return (T) this;
  }

  /**
   * @return net_amount_in_receivable_currency
   */
  public Money getNet_amount_in_receivable_currency() {
    return this.net_amount_in_receivable_currency;
  }

  /**
   * @param net_amount_in_receivable_currency net_amount_in_receivable_currency to set
   * @return RefundParent2SellerPayableBreakdown
   */
  public <T extends RefundParent2SellerPayableBreakdown> T setNet_amount_in_receivable_currency(
      Money net_amount_in_receivable_currency) {
    this.net_amount_in_receivable_currency = net_amount_in_receivable_currency;
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
   * @return RefundParent2SellerPayableBreakdown
   */
  public <T extends RefundParent2SellerPayableBreakdown> T setPlatform_fees(
      List<PlatformFee> platform_fees) {
    this.platform_fees = platform_fees;
    return (T) this;
  }

  /**
   * @return net_amount_breakdown
   */
  public List<NetAmountBreakdownItem> getNet_amount_breakdown() {
    return this.net_amount_breakdown;
  }

  /**
   * @param net_amount_breakdown net_amount_breakdown to set
   * @return RefundParent2SellerPayableBreakdown
   */
  public <T extends RefundParent2SellerPayableBreakdown> T setNet_amount_breakdown(
      List<NetAmountBreakdownItem> net_amount_breakdown) {
    this.net_amount_breakdown = net_amount_breakdown;
    return (T) this;
  }

  /**
   * @return total_refunded_amount
   */
  public Money getTotal_refunded_amount() {
    return this.total_refunded_amount;
  }

  /**
   * @param total_refunded_amount total_refunded_amount to set
   * @return RefundParent2SellerPayableBreakdown
   */
  public <T extends RefundParent2SellerPayableBreakdown> T setTotal_refunded_amount(
      Money total_refunded_amount) {
    this.total_refunded_amount = total_refunded_amount;
    return (T) this;
  }
}
