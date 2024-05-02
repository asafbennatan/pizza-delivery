package com.wizzdi.examples.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.model.Topping;
import com.wizzdi.examples.runtime.validation.Create;
import com.wizzdi.examples.runtime.validation.IdValid;
import com.wizzdi.examples.runtime.validation.Update;

/** Object Used to Create PizzaToTopping */
@IdValid.List({
  @IdValid(
      targetField = "pizza",
      field = "pizzaId",
      fieldType = Pizza.class,
      groups = {Update.class, Create.class}),
  @IdValid(
      targetField = "topping",
      field = "toppingId",
      fieldType = Topping.class,
      groups = {Update.class, Create.class})
})
public class PizzaToToppingCreate {

  @JsonIgnore private Pizza pizza;

  private Double pizzaCoverage;

  private String pizzaId;

  @JsonIgnore private Topping topping;

  private String toppingId;

  /**
   * @return pizza
   */
  @JsonIgnore
  public Pizza getPizza() {
    return this.pizza;
  }

  /**
   * @param pizza pizza to set
   * @return PizzaToToppingCreate
   */
  public <T extends PizzaToToppingCreate> T setPizza(Pizza pizza) {
    this.pizza = pizza;
    return (T) this;
  }

  /**
   * @return pizzaCoverage
   */
  public Double getPizzaCoverage() {
    return this.pizzaCoverage;
  }

  /**
   * @param pizzaCoverage pizzaCoverage to set
   * @return PizzaToToppingCreate
   */
  public <T extends PizzaToToppingCreate> T setPizzaCoverage(Double pizzaCoverage) {
    this.pizzaCoverage = pizzaCoverage;
    return (T) this;
  }

  /**
   * @return pizzaId
   */
  public String getPizzaId() {
    return this.pizzaId;
  }

  /**
   * @param pizzaId pizzaId to set
   * @return PizzaToToppingCreate
   */
  public <T extends PizzaToToppingCreate> T setPizzaId(String pizzaId) {
    this.pizzaId = pizzaId;
    return (T) this;
  }

  /**
   * @return topping
   */
  @JsonIgnore
  public Topping getTopping() {
    return this.topping;
  }

  /**
   * @param topping topping to set
   * @return PizzaToToppingCreate
   */
  public <T extends PizzaToToppingCreate> T setTopping(Topping topping) {
    this.topping = topping;
    return (T) this;
  }

  /**
   * @return toppingId
   */
  public String getToppingId() {
    return this.toppingId;
  }

  /**
   * @param toppingId toppingId to set
   * @return PizzaToToppingCreate
   */
  public <T extends PizzaToToppingCreate> T setToppingId(String toppingId) {
    this.toppingId = toppingId;
    return (T) this;
  }
}
