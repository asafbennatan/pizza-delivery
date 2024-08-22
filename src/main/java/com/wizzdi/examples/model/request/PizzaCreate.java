package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.validation.Create;
import com.wizzdi.examples.model.validation.IdValid;
import com.wizzdi.examples.model.validation.Update;

/** Object Used to Create Pizza */
@IdValid.List({
  @IdValid(
      field = "pizzaOrderId",
      fieldType = PizzaOrder.class,
      targetField = "pizzaOrder",
      groups = {Update.class, Create.class})
})
public class PizzaCreate extends SecuredBasicCreate {

  @JsonIgnore private PizzaOrder pizzaOrder;

  private String pizzaOrderId;

  /**
   * @return pizzaOrder
   */
  @JsonIgnore
  public PizzaOrder getPizzaOrder() {
    return this.pizzaOrder;
  }

  /**
   * @param pizzaOrder pizzaOrder to set
   * @return PizzaCreate
   */
  public <T extends PizzaCreate> T setPizzaOrder(PizzaOrder pizzaOrder) {
    this.pizzaOrder = pizzaOrder;
    return (T) this;
  }

  /**
   * @return pizzaOrderId
   */
  public String getPizzaOrderId() {
    return this.pizzaOrderId;
  }

  /**
   * @param pizzaOrderId pizzaOrderId to set
   * @return PizzaCreate
   */
  public <T extends PizzaCreate> T setPizzaOrderId(String pizzaOrderId) {
    this.pizzaOrderId = pizzaOrderId;
    return (T) this;
  }
}
