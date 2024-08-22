package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.Topping;
import com.wizzdi.examples.model.validation.IdValid;
import com.wizzdi.examples.model.validation.Update;

/** Object Used to Update Topping */
@IdValid.List({
  @IdValid(
      field = "id",
      fieldType = Topping.class,
      targetField = "topping",
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
