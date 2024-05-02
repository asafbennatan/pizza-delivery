package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.model.PizzaToTopping;
import com.wizzdi.examples.runtime.request.PizzaToToppingCreate;
import com.wizzdi.examples.runtime.request.PizzaToToppingFilter;
import com.wizzdi.examples.runtime.request.PizzaToToppingUpdate;
import com.wizzdi.examples.runtime.response.PaginationResponse;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import com.wizzdi.examples.runtime.service.PizzaToToppingService;
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
@RequestMapping("PizzaToTopping")
@Tag(name = "PizzaToTopping")
public class PizzaToToppingController {

  @Autowired private PizzaToToppingService pizzaToToppingService;

  @PostMapping("createPizzaToTopping")
  @Operation(summary = "createPizzaToTopping", description = "Creates PizzaToTopping")
  public PizzaToTopping createPizzaToTopping(
      @Validated(Create.class) @RequestBody PizzaToToppingCreate pizzaToToppingCreate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaToToppingService.createPizzaToTopping(pizzaToToppingCreate, securityContext);
  }

  @DeleteMapping("{id}")
  @Operation(summary = "deletePizzaToTopping", description = "Deletes PizzaToTopping")
  public PizzaToTopping deletePizzaToTopping(
      @PathVariable("id") String id, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaToToppingService.deletePizzaToTopping(id, securityContext);
  }

  @PostMapping("getAllPizzaToToppings")
  @Operation(summary = "getAllPizzaToToppings", description = "lists PizzaToToppings")
  public PaginationResponse<PizzaToTopping> getAllPizzaToToppings(
      @Valid @RequestBody PizzaToToppingFilter pizzaToToppingFilter,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaToToppingService.getAllPizzaToToppings(pizzaToToppingFilter, securityContext);
  }

  @PutMapping("updatePizzaToTopping")
  @Operation(summary = "updatePizzaToTopping", description = "Updates PizzaToTopping")
  public PizzaToTopping updatePizzaToTopping(
      @Validated(Update.class) @RequestBody PizzaToToppingUpdate pizzaToToppingUpdate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaToToppingService.updatePizzaToTopping(pizzaToToppingUpdate, securityContext);
  }
}
