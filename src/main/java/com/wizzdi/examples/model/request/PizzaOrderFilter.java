package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.Branch;
import com.wizzdi.examples.model.model.OrderStatus;
import com.wizzdi.examples.model.model.Pizza;
import com.wizzdi.examples.model.validation.IdValid;
import java.util.List;
import java.util.Set;

/** Object Used to List PizzaOrder */
@IdValid.List({
  @IdValid(field = "branchIds", fieldType = Branch.class, targetField = "branches"),
  @IdValid(
      field = "pizzaOrderPizzasIds",
      fieldType = Pizza.class,
      targetField = "pizzaOrderPizzases")
})
public class PizzaOrderFilter extends SecuredBasicFilter {

  private Set<String> branchIds;

  @JsonIgnore private List<Branch> branches;

  private Double latEnd;

  private Double latStart;

  private Double lonEnd;

  private Double lonStart;

  private Set<String> orderId;

  private Set<OrderStatus> orderStatus;

  private Set<String> pizzaOrderPizzasIds;

  @JsonIgnore private List<Pizza> pizzaOrderPizzases;

  /**
   * @return branchIds
   */
  public Set<String> getBranchIds() {
    return this.branchIds;
  }

  /**
   * @param branchIds branchIds to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setBranchIds(Set<String> branchIds) {
    this.branchIds = branchIds;
    return (T) this;
  }

  /**
   * @return branches
   */
  @JsonIgnore
  public List<Branch> getBranches() {
    return this.branches;
  }

  /**
   * @param branches branches to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setBranches(List<Branch> branches) {
    this.branches = branches;
    return (T) this;
  }

  /**
   * @return latEnd
   */
  public Double getLatEnd() {
    return this.latEnd;
  }

  /**
   * @param latEnd latEnd to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setLatEnd(Double latEnd) {
    this.latEnd = latEnd;
    return (T) this;
  }

  /**
   * @return latStart
   */
  public Double getLatStart() {
    return this.latStart;
  }

  /**
   * @param latStart latStart to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setLatStart(Double latStart) {
    this.latStart = latStart;
    return (T) this;
  }

  /**
   * @return lonEnd
   */
  public Double getLonEnd() {
    return this.lonEnd;
  }

  /**
   * @param lonEnd lonEnd to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setLonEnd(Double lonEnd) {
    this.lonEnd = lonEnd;
    return (T) this;
  }

  /**
   * @return lonStart
   */
  public Double getLonStart() {
    return this.lonStart;
  }

  /**
   * @param lonStart lonStart to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setLonStart(Double lonStart) {
    this.lonStart = lonStart;
    return (T) this;
  }

  /**
   * @return orderId
   */
  public Set<String> getOrderId() {
    return this.orderId;
  }

  /**
   * @param orderId orderId to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setOrderId(Set<String> orderId) {
    this.orderId = orderId;
    return (T) this;
  }

  /**
   * @return orderStatus
   */
  public Set<OrderStatus> getOrderStatus() {
    return this.orderStatus;
  }

  /**
   * @param orderStatus orderStatus to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setOrderStatus(Set<OrderStatus> orderStatus) {
    this.orderStatus = orderStatus;
    return (T) this;
  }

  /**
   * @return pizzaOrderPizzasIds
   */
  public Set<String> getPizzaOrderPizzasIds() {
    return this.pizzaOrderPizzasIds;
  }

  /**
   * @param pizzaOrderPizzasIds pizzaOrderPizzasIds to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setPizzaOrderPizzasIds(Set<String> pizzaOrderPizzasIds) {
    this.pizzaOrderPizzasIds = pizzaOrderPizzasIds;
    return (T) this;
  }

  /**
   * @return pizzaOrderPizzases
   */
  @JsonIgnore
  public List<Pizza> getPizzaOrderPizzases() {
    return this.pizzaOrderPizzases;
  }

  /**
   * @param pizzaOrderPizzases pizzaOrderPizzases to set
   * @return PizzaOrderFilter
   */
  public <T extends PizzaOrderFilter> T setPizzaOrderPizzases(List<Pizza> pizzaOrderPizzases) {
    this.pizzaOrderPizzases = pizzaOrderPizzases;
    return (T) this;
  }
}
