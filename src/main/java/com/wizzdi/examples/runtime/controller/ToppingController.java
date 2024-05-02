package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.model.Topping;
import com.wizzdi.examples.runtime.request.ToppingCreate;
import com.wizzdi.examples.runtime.request.ToppingFilter;
import com.wizzdi.examples.runtime.request.ToppingUpdate;
import com.wizzdi.examples.runtime.response.PaginationResponse;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import com.wizzdi.examples.runtime.service.ToppingService;
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
@RequestMapping("Topping")
@Tag(name = "Topping")
public class ToppingController {

  @Autowired private ToppingService toppingService;

  @PostMapping("createTopping")
  @Operation(summary = "createTopping", description = "Creates Topping")
  @PreAuthorize("hasAnyRole('Admin')")
  public Topping createTopping(
      @Validated(Create.class) @RequestBody ToppingCreate toppingCreate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return toppingService.createTopping(toppingCreate, securityContext);
  }

  @DeleteMapping("{id}")
  @Operation(summary = "deleteTopping", description = "Deletes Topping")
  @PreAuthorize("hasAnyRole('Admin')")
  public Topping deleteTopping(@PathVariable("id") String id, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return toppingService.deleteTopping(id, securityContext);
  }

  @PostMapping("getAllToppings")
  @Operation(summary = "getAllToppings", description = "lists Toppings")
  public PaginationResponse<Topping> getAllToppings(
      @Valid @RequestBody ToppingFilter toppingFilter, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return toppingService.getAllToppings(toppingFilter, securityContext);
  }

  @PutMapping("updateTopping")
  @Operation(summary = "updateTopping", description = "Updates Topping")
  @PreAuthorize("hasAnyRole('Admin')")
  public Topping updateTopping(
      @Validated(Update.class) @RequestBody ToppingUpdate toppingUpdate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return toppingService.updateTopping(toppingUpdate, securityContext);
  }
}
