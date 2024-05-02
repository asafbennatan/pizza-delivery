package com.wizzdi.examples.runtime.api.response;

import java.util.List;

public class Tracker {

  private String update_time;

  private String create_time;

  private List<LinkDescription> links;

  private String id;

  private List<TrackerItem> items;

  private Object status;

  /**
   * @return update_time
   */
  public String getUpdate_time() {
    return this.update_time;
  }

  /**
   * @param update_time update_time to set
   * @return Tracker
   */
  public <T extends Tracker> T setUpdate_time(String update_time) {
    this.update_time = update_time;
    return (T) this;
  }

  /**
   * @return create_time
   */
  public String getCreate_time() {
    return this.create_time;
  }

  /**
   * @param create_time create_time to set
   * @return Tracker
   */
  public <T extends Tracker> T setCreate_time(String create_time) {
    this.create_time = create_time;
    return (T) this;
  }

  /**
   * @return links
   */
  public List<LinkDescription> getLinks() {
    return this.links;
  }

  /**
   * @param links links to set
   * @return Tracker
   */
  public <T extends Tracker> T setLinks(List<LinkDescription> links) {
    this.links = links;
    return (T) this;
  }

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return Tracker
   */
  public <T extends Tracker> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return items
   */
  public List<TrackerItem> getItems() {
    return this.items;
  }

  /**
   * @param items items to set
   * @return Tracker
   */
  public <T extends Tracker> T setItems(List<TrackerItem> items) {
    this.items = items;
    return (T) this;
  }

  /**
   * @return status
   */
  public Object getStatus() {
    return this.status;
  }

  /**
   * @param status status to set
   * @return Tracker
   */
  public <T extends Tracker> T setStatus(Object status) {
    this.status = status;
    return (T) this;
  }
}
