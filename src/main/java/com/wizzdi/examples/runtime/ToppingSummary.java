package com.wizzdi.examples.runtime;

import com.wizzdi.examples.runtime.model.Topping;

public class ToppingSummary {

  private Topping topping;

  private double total;

  /**
   * @return topping
   */
  public Topping getTopping() {
    return this.topping;
  }

  /**
   * @param topping topping to set
   * @return ToppingSummary
   */
  public <T extends ToppingSummary> T setTopping(Topping topping) {
    this.topping = topping;
    return (T) this;
  }

  /**
   * @return total
   */
  public double getTotal() {
    return this.total;
  }

  /**
   * @param total total to set
   * @return ToppingSummary
   */
  public <T extends ToppingSummary> T setTotal(double total) {
    this.total = total;
    return (T) this;
  }
}
