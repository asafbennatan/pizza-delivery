package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.SecuredBasic;
import com.wizzdi.examples.model.validation.IdValid;
import com.wizzdi.examples.model.validation.Update;

/** Object Used to Update SecuredBasic */
@IdValid.List({
  @IdValid(
      field = "id",
      fieldType = SecuredBasic.class,
      targetField = "securedBasic",
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
