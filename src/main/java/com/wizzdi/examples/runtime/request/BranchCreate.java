package com.wizzdi.examples.runtime.request;

/** Object Used to Create Branch */
public class BranchCreate extends BasicCreate {

  private String fullAddress;

  private Double lat;

  private Double lon;

  /**
   * @return fullAddress
   */
  public String getFullAddress() {
    return this.fullAddress;
  }

  /**
   * @param fullAddress fullAddress to set
   * @return BranchCreate
   */
  public <T extends BranchCreate> T setFullAddress(String fullAddress) {
    this.fullAddress = fullAddress;
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
   * @return BranchCreate
   */
  public <T extends BranchCreate> T setLat(Double lat) {
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
   * @return BranchCreate
   */
  public <T extends BranchCreate> T setLon(Double lon) {
    this.lon = lon;
    return (T) this;
  }
}
