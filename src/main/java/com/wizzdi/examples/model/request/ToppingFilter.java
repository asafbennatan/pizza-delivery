package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.PizzaToTopping;
import com.wizzdi.examples.model.validation.IdValid;
import java.util.List;
import java.util.Set;

/** Object Used to List Topping */
@IdValid.List({
  @IdValid(
      field = "toppingToppingToPizzasIds",
      fieldType = PizzaToTopping.class,
      targetField = "toppingToppingToPizzases")
})
public class ToppingFilter extends BasicFilter {

  private Double priceEnd;

  private Double priceStart;

  private Set<String> toppingToppingToPizzasIds;

  @JsonIgnore private List<PizzaToTopping> toppingToppingToPizzases;

  /**
   * @return priceEnd
   */
  public Double getPriceEnd() {
    return this.priceEnd;
  }

  /**
   * @param priceEnd priceEnd to set
   * @return ToppingFilter
   */
  public <T extends ToppingFilter> T setPriceEnd(Double priceEnd) {
    this.priceEnd = priceEnd;
    return (T) this;
  }

  /**
   * @return priceStart
   */
  public Double getPriceStart() {
    return this.priceStart;
  }

  /**
   * @param priceStart priceStart to set
   * @return ToppingFilter
   */
  public <T extends ToppingFilter> T setPriceStart(Double priceStart) {
    this.priceStart = priceStart;
    return (T) this;
  }

  /**
   * @return toppingToppingToPizzasIds
   */
  public Set<String> getToppingToppingToPizzasIds() {
    return this.toppingToppingToPizzasIds;
  }

  /**
   * @param toppingToppingToPizzasIds toppingToppingToPizzasIds to set
   * @return ToppingFilter
   */
  public <T extends ToppingFilter> T setToppingToppingToPizzasIds(
      Set<String> toppingToppingToPizzasIds) {
    this.toppingToppingToPizzasIds = toppingToppingToPizzasIds;
    return (T) this;
  }

  /**
   * @return toppingToppingToPizzases
   */
  @JsonIgnore
  public List<PizzaToTopping> getToppingToppingToPizzases() {
    return this.toppingToppingToPizzases;
  }

  /**
   * @param toppingToppingToPizzases toppingToppingToPizzases to set
   * @return ToppingFilter
   */
  public <T extends ToppingFilter> T setToppingToppingToPizzases(
      List<PizzaToTopping> toppingToppingToPizzases) {
    this.toppingToppingToPizzases = toppingToppingToPizzases;
    return (T) this;
  }
}
