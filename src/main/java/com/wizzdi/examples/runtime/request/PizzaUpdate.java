package com.wizzdi.examples.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.validation.IdValid;
import com.wizzdi.examples.runtime.validation.Update;

/** Object Used to Update Pizza */
@IdValid.List({
  @IdValid(
      targetField = "pizza",
      field = "id",
      fieldType = Pizza.class,
      groups = {Update.class})
})
public class PizzaUpdate extends PizzaCreate {

  private String id;

  @JsonIgnore private Pizza pizza;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return PizzaUpdate
   */
  public <T extends PizzaUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return pizza
   */
  @JsonIgnore
  public Pizza getPizza() {
    return this.pizza;
  }

  /**
   * @param pizza pizza to set
   * @return PizzaUpdate
   */
  public <T extends PizzaUpdate> T setPizza(Pizza pizza) {
    this.pizza = pizza;
    return (T) this;
  }
}
