package com.wizzdi.examples.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wizzdi.examples.model.model.SecuredBasic;
import com.wizzdi.examples.model.validation.IdValid;
import jakarta.validation.constraints.Min;
import java.util.List;
import java.util.Set;

/** Object Used to List AppUser */
@IdValid.List({
  @IdValid(
      field = "creator1SecuredBasicsIds",
      fieldType = SecuredBasic.class,
      targetField = "creator1SecuredBasicses")
})
public class AppUserFilter {

  private Set<String> creator1SecuredBasicsIds;

  @JsonIgnore private List<SecuredBasic> creator1SecuredBasicses;

  @Min(value = 0)
  @Min(value = 0)
  private Integer currentPage;

  private Set<String> fullAddress;

  private Set<String> id;

  @Min(value = 1)
  @Min(value = 1)
  private Integer pageSize;

  private Set<String> roles;

  private Set<String> username;

  /**
   * @return creator1SecuredBasicsIds
   */
  public Set<String> getCreator1SecuredBasicsIds() {
    return this.creator1SecuredBasicsIds;
  }

  /**
   * @param creator1SecuredBasicsIds creator1SecuredBasicsIds to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setCreator1SecuredBasicsIds(
      Set<String> creator1SecuredBasicsIds) {
    this.creator1SecuredBasicsIds = creator1SecuredBasicsIds;
    return (T) this;
  }

  /**
   * @return creator1SecuredBasicses
   */
  @JsonIgnore
  public List<SecuredBasic> getCreator1SecuredBasicses() {
    return this.creator1SecuredBasicses;
  }

  /**
   * @param creator1SecuredBasicses creator1SecuredBasicses to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setCreator1SecuredBasicses(
      List<SecuredBasic> creator1SecuredBasicses) {
    this.creator1SecuredBasicses = creator1SecuredBasicses;
    return (T) this;
  }

  /**
   * @return currentPage
   */
  public Integer getCurrentPage() {
    return this.currentPage;
  }

  /**
   * @param currentPage currentPage to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setCurrentPage(Integer currentPage) {
    this.currentPage = currentPage;
    return (T) this;
  }

  /**
   * @return fullAddress
   */
  public Set<String> getFullAddress() {
    return this.fullAddress;
  }

  /**
   * @param fullAddress fullAddress to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setFullAddress(Set<String> fullAddress) {
    this.fullAddress = fullAddress;
    return (T) this;
  }

  /**
   * @return id
   */
  public Set<String> getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setId(Set<String> id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return pageSize
   */
  public Integer getPageSize() {
    return this.pageSize;
  }

  /**
   * @param pageSize pageSize to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return (T) this;
  }

  /**
   * @return roles
   */
  public Set<String> getRoles() {
    return this.roles;
  }

  /**
   * @param roles roles to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setRoles(Set<String> roles) {
    this.roles = roles;
    return (T) this;
  }

  /**
   * @return username
   */
  public Set<String> getUsername() {
    return this.username;
  }

  /**
   * @param username username to set
   * @return AppUserFilter
   */
  public <T extends AppUserFilter> T setUsername(Set<String> username) {
    this.username = username;
    return (T) this;
  }
}
