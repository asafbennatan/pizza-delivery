package com.wizzdi.examples.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.runtime.model.SecuredBasic;
import com.wizzdi.examples.runtime.validation.IdValid;
import com.wizzdi.examples.runtime.validation.Update;

/** Object Used to Update SecuredBasic */
@IdValid.List({
  @IdValid(
      targetField = "securedBasic",
      field = "id",
      fieldType = SecuredBasic.class,
      groups = {Update.class})
})
public class SecuredBasicUpdate extends SecuredBasicCreate {

  private String id;

  @JsonIgnore private SecuredBasic securedBasic;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return SecuredBasicUpdate
   */
  public <T extends SecuredBasicUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return securedBasic
   */
  @JsonIgnore
  public SecuredBasic getSecuredBasic() {
    return this.securedBasic;
  }

  /**
   * @param securedBasic securedBasic to set
   * @return SecuredBasicUpdate
   */
  public <T extends SecuredBasicUpdate> T setSecuredBasic(SecuredBasic securedBasic) {
    this.securedBasic = securedBasic;
    return (T) this;
  }
}
