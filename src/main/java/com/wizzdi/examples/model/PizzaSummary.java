package com.wizzdi.examples.model;

import com.wizzdi.examples.model.model.Pizza;
import java.util.List;

public class PizzaSummary {

  private double base;

  private Pizza pizza;

  private List<ToppingSummary> toppings;

  private double total;

  /**
   * @return base
   */
  public double getBase() {
    return this.base;
  }

  /**
   * @param base base to set
   * @return PizzaSummary
   */
  public <T extends PizzaSummary> T setBase(double base) {
    this.base = base;
    return (T) this;
  }

  /**
   * @return pizza
   */
  public Pizza getPizza() {
    return this.pizza;
  }

  /**
   * @param pizza pizza to set
   * @return PizzaSummary
   */
  public <T extends PizzaSummary> T setPizza(Pizza pizza) {
    this.pizza = pizza;
    return (T) this;
  }

  /**
   * @return toppings
   */
  public List<ToppingSummary> getToppings() {
    return this.toppings;
  }

  /**
   * @param toppings toppings to set
   * @return PizzaSummary
   */
  public <T extends PizzaSummary> T setToppings(List<ToppingSummary> toppings) {
    this.toppings = toppings;
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
   * @return PizzaSummary
   */
  public <T extends PizzaSummary> T setTotal(double total) {
    this.total = total;
    return (T) this;
  }
}
