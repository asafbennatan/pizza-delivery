package com.wizzdi.examples.model;

import com.wizzdi.examples.model.model.OrderStatus;

public class PizzaOrderMessage {

  private double lat;

  private double lon;

  private String orderId;

  private OrderStatus status;

  /**
   * @return lat
   */
  public double getLat() {
    return this.lat;
  }

  /**
   * @param lat lat to set
   * @return PizzaOrderMessage
   */
  public <T extends PizzaOrderMessage> T setLat(double lat) {
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
   * @return PizzaOrderMessage
   */
  public <T extends PizzaOrderMessage> T setLon(double lon) {
    this.lon = lon;
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
   * @return PizzaOrderMessage
   */
  public <T extends PizzaOrderMessage> T setOrderId(String orderId) {
    this.orderId = orderId;
    return (T) this;
  }

  /**
   * @return status
   */
  public OrderStatus getStatus() {
    return this.status;
  }

  /**
   * @param status status to set
   * @return PizzaOrderMessage
   */
  public <T extends PizzaOrderMessage> T setStatus(OrderStatus status) {
    this.status = status;
    return (T) this;
  }
}
