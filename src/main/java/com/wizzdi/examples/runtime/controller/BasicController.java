package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.model.Basic;
import com.wizzdi.examples.runtime.request.BasicCreate;
import com.wizzdi.examples.runtime.request.BasicFilter;
import com.wizzdi.examples.runtime.request.BasicUpdate;
import com.wizzdi.examples.runtime.response.PaginationResponse;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import com.wizzdi.examples.runtime.service.BasicService;
import com.wizzdi.examples.runtime.validation.Create;
import com.wizzdi.examples.runtime.validation.Update;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("Basic")
@Tag(name = "Basic")
public class BasicController {

  @Autowired private BasicService basicService;

  @PostMapping("createBasic")
  @Operation(summary = "createBasic", description = "Creates Basic")
  public Basic createBasic(
      @Validated(Create.class) @RequestBody BasicCreate basicCreate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return basicService.createBasic(basicCreate, securityContext);
  }

  @DeleteMapping("{id}")
  @Operation(summary = "deleteBasic", description = "Deletes Basic")
  public Basic deleteBasic(@PathVariable("id") String id, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return basicService.deleteBasic(id, securityContext);
  }

  @PostMapping("getAllBasics")
  @Operation(summary = "getAllBasics", description = "lists Basics")
  public PaginationResponse<Basic> getAllBasics(
      @Valid @RequestBody BasicFilter basicFilter, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return basicService.getAllBasics(basicFilter, securityContext);
  }

  @PutMapping("updateBasic")
  @Operation(summary = "updateBasic", description = "Updates Basic")
  public Basic updateBasic(
      @Validated(Update.class) @RequestBody BasicUpdate basicUpdate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return basicService.updateBasic(basicUpdate, securityContext);
  }
}
