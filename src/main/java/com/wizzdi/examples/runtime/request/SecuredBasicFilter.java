package com.wizzdi.examples.runtime.request;

import java.util.Set;

/** Object Used to List SecuredBasic */
public class SecuredBasicFilter extends BasicFilter {

  private Set<String> creator;

  /**
   * @return creator
   */
  public Set<String> getCreator() {
    return this.creator;
  }

  /**
   * @param creator creator to set
   * @return SecuredBasicFilter
   */
  public <T extends SecuredBasicFilter> T setCreator(Set<String> creator) {
    this.creator = creator;
    return (T) this;
  }
}
