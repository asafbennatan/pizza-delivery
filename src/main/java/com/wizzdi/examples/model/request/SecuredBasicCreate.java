package com.wizzdi.examples.model.request;

/** Object Used to Create SecuredBasic */
public class SecuredBasicCreate extends BasicCreate {

  private String creatorId;

  /**
   * @return creatorId
   */
  public String getCreatorId() {
    return this.creatorId;
  }

  /**
   * @param creatorId creatorId to set
   * @return SecuredBasicCreate
   */
  public <T extends SecuredBasicCreate> T setCreatorId(String creatorId) {
    this.creatorId = creatorId;
    return (T) this;
  }
}
