package com.wizzdi.examples.runtime.api.response;

public class TrackerItem {

  private String name;

  private String quantity;

  private String sku;

  private String image_url;

  private Object upc;

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return TrackerItem
   */
  public <T extends TrackerItem> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return quantity
   */
  public String getQuantity() {
    return this.quantity;
  }

  /**
   * @param quantity quantity to set
   * @return TrackerItem
   */
  public <T extends TrackerItem> T setQuantity(String quantity) {
    this.quantity = quantity;
    return (T) this;
  }

  /**
   * @return sku
   */
  public String getSku() {
    return this.sku;
  }

  /**
   * @param sku sku to set
   * @return TrackerItem
   */
  public <T extends TrackerItem> T setSku(String sku) {
    this.sku = sku;
    return (T) this;
  }

  /**
   * @return image_url
   */
  public String getImage_url() {
    return this.image_url;
  }

  /**
   * @param image_url image_url to set
   * @return TrackerItem
   */
  public <T extends TrackerItem> T setImage_url(String image_url) {
    this.image_url = image_url;
    return (T) this;
  }

  /**
   * @return upc
   */
  public Object getUpc() {
    return this.upc;
  }

  /**
   * @param upc upc to set
   * @return TrackerItem
   */
  public <T extends TrackerItem> T setUpc(Object upc) {
    this.upc = upc;
    return (T) this;
  }
}
