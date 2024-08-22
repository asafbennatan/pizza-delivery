package com.wizzdi.examples.model.paypal.orders.v2.request;

public class LineItem {

  private String commodity_code;

  private String quantity;

  private Money total_amount;

  private Money discount_amount;

  private String name;

  private String unit_of_measure;

  private String description;

  private Money tax;

  private Money unit_amount;

  private String sku;

  private ItemCategory category;

  /**
   * @return commodity_code
   */
  public String getCommodity_code() {
    return this.commodity_code;
  }

  /**
   * @param commodity_code commodity_code to set
   * @return LineItem
   */
  public <T extends LineItem> T setCommodity_code(String commodity_code) {
    this.commodity_code = commodity_code;
    return (T) this;
  }

  /**
   * @return quantity
   */
  public String getQuantity() {
    return this.quantity;
  }

  /**
   * @param quantity quantity to set
   * @return LineItem
   */
  public <T extends LineItem> T setQuantity(String quantity) {
    this.quantity = quantity;
    return (T) this;
  }

  /**
   * @return total_amount
   */
  public Money getTotal_amount() {
    return this.total_amount;
  }

  /**
   * @param total_amount total_amount to set
   * @return LineItem
   */
  public <T extends LineItem> T setTotal_amount(Money total_amount) {
    this.total_amount = total_amount;
    return (T) this;
  }

  /**
   * @return discount_amount
   */
  public Money getDiscount_amount() {
    return this.discount_amount;
  }

  /**
   * @param discount_amount discount_amount to set
   * @return LineItem
   */
  public <T extends LineItem> T setDiscount_amount(Money discount_amount) {
    this.discount_amount = discount_amount;
    return (T) this;
  }

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return LineItem
   */
  public <T extends LineItem> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return unit_of_measure
   */
  public String getUnit_of_measure() {
    return this.unit_of_measure;
  }

  /**
   * @param unit_of_measure unit_of_measure to set
   * @return LineItem
   */
  public <T extends LineItem> T setUnit_of_measure(String unit_of_measure) {
    this.unit_of_measure = unit_of_measure;
    return (T) this;
  }

  /**
   * @return description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * @param description description to set
   * @return LineItem
   */
  public <T extends LineItem> T setDescription(String description) {
    this.description = description;
    return (T) this;
  }

  /**
   * @return tax
   */
  public Money getTax() {
    return this.tax;
  }

  /**
   * @param tax tax to set
   * @return LineItem
   */
  public <T extends LineItem> T setTax(Money tax) {
    this.tax = tax;
    return (T) this;
  }

  /**
   * @return unit_amount
   */
  public Money getUnit_amount() {
    return this.unit_amount;
  }

  /**
   * @param unit_amount unit_amount to set
   * @return LineItem
   */
  public <T extends LineItem> T setUnit_amount(Money unit_amount) {
    this.unit_amount = unit_amount;
    return (T) this;
  }

  /**
   * @return sku
   */
  public String getSku() {
    return this.sku;
  }

  /**
   * @param sku sku to set
   * @return LineItem
   */
  public <T extends LineItem> T setSku(String sku) {
    this.sku = sku;
    return (T) this;
  }

  /**
   * @return category
   */
  public ItemCategory getCategory() {
    return this.category;
  }

  /**
   * @param category category to set
   * @return LineItem
   */
  public <T extends LineItem> T setCategory(ItemCategory category) {
    this.category = category;
    return (T) this;
  }
}
