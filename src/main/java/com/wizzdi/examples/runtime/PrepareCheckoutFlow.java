package com.wizzdi.examples.runtime;

import com.wizzdi.examples.runtime.api.PaypalCheckoutOrdersAPI;
import com.wizzdi.examples.runtime.api.request.CheckoutPaymentIntent;
import com.wizzdi.examples.runtime.api.request.OrderRequest;
import com.wizzdi.examples.runtime.api.request.PurchaseUnitRequest;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.request.PizzaOrderFilter;
import com.wizzdi.examples.runtime.request.PizzaOrderUpdate;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import com.wizzdi.examples.runtime.service.PizzaOrderService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Component;

@Component
public class PrepareCheckoutFlow {

  @Autowired private PizzaOrderService pizzaOrderService;

  @Autowired private ClientRegistrationRepository clientRegistrationRepository;

  @Autowired private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

  @Autowired private OrderSummaryFlow orderSummaryFlow;

  public PizzaOrder run(String orderId, UserSecurityContext securityContext) {

    PizzaOrderFilter orderFilter = new PizzaOrderFilter().setId(new HashSet<>(Set.of(orderId)));

    PizzaOrder order =
        pizzaOrderService.listAllPizzaOrders(orderFilter, securityContext).stream()
            .findFirst()
            .orElse(null);

    com.wizzdi.examples.runtime.OrderSummary summary = getSummary(order);

    if (order.getOrderId() == null) {

      PaypalCheckoutOrdersAPI paypalClient =
          new PaypalCheckoutOrdersAPI(oAuth2AuthorizedClientManager, clientRegistrationRepository);

      var orderResponse =
          Optional.of(
                  paypalClient.orderscreate(
                      new OrderRequest()
                          .setIntent(CheckoutPaymentIntent.CAPTURE)
                          .setPurchase_units(
                              new ArrayList<>(
                                  List.of(new PurchaseUnitRequest().setCustom_id(order.getId())))),
                      null,
                      null,
                      null,
                      "return=representation",
                      null))
              .map(f -> f.getBody())
              .orElseThrow(() -> new RuntimeException("No response from external api"));

      PizzaOrderUpdate pizzaOrderUpdate =
          new PizzaOrderUpdate().setPizzaOrder(order).setOrderId(orderResponse.getId());

      pizzaOrderService.updatePizzaOrder(pizzaOrderUpdate, securityContext);

    } else {

    }

    return order;
  }

  public com.wizzdi.examples.runtime.OrderSummary getSummary(PizzaOrder pizzaOrder) {
    return orderSummaryFlow.toOrderSummary(pizzaOrder);
  }
}
