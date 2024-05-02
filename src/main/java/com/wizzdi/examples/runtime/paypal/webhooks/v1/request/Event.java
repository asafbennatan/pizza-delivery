package com.wizzdi.examples.runtime.paypal.webhooks.v1.request;

import com.wizzdi.examples.runtime.paypal.webhooks.v1.response.LinkDescription;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

public class Event {

  private String id;

  private OffsetDateTime create_time;

  private String resource_type;

  private String event_version;

  private String event_type;

  private String summary;

  private String resource_version;

  private Map<Object, String> resource;

  private List<LinkDescription> links;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return Event
   */
  public <T extends Event> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return create_time
   */
  public OffsetDateTime getCreate_time() {
    return this.create_time;
  }

  /**
   * @param create_time create_time to set
   * @return Event
   */
  public <T extends Event> T setCreate_time(OffsetDateTime create_time) {
    this.create_time = create_time;
    return (T) this;
  }

  /**
   * @return resource_type
   */
  public String getResource_type() {
    return this.resource_type;
  }

  /**
   * @param resource_type resource_type to set
   * @return Event
   */
  public <T extends Event> T setResource_type(String resource_type) {
    this.resource_type = resource_type;
    return (T) this;
  }

  /**
   * @return event_version
   */
  public String getEvent_version() {
    return this.event_version;
  }

  /**
   * @param event_version event_version to set
   * @return Event
   */
  public <T extends Event> T setEvent_version(String event_version) {
    this.event_version = event_version;
    return (T) this;
  }

  /**
   * @return event_type
   */
  public String getEvent_type() {
    return this.event_type;
  }

  /**
   * @param event_type event_type to set
   * @return Event
   */
  public <T extends Event> T setEvent_type(String event_type) {
    this.event_type = event_type;
    return (T) this;
  }

  /**
   * @return summary
   */
  public String getSummary() {
    return this.summary;
  }

  /**
   * @param summary summary to set
   * @return Event
   */
  public <T extends Event> T setSummary(String summary) {
    this.summary = summary;
    return (T) this;
  }

  /**
   * @return resource_version
   */
  public String getResource_version() {
    return this.resource_version;
  }

  /**
   * @param resource_version resource_version to set
   * @return Event
   */
  public <T extends Event> T setResource_version(String resource_version) {
    this.resource_version = resource_version;
    return (T) this;
  }

  /**
   * @return resource
   */
  public Map<Object, String> getResource() {
    return this.resource;
  }

  /**
   * @param resource resource to set
   * @return Event
   */
  public <T extends Event> T setResource(Map<Object, String> resource) {
    this.resource = resource;
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
   * @return Event
   */
  public <T extends Event> T setLinks(List<LinkDescription> links) {
    this.links = links;
    return (T) this;
  }
}
