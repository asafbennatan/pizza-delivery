package com.wizzdi.examples.runtime.service;

import com.wizzdi.examples.runtime.data.BranchRepository;
import com.wizzdi.examples.runtime.model.Branch;
import com.wizzdi.examples.runtime.model.Branch_;
import com.wizzdi.examples.runtime.request.BranchCreate;
import com.wizzdi.examples.runtime.request.BranchFilter;
import com.wizzdi.examples.runtime.request.BranchUpdate;
import com.wizzdi.examples.runtime.response.PaginationResponse;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class BranchService {

  @Autowired private BranchRepository repository;

  @Autowired private BasicService basicService;

  /**
   * @param branchCreate Object Used to Create Branch
   * @param securityContext
   * @return created Branch
   */
  public Branch createBranch(BranchCreate branchCreate, UserSecurityContext securityContext) {
    Branch branch = createBranchNoMerge(branchCreate, securityContext);
    branch = this.repository.merge(branch);
    return branch;
  }

  /**
   * @param branchCreate Object Used to Create Branch
   * @param securityContext
   * @return created Branch unmerged
   */
  public Branch createBranchNoMerge(
      BranchCreate branchCreate, UserSecurityContext securityContext) {
    Branch branch = new Branch();
    branch.setId(UUID.randomUUID().toString());
    updateBranchNoMerge(branch, branchCreate);

    return branch;
  }

  /**
   * @param branchCreate Object Used to Create Branch
   * @param branch
   * @return if branch was updated
   */
  public boolean updateBranchNoMerge(Branch branch, BranchCreate branchCreate) {
    boolean update = basicService.updateBasicNoMerge(branch, branchCreate);

    if (branchCreate.getFullAddress() != null
        && (!branchCreate.getFullAddress().equals(branch.getFullAddress()))) {
      branch.setFullAddress(branchCreate.getFullAddress());
      update = true;
    }

    if (branchCreate.getLat() != null && (!branchCreate.getLat().equals(branch.getLat()))) {
      branch.setLat(branchCreate.getLat());
      update = true;
    }

    if (branchCreate.getLon() != null && (!branchCreate.getLon().equals(branch.getLon()))) {
      branch.setLon(branchCreate.getLon());
      update = true;
    }

    return update;
  }

  /**
   * @param branchUpdate
   * @param securityContext
   * @return branch
   */
  public Branch updateBranch(BranchUpdate branchUpdate, UserSecurityContext securityContext) {
    Branch branch = branchUpdate.getBranch();
    if (updateBranchNoMerge(branch, branchUpdate)) {
      branch = this.repository.merge(branch);
    }
    return branch;
  }

  /**
   * @param branchFilter Object Used to List Branch
   * @param securityContext
   * @return PaginationResponse<Branch> containing paging information for Branch
   */
  public PaginationResponse<Branch> getAllBranches(
      BranchFilter branchFilter, UserSecurityContext securityContext) {
    List<Branch> list = listAllBranches(branchFilter, securityContext);
    long count = this.repository.countAllBranches(branchFilter, securityContext);
    return new PaginationResponse<>(list, branchFilter.getPageSize(), count);
  }

  /**
   * @param branchFilter Object Used to List Branch
   * @param securityContext
   * @return List of Branch
   */
  public List<Branch> listAllBranches(
      BranchFilter branchFilter, UserSecurityContext securityContext) {
    return this.repository.listAllBranches(branchFilter, securityContext);
  }

  public Branch deleteBranch(String id, UserSecurityContext securityContext) {
    Branch branch = this.repository.getByIdOrNull(Branch.class, Branch_.id, id, securityContext);
    ;
    if (branch == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Branch not found");
    }

    this.repository.remove(branch);

    return branch;
  }

  public <T extends Branch, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T extends Branch, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T extends Branch, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T extends Branch, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return repository.listByIds(c, idField, ids);
  }

  public <T> T merge(T base) {
    return this.repository.merge(base);
  }

  public void massMerge(List<?> toMerge) {
    this.repository.massMerge(toMerge);
  }
}
