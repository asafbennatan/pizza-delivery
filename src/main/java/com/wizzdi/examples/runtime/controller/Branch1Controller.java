package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.model.Branch;
import com.wizzdi.examples.runtime.request.BranchCreate;
import com.wizzdi.examples.runtime.request.BranchFilter;
import com.wizzdi.examples.runtime.request.BranchUpdate;
import com.wizzdi.examples.runtime.response.PaginationResponse;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import com.wizzdi.examples.runtime.service.BranchService;
import com.wizzdi.examples.runtime.validation.Create;
import com.wizzdi.examples.runtime.validation.Update;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("Branch")
@Tag(name = "Branch")
public class Branch1Controller {

  @Autowired private BranchService branchService;

  @PostMapping("createBranch")
  @Operation(summary = "createBranch", description = "Creates Branch")
  @PreAuthorize("hasAnyRole('Admin')")
  public Branch createBranch(
      @Validated(Create.class) @RequestBody BranchCreate branchCreate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return branchService.createBranch(branchCreate, securityContext);
  }

  @DeleteMapping("{id}")
  @Operation(summary = "deleteBranch", description = "Deletes Branch")
  @PreAuthorize("hasAnyRole('Admin')")
  public Branch deleteBranch(@PathVariable("id") String id, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return branchService.deleteBranch(id, securityContext);
  }

  @PostMapping("getAllBranches")
  @Operation(summary = "getAllBranches", description = "lists Branches")
  public PaginationResponse<Branch> getAllBranches(
      @Valid @RequestBody BranchFilter branchFilter, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return branchService.getAllBranches(branchFilter, securityContext);
  }

  @PutMapping("updateBranch")
  @Operation(summary = "updateBranch", description = "Updates Branch")
  @PreAuthorize("hasAnyRole('Admin')")
  public Branch updateBranch(
      @Validated(Update.class) @RequestBody BranchUpdate branchUpdate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return branchService.updateBranch(branchUpdate, securityContext);
  }
}
