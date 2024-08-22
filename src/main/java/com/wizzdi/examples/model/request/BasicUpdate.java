package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.Basic;
import com.wizzdi.examples.model.validation.IdValid;
import com.wizzdi.examples.model.validation.Update;

/** Object Used to Update Basic */
@IdValid.List({
  @IdValid(
      field = "id",
      fieldType = Basic.class,
      targetField = "basic",
      groups = {Update.class})
})
public class BasicUpdate extends BasicCreate {

  @JsonIgnore private Basic basic;

  private String id;

  /**
   * @return basic
   */
  @JsonIgnore
  public Basic getBasic() {
    return this.basic;
  }

  /**
   * @param basic basic to set
   * @return BasicUpdate
   */
  public <T extends BasicUpdate> T setBasic(Basic basic) {
    this.basic = basic;
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
   * @return BasicUpdate
   */
  public <T extends BasicUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
