package com.wizzdi.examples.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.validation.IdValid;
import java.util.List;
import java.util.Set;

/** Object Used to List Branch */
@IdValid.List({
  @IdValid(
      targetField = "branchPizzaOrderses",
      field = "branchPizzaOrdersIds",
      fieldType = PizzaOrder.class)
})
public class BranchFilter extends BasicFilter {

  private Set<String> branchPizzaOrdersIds;

  @JsonIgnore private List<PizzaOrder> branchPizzaOrderses;

  private Set<String> fullAddress;

  private Double latEnd;

  private Double latStart;

  private Double lonEnd;

  private Double lonStart;

  /**
   * @return branchPizzaOrdersIds
   */
  public Set<String> getBranchPizzaOrdersIds() {
    return this.branchPizzaOrdersIds;
  }

  /**
   * @param branchPizzaOrdersIds branchPizzaOrdersIds to set
   * @return BranchFilter
   */
  public <T extends BranchFilter> T setBranchPizzaOrdersIds(Set<String> branchPizzaOrdersIds) {
    this.branchPizzaOrdersIds = branchPizzaOrdersIds;
    return (T) this;
  }

  /**
   * @return branchPizzaOrderses
   */
  @JsonIgnore
  public List<PizzaOrder> getBranchPizzaOrderses() {
    return this.branchPizzaOrderses;
  }

  /**
   * @param branchPizzaOrderses branchPizzaOrderses to set
   * @return BranchFilter
   */
  public <T extends BranchFilter> T setBranchPizzaOrderses(List<PizzaOrder> branchPizzaOrderses) {
    this.branchPizzaOrderses = branchPizzaOrderses;
    return (T) this;
  }

  /**
   * @return fullAddress
   */
  public Set<String> getFullAddress() {
    return this.fullAddress;
  }

  /**
   * @param fullAddress fullAddress to set
   * @return BranchFilter
   */
  public <T extends BranchFilter> T setFullAddress(Set<String> fullAddress) {
    this.fullAddress = fullAddress;
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
   * @return BranchFilter
   */
  public <T extends BranchFilter> T setLatEnd(Double latEnd) {
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
   * @return BranchFilter
   */
  public <T extends BranchFilter> T setLatStart(Double latStart) {
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
   * @return BranchFilter
   */
  public <T extends BranchFilter> T setLonEnd(Double lonEnd) {
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
   * @return BranchFilter
   */
  public <T extends BranchFilter> T setLonStart(Double lonStart) {
    this.lonStart = lonStart;
    return (T) this;
  }
}
