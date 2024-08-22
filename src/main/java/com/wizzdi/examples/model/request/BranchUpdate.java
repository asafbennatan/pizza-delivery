package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.Branch;
import com.wizzdi.examples.model.validation.IdValid;
import com.wizzdi.examples.model.validation.Update;

/** Object Used to Update Branch */
@IdValid.List({
  @IdValid(
      field = "id",
      fieldType = Branch.class,
      targetField = "branch",
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
