package com.wizzdi.examples.runtime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Branch extends Basic {

  @OneToMany(targetEntity = PizzaOrder.class, mappedBy = "branch")
  @JsonIgnore
  private List<PizzaOrder> branchPizzaOrders;

  private String fullAddress;

  private double lat;

  private double lon;

  /**
   * @return branchPizzaOrders
   */
  @OneToMany(targetEntity = PizzaOrder.class, mappedBy = "branch")
  @JsonIgnore
  public List<PizzaOrder> getBranchPizzaOrders() {
    return this.branchPizzaOrders;
  }

  /**
   * @param branchPizzaOrders branchPizzaOrders to set
   * @return Branch
   */
  public <T extends Branch> T setBranchPizzaOrders(List<PizzaOrder> branchPizzaOrders) {
    this.branchPizzaOrders = branchPizzaOrders;
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
   * @return Branch
   */
  public <T extends Branch> T setFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
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
   * @return Branch
   */
  public <T extends Branch> T setLat(double lat) {
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
   * @return Branch
   */
  public <T extends Branch> T setLon(double lon) {
    this.lon = lon;
    return (T) this;
  }
}
