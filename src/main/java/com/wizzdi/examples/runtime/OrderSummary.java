package com.wizzdi.examples.runtime;

import com.wizzdi.examples.runtime.model.PizzaOrder;
import java.util.List;

public class OrderSummary {

  private double delivery;

  private String fullAddress;

  private PizzaOrder order;

  private List<PizzaSummary> pizza;

  private double subtotal;

  private double total;

  /**
   * @return delivery
   */
  public double getDelivery() {
    return this.delivery;
  }

  /**
   * @param delivery delivery to set
   * @return OrderSummary
   */
  public <T extends OrderSummary> T setDelivery(double delivery) {
    this.delivery = delivery;
    return (T) this;
  }

  /**
   * @return fullAddress
   */
  public String getFullAddress() {
    return this.fullAddress;
  }

  /**
   * @param fullAddress fullAddress to set
   * @return OrderSummary
   */
  public <T extends OrderSummary> T setFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
    return (T) this;
  }

  /**
   * @return order
   */
  public PizzaOrder getOrder() {
    return this.order;
  }

  /**
   * @param order order to set
   * @return OrderSummary
   */
  public <T extends OrderSummary> T setOrder(PizzaOrder order) {
    this.order = order;
    return (T) this;
  }

  /**
   * @return pizza
   */
  public List<PizzaSummary> getPizza() {
    return this.pizza;
  }

  /**
   * @param pizza pizza to set
   * @return OrderSummary
   */
  public <T extends OrderSummary> T setPizza(List<PizzaSummary> pizza) {
    this.pizza = pizza;
    return (T) this;
  }

  /**
   * @return subtotal
   */
  public double getSubtotal() {
    return this.subtotal;
  }

  /**
   * @param subtotal subtotal to set
   * @return OrderSummary
   */
  public <T extends OrderSummary> T setSubtotal(double subtotal) {
    this.subtotal = subtotal;
    return (T) this;
  }

  /**
   * @return total
   */
  public double getTotal() {
    return this.total;
  }

  /**
   * @param total total to set
   * @return OrderSummary
   */
  public <T extends OrderSummary> T setTotal(double total) {
    this.total = total;
    return (T) this;
  }
}
