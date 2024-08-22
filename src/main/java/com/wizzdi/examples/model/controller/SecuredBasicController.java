package com.wizzdi.examples.model.controller;

import com.wizzdi.examples.model.model.SecuredBasic;
import com.wizzdi.examples.model.request.SecuredBasicCreate;
import com.wizzdi.examples.model.request.SecuredBasicFilter;
import com.wizzdi.examples.model.request.SecuredBasicUpdate;
import com.wizzdi.examples.model.response.PaginationResponse;
import com.wizzdi.examples.model.security.UserSecurityContext;
import com.wizzdi.examples.model.service.SecuredBasicService;
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
@RequestMapping("SecuredBasic")
@Tag(name = "SecuredBasic")
public class SecuredBasicController {

  @Autowired private SecuredBasicService securedBasicService;

  @PostMapping("createSecuredBasic")
  @Operation(summary = "createSecuredBasic", description = "Creates SecuredBasic")
  public SecuredBasic createSecuredBasic(
      @Validated(Create.class) @RequestBody SecuredBasicCreate securedBasicCreate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return securedBasicService.createSecuredBasic(securedBasicCreate, securityContext);
  }

  @DeleteMapping("{id}")
  @Operation(summary = "deleteSecuredBasic", description = "Deletes SecuredBasic")
  public SecuredBasic deleteSecuredBasic(
      @PathVariable("id") String id, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return securedBasicService.deleteSecuredBasic(id, securityContext);
  }

  @PostMapping("getAllSecuredBasics")
  @Operation(summary = "getAllSecuredBasics", description = "lists SecuredBasics")
  public PaginationResponse<SecuredBasic> getAllSecuredBasics(
      @Valid @RequestBody SecuredBasicFilter securedBasicFilter, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return securedBasicService.getAllSecuredBasics(securedBasicFilter, securityContext);
  }

  @PutMapping("updateSecuredBasic")
  @Operation(summary = "updateSecuredBasic", description = "Updates SecuredBasic")
  public SecuredBasic updateSecuredBasic(
      @Validated(Update.class) @RequestBody SecuredBasicUpdate securedBasicUpdate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return securedBasicService.updateSecuredBasic(securedBasicUpdate, securityContext);
  }
}
