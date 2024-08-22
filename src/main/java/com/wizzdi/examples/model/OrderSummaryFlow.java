package com.wizzdi.examples.model;

import com.wizzdi.examples.model.model.Pizza;
import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.model.PizzaToTopping;
import com.wizzdi.examples.model.request.PizzaFilter;
import com.wizzdi.examples.model.request.PizzaOrderFilter;
import com.wizzdi.examples.model.request.PizzaToToppingFilter;
import com.wizzdi.examples.model.security.UserSecurityContext;
import com.wizzdi.examples.model.service.PizzaOrderService;
import com.wizzdi.examples.model.service.PizzaService;
import com.wizzdi.examples.model.service.PizzaToToppingService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderSummaryFlow {

  @Autowired private PizzaOrderService pizzaOrderService;

  @Autowired private PizzaToToppingService pizzaToToppingService;
  @Autowired private PizzaService pizzaService;

  public OrderSummary run(String orderId, UserSecurityContext securityContext) {

    PizzaOrderFilter orderFilter = new PizzaOrderFilter().setId(new HashSet<>(Set.of(orderId)));

    PizzaOrder order =
        pizzaOrderService.listAllPizzaOrders(orderFilter, securityContext).stream()
            .findFirst()
            .orElse(null);

    OrderSummary orderSummary = toOrderSummary(order);

    return orderSummary;
  }

  public OrderSummary toOrderSummary(PizzaOrder pizzaOrder) {
    List<Pizza> pizza =
        pizzaService.listAllPizzas(
            new PizzaFilter().setPizzaOrders(Collections.singletonList(pizzaOrder)), null);
    List<PizzaToTopping> toppings =
        pizza.isEmpty()
            ? new ArrayList<>()
            : pizzaToToppingService.listAllPizzaToToppings(
                new PizzaToToppingFilter().setPizzas(pizza), null);

    Map<String, List<PizzaToTopping>> toppingmap =
        toppings.stream().collect(Collectors.groupingBy(f -> f.getPizza().getId()));
    OrderSummary orderSummary =
        new OrderSummary()
            .setFullAddress(pizzaOrder.getCreator().getFullAddress())
            .setOrder(pizzaOrder)
            .setPizza(new ArrayList<>());
    for (Pizza pizzaItem : pizza) {
      PizzaSummary pizzaSummary =
          new PizzaSummary().setBase(5D).setPizza(pizzaItem).setToppings(new ArrayList<>());
      List<PizzaToTopping> pizzaToppings =
          toppingmap.getOrDefault(pizzaItem.getId(), new ArrayList<>());
      for (PizzaToTopping topping : pizzaToppings) {
        ToppingSummary toppingSummary =
            new ToppingSummary()
                .setTotal(topping.getPizzaCoverage() * topping.getTopping().getPrice())
                .setTopping(topping.getTopping());
        pizzaSummary.getToppings().add(toppingSummary);
      }
      pizzaSummary.setTotal(
          pizzaSummary.getToppings().stream().mapToDouble(f -> f.getTotal()).sum());
      orderSummary.getPizza().add(pizzaSummary);
    }
    orderSummary.setSubtotal(orderSummary.getPizza().stream().mapToDouble(f -> f.getTotal()).sum());
    orderSummary.setTotal(orderSummary.getSubtotal() + orderSummary.getDelivery());
    return orderSummary;
  }
}
