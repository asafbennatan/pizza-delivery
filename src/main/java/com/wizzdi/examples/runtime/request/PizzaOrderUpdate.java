package com.wizzdi.examples.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.validation.IdValid;
import com.wizzdi.examples.runtime.validation.Update;

/** Object Used to Update PizzaOrder */
@IdValid.List({
  @IdValid(
      targetField = "pizzaOrder",
      field = "id",
      fieldType = PizzaOrder.class,
      groups = {Update.class})
})
public class PizzaOrderUpdate extends PizzaOrderCreate {

  private String id;

  @JsonIgnore private PizzaOrder pizzaOrder;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return PizzaOrderUpdate
   */
  public <T extends PizzaOrderUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return pizzaOrder
   */
  @JsonIgnore
  public PizzaOrder getPizzaOrder() {
    return this.pizzaOrder;
  }

  /**
   * @param pizzaOrder pizzaOrder to set
   * @return PizzaOrderUpdate
   */
  public <T extends PizzaOrderUpdate> T setPizzaOrder(PizzaOrder pizzaOrder) {
    this.pizzaOrder = pizzaOrder;
    return (T) this;
  }
}
