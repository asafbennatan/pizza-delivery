package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.Pizza;
import com.wizzdi.examples.model.model.Topping;
import com.wizzdi.examples.model.validation.IdValid;
import jakarta.validation.constraints.Min;
import java.util.List;
import java.util.Set;

/** Object Used to List PizzaToTopping */
@IdValid.List({
  @IdValid(field = "pizzaIds", fieldType = Pizza.class, targetField = "pizzas"),
  @IdValid(field = "toppingIds", fieldType = Topping.class, targetField = "toppings")
})
public class PizzaToToppingFilter {

  @Min(value = 0)
  private Integer currentPage;

  private Set<String> id;

  @Min(value = 1)
  private Integer pageSize;

  private Double pizzaCoverageEnd;

  private Double pizzaCoverageStart;

  private Set<String> pizzaIds;

  @JsonIgnore private List<Pizza> pizzas;

  private Set<String> toppingIds;

  @JsonIgnore private List<Topping> toppings;

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage currentPage to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return (T) this;
  }

  /**
   * @return id
   */
  public Set<String> getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setId(Set<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return pageSize
   */
  public Integer getPageSize() {
    return this.pageSize;
  }

  /**
   * @param pageSize pageSize to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }

  /**
   * @return pizzaCoverageEnd
   */
  public Double getPizzaCoverageEnd() {
    return this.pizzaCoverageEnd;
  }

  /**
   * @param pizzaCoverageEnd pizzaCoverageEnd to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setPizzaCoverageEnd(Double pizzaCoverageEnd) {
    this.pizzaCoverageEnd = pizzaCoverageEnd;
    return (T) this;
  }

  /**
   * @return pizzaCoverageStart
   */
  public Double getPizzaCoverageStart() {
    return this.pizzaCoverageStart;
  }

  /**
   * @param pizzaCoverageStart pizzaCoverageStart to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setPizzaCoverageStart(Double pizzaCoverageStart) {
    this.pizzaCoverageStart = pizzaCoverageStart;
    return (T) this;
  }

  /**
   * @return pizzaIds
   */
  public Set<String> getPizzaIds() {
    return this.pizzaIds;
  }

  /**
   * @param pizzaIds pizzaIds to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setPizzaIds(Set<String> pizzaIds) {
    this.pizzaIds = pizzaIds;
    return (T) this;
  }

  /**
   * @return pizzas
   */
  @JsonIgnore
  public List<Pizza> getPizzas() {
    return this.pizzas;
  }

  /**
   * @param pizzas pizzas to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setPizzas(List<Pizza> pizzas) {
    this.pizzas = pizzas;
    return (T) this;
  }

  /**
   * @return toppingIds
   */
  public Set<String> getToppingIds() {
    return this.toppingIds;
  }

  /**
   * @param toppingIds toppingIds to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setToppingIds(Set<String> toppingIds) {
    this.toppingIds = toppingIds;
    return (T) this;
  }

  /**
   * @return toppings
   */
  @JsonIgnore
  public List<Topping> getToppings() {
    return this.toppings;
  }

  /**
   * @param toppings toppings to set
   * @return PizzaToToppingFilter
   */
  public <T extends PizzaToToppingFilter> T setToppings(List<Topping> toppings) {
    this.toppings = toppings;
    return (T) this;
  }
}
