package com.wizzdi.examples.model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class PizzaOrder extends SecuredBasic {

  @OneToMany(targetEntity = Pizza.class, mappedBy = "pizzaOrder")
  @JsonIgnore
  private List<Pizza> pizzaOrderPizzas;

  private OrderStatus orderStatus;

  private double lat;

  private double lon;

  @ManyToOne(targetEntity = Branch.class)
  private Branch branch;

  private String orderId;

  /**
   * @return pizzaOrderPizzas
   */
  @OneToMany(targetEntity = Pizza.class, mappedBy = "pizzaOrder")
  @JsonIgnore
  public List<Pizza> getPizzaOrderPizzas() {
    return this.pizzaOrderPizzas;
  }

  /**
   * @param pizzaOrderPizzas pizzaOrderPizzas to set
   * @return PizzaOrder
   */
  public <T extends PizzaOrder> T setPizzaOrderPizzas(List<Pizza> pizzaOrderPizzas) {
    this.pizzaOrderPizzas = pizzaOrderPizzas;
    return (T) this;
  }

  /**
   * @return orderStatus
   */
  public OrderStatus getOrderStatus() {
    return this.orderStatus;
  }

  /**
   * @param orderStatus orderStatus to set
   * @return PizzaOrder
   */
  public <T extends PizzaOrder> T setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
    return (T) this;
  }

  /**
   * @return lat
   */
  public double getLat() {
    return this.lat;
  }

  /**
   * @param lat lat to set
   * @return PizzaOrder
   */
  public <T extends PizzaOrder> T setLat(double lat) {
    this.lat = lat;
    return (T) this;
  }

  /**
   * @return lon
   */
  public double getLon() {
    return this.lon;
  }

  /**
   * @param lon lon to set
   * @return PizzaOrder
   */
  public <T extends PizzaOrder> T setLon(double lon) {
    this.lon = lon;
    return (T) this;
  }

  /**
   * @return branch
   */
  @ManyToOne(targetEntity = Branch.class)
  public Branch getBranch() {
    return this.branch;
  }

  /**
   * @param branch branch to set
   * @return PizzaOrder
   */
  public <T extends PizzaOrder> T setBranch(Branch branch) {
    this.branch = branch;
    return (T) this;
  }

  /**
   * @return orderId
   */
  public String getOrderId() {
    return this.orderId;
  }

  /**
   * @param orderId orderId to set
   * @return PizzaOrder
   */
  public <T extends PizzaOrder> T setOrderId(String orderId) {
    this.orderId = orderId;
    return (T) this;
  }
}
