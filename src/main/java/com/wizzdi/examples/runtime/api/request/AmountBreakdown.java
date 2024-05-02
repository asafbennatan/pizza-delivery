package com.wizzdi.examples.runtime.api.request;

public class AmountBreakdown {

  private Money item_total;

  private Money shipping;

  private Money handling;

  private Money tax_total;

  private Money insurance;

  private Money shipping_discount;

  private Money discount;

  /**
   * @return item_total
   */
  public Money getItem_total() {
    return this.item_total;
  }

  /**
   * @param item_total item_total to set
   * @return AmountBreakdown
   */
  public <T extends AmountBreakdown> T setItem_total(Money item_total) {
    this.item_total = item_total;
    return (T) this;
  }

  /**
   * @return shipping
   */
  public Money getShipping() {
    return this.shipping;
  }

  /**
   * @param shipping shipping to set
   * @return AmountBreakdown
   */
  public <T extends AmountBreakdown> T setShipping(Money shipping) {
    this.shipping = shipping;
    return (T) this;
  }

  /**
   * @return handling
   */
  public Money getHandling() {
    return this.handling;
  }

  /**
   * @param handling handling to set
   * @return AmountBreakdown
   */
  public <T extends AmountBreakdown> T setHandling(Money handling) {
    this.handling = handling;
    return (T) this;
  }

  /**
   * @return tax_total
   */
  public Money getTax_total() {
    return this.tax_total;
  }

  /**
   * @param tax_total tax_total to set
   * @return AmountBreakdown
   */
  public <T extends AmountBreakdown> T setTax_total(Money tax_total) {
    this.tax_total = tax_total;
    return (T) this;
  }

  /**
   * @return insurance
   */
  public Money getInsurance() {
    return this.insurance;
  }

  /**
   * @param insurance insurance to set
   * @return AmountBreakdown
   */
  public <T extends AmountBreakdown> T setInsurance(Money insurance) {
    this.insurance = insurance;
    return (T) this;
  }

  /**
   * @return shipping_discount
   */
  public Money getShipping_discount() {
    return this.shipping_discount;
  }

  /**
   * @param shipping_discount shipping_discount to set
   * @return AmountBreakdown
   */
  public <T extends AmountBreakdown> T setShipping_discount(Money shipping_discount) {
    this.shipping_discount = shipping_discount;
    return (T) this;
  }

  /**
   * @return discount
   */
  public Money getDiscount() {
    return this.discount;
  }

  /**
   * @param discount discount to set
   * @return AmountBreakdown
   */
  public <T extends AmountBreakdown> T setDiscount(Money discount) {
    this.discount = discount;
    return (T) this;
  }
}
