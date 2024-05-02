package com.wizzdi.examples.runtime.api.request;

public class ShippingOption {

  private String id;

  private String label;

  private ShippingType type;

  private Money amount;

  private Boolean selected;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return ShippingOption
   */
  public <T extends ShippingOption> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return label
   */
  public String getLabel() {
    return this.label;
  }

  /**
   * @param label label to set
   * @return ShippingOption
   */
  public <T extends ShippingOption> T setLabel(String label) {
    this.label = label;
    return (T) this;
  }

  /**
   * @return type
   */
  public ShippingType getType() {
    return this.type;
  }

  /**
   * @param type type to set
   * @return ShippingOption
   */
  public <T extends ShippingOption> T setType(ShippingType type) {
    this.type = type;
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
   * @return ShippingOption
   */
  public <T extends ShippingOption> T setAmount(Money amount) {
    this.amount = amount;
    return (T) this;
  }

  /**
   * @return selected
   */
  public Boolean getSelected() {
    return this.selected;
  }

  /**
   * @param selected selected to set
   * @return ShippingOption
   */
  public <T extends ShippingOption> T setSelected(Boolean selected) {
    this.selected = selected;
    return (T) this;
  }
}
