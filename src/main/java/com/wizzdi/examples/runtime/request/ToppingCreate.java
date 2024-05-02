package com.wizzdi.examples.runtime.request;

/** Object Used to Create Topping */
public class ToppingCreate extends BasicCreate {

  private Double price;

  /**
   * @return price
   */
  public Double getPrice() {
    return this.price;
  }

  /**
   * @param price price to set
   * @return ToppingCreate
   */
  public <T extends ToppingCreate> T setPrice(Double price) {
    this.price = price;
    return (T) this;
  }
}
