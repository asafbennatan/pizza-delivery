package com.wizzdi.examples.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.runtime.model.Topping;
import com.wizzdi.examples.runtime.validation.IdValid;
import com.wizzdi.examples.runtime.validation.Update;

/** Object Used to Update Topping */
@IdValid.List({
  @IdValid(
      targetField = "topping",
      field = "id",
      fieldType = Topping.class,
      groups = {Update.class})
})
public class ToppingUpdate extends ToppingCreate {

  private String id;

  @JsonIgnore private Topping topping;

  /**
   * @return id
   */
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return ToppingUpdate
   */
  public <T extends ToppingUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return topping
   */
  @JsonIgnore
  public Topping getTopping() {
    return this.topping;
  }

  /**
   * @param topping topping to set
   * @return ToppingUpdate
   */
  public <T extends ToppingUpdate> T setTopping(Topping topping) {
    this.topping = topping;
    return (T) this;
  }
}
