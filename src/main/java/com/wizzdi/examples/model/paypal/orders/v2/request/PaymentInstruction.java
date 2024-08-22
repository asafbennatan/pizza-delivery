package com.wizzdi.examples.model.paypal.orders.v2.request;

import java.util.List;

public class PaymentInstruction {

  private List<PlatformFee> platform_fees;

  private DisbursementMode disbursement_mode;

  private String payee_pricing_tier_id;

  private String payee_receivable_fx_rate_id;

  /**
   * @return platform_fees
   */
  public List<PlatformFee> getPlatform_fees() {
    return this.platform_fees;
  }

  /**
   * @param platform_fees platform_fees to set
   * @return PaymentInstruction
   */
  public <T extends PaymentInstruction> T setPlatform_fees(List<PlatformFee> platform_fees) {
    this.platform_fees = platform_fees;
    return (T) this;
  }

  /**
   * @return disbursement_mode
   */
  public DisbursementMode getDisbursement_mode() {
    return this.disbursement_mode;
  }

  /**
   * @param disbursement_mode disbursement_mode to set
   * @return PaymentInstruction
   */
  public <T extends PaymentInstruction> T setDisbursement_mode(DisbursementMode disbursement_mode) {
    this.disbursement_mode = disbursement_mode;
    return (T) this;
  }

  /**
   * @return payee_pricing_tier_id
   */
  public String getPayee_pricing_tier_id() {
    return this.payee_pricing_tier_id;
  }

  /**
   * @param payee_pricing_tier_id payee_pricing_tier_id to set
   * @return PaymentInstruction
   */
  public <T extends PaymentInstruction> T setPayee_pricing_tier_id(String payee_pricing_tier_id) {
    this.payee_pricing_tier_id = payee_pricing_tier_id;
    return (T) this;
  }

  /**
   * @return payee_receivable_fx_rate_id
   */
  public String getPayee_receivable_fx_rate_id() {
    return this.payee_receivable_fx_rate_id;
  }

  /**
   * @param payee_receivable_fx_rate_id payee_receivable_fx_rate_id to set
   * @return PaymentInstruction
   */
  public <T extends PaymentInstruction> T setPayee_receivable_fx_rate_id(
      String payee_receivable_fx_rate_id) {
    this.payee_receivable_fx_rate_id = payee_receivable_fx_rate_id;
    return (T) this;
  }
}
