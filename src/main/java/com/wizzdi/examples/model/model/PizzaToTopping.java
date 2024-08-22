package com.wizzdi.examples.model.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class PizzaToTopping {

  @Id private String id;

  @ManyToOne(targetEntity = Topping.class)
  private Topping topping;

  @ManyToOne(targetEntity = Pizza.class)
  private Pizza pizza;

  private double pizzaCoverage;

  /**
   * @return id
   */
  @Id
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return PizzaToTopping
   */
  public <T extends PizzaToTopping> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return topping
   */
  @ManyToOne(targetEntity = Topping.class)
  public Topping getTopping() {
    return this.topping;
  }

  /**
   * @param topping topping to set
   * @return PizzaToTopping
   */
  public <T extends PizzaToTopping> T setTopping(Topping topping) {
    this.topping = topping;
    return (T) this;
  }

  /**
   * @return pizza
   */
  @ManyToOne(targetEntity = Pizza.class)
  public Pizza getPizza() {
    return this.pizza;
  }

  /**
   * @param pizza pizza to set
   * @return PizzaToTopping
   */
  public <T extends PizzaToTopping> T setPizza(Pizza pizza) {
    this.pizza = pizza;
    return (T) this;
  }

  /**
   * @return pizzaCoverage
   */
  public double getPizzaCoverage() {
    return this.pizzaCoverage;
  }

  /**
   * @param pizzaCoverage pizzaCoverage to set
   * @return PizzaToTopping
   */
  public <T extends PizzaToTopping> T setPizzaCoverage(double pizzaCoverage) {
    this.pizzaCoverage = pizzaCoverage;
    return (T) this;
  }
}
