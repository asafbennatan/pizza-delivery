package com.wizzdi.examples.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.runtime.model.Branch;
import com.wizzdi.examples.runtime.model.OrderStatus;
import com.wizzdi.examples.runtime.validation.Create;
import com.wizzdi.examples.runtime.validation.IdValid;
import com.wizzdi.examples.runtime.validation.Update;

/** Object Used to Create PizzaOrder */
@IdValid.List({
  @IdValid(
      targetField = "branch",
      field = "branchId",
      fieldType = Branch.class,
      groups = {Update.class, Create.class})
})
public class PizzaOrderCreate extends SecuredBasicCreate {

  @JsonIgnore private Branch branch;

  private String branchId;

  private Double lat;

  private Double lon;

  private String orderId;

  private OrderStatus orderStatus;

  /**
   * @return branch
   */
  @JsonIgnore
  public Branch getBranch() {
    return this.branch;
  }

  /**
   * @param branch branch to set
   * @return PizzaOrderCreate
   */
  public <T extends PizzaOrderCreate> T setBranch(Branch branch) {
    this.branch = branch;
    return (T) this;
  }

  /**
   * @return branchId
   */
  public String getBranchId() {
    return this.branchId;
  }

  /**
   * @param branchId branchId to set
   * @return PizzaOrderCreate
   */
  public <T extends PizzaOrderCreate> T setBranchId(String branchId) {
    this.branchId = branchId;
    return (T) this;
  }

  /**
   * @return lat
   */
  public Double getLat() {
    return this.lat;
  }

  /**
   * @param lat lat to set
   * @return PizzaOrderCreate
   */
  public <T extends PizzaOrderCreate> T setLat(Double lat) {
    this.lat = lat;
    return (T) this;
  }

  /**
   * @return lon
   */
  public Double getLon() {
    return this.lon;
  }

  /**
   * @param lon lon to set
   * @return PizzaOrderCreate
   */
  public <T extends PizzaOrderCreate> T setLon(Double lon) {
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
   * @return PizzaOrderCreate
   */
  public <T extends PizzaOrderCreate> T setOrderId(String orderId) {
    this.orderId = orderId;
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
   * @return PizzaOrderCreate
   */
  public <T extends PizzaOrderCreate> T setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
    return (T) this;
  }
}
