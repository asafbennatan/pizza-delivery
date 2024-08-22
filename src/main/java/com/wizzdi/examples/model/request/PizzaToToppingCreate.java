package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.Pizza;
import com.wizzdi.examples.model.model.Topping;
import com.wizzdi.examples.model.validation.Create;
import com.wizzdi.examples.model.validation.IdValid;
import com.wizzdi.examples.model.validation.Update;

/** Object Used to Create PizzaToTopping */
@IdValid.List({
  @IdValid(
      field = "pizzaId",
      fieldType = Pizza.class,
      targetField = "pizza",
      groups = {Create.class, Update.class}),
  @IdValid(
      field = "toppingId",
      fieldType = Topping.class,
      targetField = "topping",
      groups = {Create.class, Update.class})
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
