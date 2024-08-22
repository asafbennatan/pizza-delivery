package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.PizzaToTopping;
import com.wizzdi.examples.model.validation.IdValid;
import com.wizzdi.examples.model.validation.Update;

/** Object Used to Update PizzaToTopping */
@IdValid.List({
  @IdValid(
      field = "id",
      fieldType = PizzaToTopping.class,
      targetField = "pizzaToTopping",
      groups = {Update.class})
})
public class PizzaToToppingUpdate extends PizzaToToppingCreate {

  private String id;

  @JsonIgnore private PizzaToTopping pizzaToTopping;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return PizzaToToppingUpdate
   */
  public <T extends PizzaToToppingUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return pizzaToTopping
   */
  @JsonIgnore
  public PizzaToTopping getPizzaToTopping() {
    return this.pizzaToTopping;
  }

  /**
   * @param pizzaToTopping pizzaToTopping to set
   * @return PizzaToToppingUpdate
   */
  public <T extends PizzaToToppingUpdate> T setPizzaToTopping(PizzaToTopping pizzaToTopping) {
    this.pizzaToTopping = pizzaToTopping;
    return (T) this;
  }
}
