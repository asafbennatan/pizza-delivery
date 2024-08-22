package com.wizzdi.examples.model.controller;

import com.wizzdi.examples.model.model.AppUser;
import com.wizzdi.examples.model.request.AppUserCreate;
import com.wizzdi.examples.model.request.AppUserFilter;
import com.wizzdi.examples.model.request.AppUserUpdate;
import com.wizzdi.examples.model.response.PaginationResponse;
import com.wizzdi.examples.model.security.UserSecurityContext;
import com.wizzdi.examples.model.service.AppUser1Service;
import com.wizzdi.examples.model.validation.Create;
import com.wizzdi.examples.model.validation.Update;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("AppUser1")
@Tag(name = "AppUser")
public class AppUser1Controller {

  @Autowired private AppUser1Service appUser1Service;

  @PostMapping("createAppUser")
  @Operation(summary = "createAppUser", description = "Creates AppUser")
  public AppUser createAppUser(
      @Validated(Create.class) @RequestBody AppUserCreate appUserCreate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return appUser1Service.createAppUser(appUserCreate, securityContext);
  }

  @DeleteMapping("{id}")
  @Operation(summary = "deleteAppUser", description = "Deletes AppUser")
  public AppUser deleteAppUser(@PathVariable("id") String id, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return appUser1Service.deleteAppUser(id, securityContext);
  }

  @PostMapping("getAllAppUsers")
  @Operation(summary = "getAllAppUsers", description = "lists AppUsers")
  public PaginationResponse<AppUser> getAllAppUsers(
      @Valid @RequestBody AppUserFilter appUserFilter, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return appUser1Service.getAllAppUsers(appUserFilter, securityContext);
  }

  @PutMapping("updateAppUser")
  @Operation(summary = "updateAppUser", description = "Updates AppUser")
  public AppUser updateAppUser(
      @Validated(Update.class) @RequestBody AppUserUpdate appUserUpdate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return appUser1Service.updateAppUser(appUserUpdate, securityContext);
  }
}
