package com.wizzdi.examples.runtime.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.runtime.model.Branch;
import com.wizzdi.examples.runtime.validation.IdValid;
import com.wizzdi.examples.runtime.validation.Update;

/** Object Used to Update Branch */
@IdValid.List({
  @IdValid(
      targetField = "branch",
      field = "id",
      fieldType = Branch.class,
      groups = {Update.class})
})
public class BranchUpdate extends BranchCreate {

  @JsonIgnore private Branch branch;

  private String id;

  /**
   * @return branch
   */
  @JsonIgnore
  public Branch getBranch() {
    return this.branch;
  }

  /**
   * @param branch branch to set
   * @return BranchUpdate
   */
  public <T extends BranchUpdate> T setBranch(Branch branch) {
    this.branch = branch;
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
   * @return BranchUpdate
   */
  public <T extends BranchUpdate> T setId(String id) {
    this.id = id;
    return (T) this;
  }
}
