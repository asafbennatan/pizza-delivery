package com.wizzdi.examples.runtime.api.request;

public class Item {

  private String name;

  private Money unit_amount;

  private Money tax;

  private String quantity;

  private String description;

  private String sku;

  private ItemCategory category;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return Item
   */
  public <T extends Item> T setName(String name) {
    this.name = name;
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
   * @return Item
   */
  public <T extends Item> T setUnit_amount(Money unit_amount) {
    this.unit_amount = unit_amount;
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
   * @return Item
   */
  public <T extends Item> T setTax(Money tax) {
    this.tax = tax;
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
   * @return Item
   */
  public <T extends Item> T setQuantity(String quantity) {
    this.quantity = quantity;
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
   * @return Item
   */
  public <T extends Item> T setDescription(String description) {
    this.description = description;
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
   * @return Item
   */
  public <T extends Item> T setSku(String sku) {
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
   * @return Item
   */
  public <T extends Item> T setCategory(ItemCategory category) {
    this.category = category;
    return (T) this;
  }
}
