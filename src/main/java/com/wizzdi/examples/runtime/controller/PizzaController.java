package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.request.PizzaCreate;
import com.wizzdi.examples.runtime.request.PizzaFilter;
import com.wizzdi.examples.runtime.request.PizzaUpdate;
import com.wizzdi.examples.runtime.response.PaginationResponse;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import com.wizzdi.examples.runtime.service.PizzaService;
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
@RequestMapping("Pizza")
@Tag(name = "Pizza")
public class PizzaController {

  @Autowired private PizzaService pizzaService;

  @PostMapping("createPizza")
  @Operation(summary = "createPizza", description = "Creates Pizza")
  public Pizza createPizza(
      @Validated(Create.class) @RequestBody PizzaCreate pizzaCreate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaService.createPizza(pizzaCreate, securityContext);
  }

  @DeleteMapping("{id}")
  @Operation(summary = "deletePizza", description = "Deletes Pizza")
  public Pizza deletePizza(@PathVariable("id") String id, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaService.deletePizza(id, securityContext);
  }

  @PostMapping("getAllPizzas")
  @Operation(summary = "getAllPizzas", description = "lists Pizzas")
  public PaginationResponse<Pizza> getAllPizzas(
      @Valid @RequestBody PizzaFilter pizzaFilter, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaService.getAllPizzas(pizzaFilter, securityContext);
  }

  @PutMapping("updatePizza")
  @Operation(summary = "updatePizza", description = "Updates Pizza")
  public Pizza updatePizza(
      @Validated(Update.class) @RequestBody PizzaUpdate pizzaUpdate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaService.updatePizza(pizzaUpdate, securityContext);
  }
}
