package com.wizzdi.examples.model.paypal.orders.v2.request;

import java.util.List;

public class Level3CardProcessingData {

  private Money shipping_amount;

  private Money duty_amount;

  private Money discount_amount;

  private AddressPortable shipping_address;

  private String ships_from_postal_code;

  private List<LineItem> line_items;

  /**
   * @return shipping_amount
   */
  public Money getShipping_amount() {
    return this.shipping_amount;
  }

  /**
   * @param shipping_amount shipping_amount to set
   * @return Level3CardProcessingData
   */
  public <T extends Level3CardProcessingData> T setShipping_amount(Money shipping_amount) {
    this.shipping_amount = shipping_amount;
    return (T) this;
  }

  /**
   * @return duty_amount
   */
  public Money getDuty_amount() {
    return this.duty_amount;
  }

  /**
   * @param duty_amount duty_amount to set
   * @return Level3CardProcessingData
   */
  public <T extends Level3CardProcessingData> T setDuty_amount(Money duty_amount) {
    this.duty_amount = duty_amount;
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
   * @return Level3CardProcessingData
   */
  public <T extends Level3CardProcessingData> T setDiscount_amount(Money discount_amount) {
    this.discount_amount = discount_amount;
    return (T) this;
  }

  /**
   * @return shipping_address
   */
  public AddressPortable getShipping_address() {
    return this.shipping_address;
  }

  /**
   * @param shipping_address shipping_address to set
   * @return Level3CardProcessingData
   */
  public <T extends Level3CardProcessingData> T setShipping_address(
      AddressPortable shipping_address) {
    this.shipping_address = shipping_address;
    return (T) this;
  }

  /**
   * @return ships_from_postal_code
   */
  public String getShips_from_postal_code() {
    return this.ships_from_postal_code;
  }

  /**
   * @param ships_from_postal_code ships_from_postal_code to set
   * @return Level3CardProcessingData
   */
  public <T extends Level3CardProcessingData> T setShips_from_postal_code(
      String ships_from_postal_code) {
    this.ships_from_postal_code = ships_from_postal_code;
    return (T) this;
  }

  /**
   * @return line_items
   */
  public List<LineItem> getLine_items() {
    return this.line_items;
  }

  /**
   * @param line_items line_items to set
   * @return Level3CardProcessingData
   */
  public <T extends Level3CardProcessingData> T setLine_items(List<LineItem> line_items) {
    this.line_items = line_items;
    return (T) this;
  }
}
