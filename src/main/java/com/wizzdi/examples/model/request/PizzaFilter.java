package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.model.PizzaToTopping;
import com.wizzdi.examples.model.validation.IdValid;
import java.util.List;
import java.util.Set;

/** Object Used to List Pizza */
@IdValid.List({
  @IdValid(field = "pizzaOrderIds", fieldType = PizzaOrder.class, targetField = "pizzaOrders"),
  @IdValid(
      field = "pizzaToppingToPizzasIds",
      fieldType = PizzaToTopping.class,
      targetField = "pizzaToppingToPizzases")
})
public class PizzaFilter extends SecuredBasicFilter {

  private Set<String> pizzaOrderIds;

  @JsonIgnore private List<PizzaOrder> pizzaOrders;

  private Set<String> pizzaToppingToPizzasIds;

  @JsonIgnore private List<PizzaToTopping> pizzaToppingToPizzases;

  /**
   * @return pizzaOrderIds
   */
  public Set<String> getPizzaOrderIds() {
    return this.pizzaOrderIds;
  }

  /**
   * @param pizzaOrderIds pizzaOrderIds to set
   * @return PizzaFilter
   */
  public <T extends PizzaFilter> T setPizzaOrderIds(Set<String> pizzaOrderIds) {
    this.pizzaOrderIds = pizzaOrderIds;
    return (T) this;
  }

  /**
   * @return pizzaOrders
   */
  @JsonIgnore
  public List<PizzaOrder> getPizzaOrders() {
    return this.pizzaOrders;
  }

  /**
   * @param pizzaOrders pizzaOrders to set
   * @return PizzaFilter
   */
  public <T extends PizzaFilter> T setPizzaOrders(List<PizzaOrder> pizzaOrders) {
    this.pizzaOrders = pizzaOrders;
    return (T) this;
  }

  /**
   * @return pizzaToppingToPizzasIds
   */
  public Set<String> getPizzaToppingToPizzasIds() {
    return this.pizzaToppingToPizzasIds;
  }

  /**
   * @param pizzaToppingToPizzasIds pizzaToppingToPizzasIds to set
   * @return PizzaFilter
   */
  public <T extends PizzaFilter> T setPizzaToppingToPizzasIds(Set<String> pizzaToppingToPizzasIds) {
    this.pizzaToppingToPizzasIds = pizzaToppingToPizzasIds;
    return (T) this;
  }

  /**
   * @return pizzaToppingToPizzases
   */
  @JsonIgnore
  public List<PizzaToTopping> getPizzaToppingToPizzases() {
    return this.pizzaToppingToPizzases;
  }

  /**
   * @param pizzaToppingToPizzases pizzaToppingToPizzases to set
   * @return PizzaFilter
   */
  public <T extends PizzaFilter> T setPizzaToppingToPizzases(
      List<PizzaToTopping> pizzaToppingToPizzases) {
    this.pizzaToppingToPizzases = pizzaToppingToPizzases;
    return (T) this;
  }
}
