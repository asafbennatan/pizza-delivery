package com.wizzdi.examples.model.controller;

import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.request.PizzaOrderCreate;
import com.wizzdi.examples.model.request.PizzaOrderFilter;
import com.wizzdi.examples.model.request.PizzaOrderUpdate;
import com.wizzdi.examples.model.response.PaginationResponse;
import com.wizzdi.examples.model.security.UserSecurityContext;
import com.wizzdi.examples.model.service.PizzaOrderService;
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
@RequestMapping("PizzaOrder")
@Tag(name = "PizzaOrder")
public class PizzaOrderController {

  @Autowired private PizzaOrderService pizzaOrderService;

  @PostMapping("createPizzaOrder")
  @Operation(summary = "createPizzaOrder", description = "Creates PizzaOrder")
  public PizzaOrder createPizzaOrder(
      @Validated(Create.class) @RequestBody PizzaOrderCreate pizzaOrderCreate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaOrderService.createPizzaOrder(pizzaOrderCreate, securityContext);
  }

  @DeleteMapping("{id}")
  @Operation(summary = "deletePizzaOrder", description = "Deletes PizzaOrder")
  public PizzaOrder deletePizzaOrder(@PathVariable("id") String id, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaOrderService.deletePizzaOrder(id, securityContext);
  }

  @PostMapping("getAllPizzaOrders")
  @Operation(summary = "getAllPizzaOrders", description = "lists PizzaOrders")
  public PaginationResponse<PizzaOrder> getAllPizzaOrders(
      @Valid @RequestBody PizzaOrderFilter pizzaOrderFilter, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaOrderService.getAllPizzaOrders(pizzaOrderFilter, securityContext);
  }

  @PutMapping("updatePizzaOrder")
  @Operation(summary = "updatePizzaOrder", description = "Updates PizzaOrder")
  public PizzaOrder updatePizzaOrder(
      @Validated(Update.class) @RequestBody PizzaOrderUpdate pizzaOrderUpdate,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return pizzaOrderService.updatePizzaOrder(pizzaOrderUpdate, securityContext);
  }
}
