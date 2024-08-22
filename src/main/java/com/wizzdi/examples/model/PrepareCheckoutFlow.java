package com.wizzdi.examples.model;

import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.paypal.orders.v2.PaypalCheckoutOrdersAPI;
import com.wizzdi.examples.model.paypal.orders.v2.request.AmountWithBreakdown;
import com.wizzdi.examples.model.paypal.orders.v2.request.CheckoutPaymentIntent;
import com.wizzdi.examples.model.paypal.orders.v2.request.OrderRequest;
import com.wizzdi.examples.model.paypal.orders.v2.request.PurchaseUnitRequest;
import com.wizzdi.examples.model.request.PizzaOrderFilter;
import com.wizzdi.examples.model.request.PizzaOrderUpdate;
import com.wizzdi.examples.model.security.UserSecurityContext;
import com.wizzdi.examples.model.service.PizzaOrderService;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Component;

@Component
public class PrepareCheckoutFlow {

  @Autowired private ClientRegistrationRepository clientRegistrationRepository;

  @Autowired private PizzaOrderService pizzaOrderService;

  @Autowired private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

  @Autowired private OrderSummaryFlow orderSummaryFlow;

  public PizzaOrder run(String orderId, UserSecurityContext securityContext) {

    PizzaOrderFilter orderFilter = new PizzaOrderFilter().setId(new HashSet<>(Set.of(orderId)));

    PizzaOrder order =
        pizzaOrderService.listAllPizzaOrders(orderFilter, securityContext).stream()
            .findFirst()
            .orElse(null);

    com.wizzdi.examples.model.OrderSummary summary = getSummary(order);

    if (order.getOrderId() == null) {

      PaypalCheckoutOrdersAPI paypalClient =
          new PaypalCheckoutOrdersAPI(oAuth2AuthorizedClientManager, clientRegistrationRepository);

      var orderResponse =
          paypalClient.orderscreate(
              new OrderRequest()
                  .setPurchase_units(
                      new ArrayList<>(
                          List.of(
                              new PurchaseUnitRequest()
                                  .setAmount(
                                      new AmountWithBreakdown()
                                          .setValue(summary.getTotal() + "")
                                          .setCurrency_code("USD"))
                                  .setCustom_id(order.getId()))))
                  .setIntent(CheckoutPaymentIntent.CAPTURE),
              null,
              null,
              null,
              null,
              null);

      if (!(orderResponse.getStatusCode().is2xxSuccessful())) {
        throw new org.springframework.web.server.ResponseStatusException(
            HttpStatus.SERVICE_UNAVAILABLE,
            "creating paypal order failed , status: " + orderResponse.getStatusCodeValue());
      }

      com.wizzdi.examples.model.paypal.orders.v2.response.Order paypalOrderObject =
          orderResponse.getBody();

      PizzaOrderUpdate pizzaOrderUpdate =
          new PizzaOrderUpdate().setPizzaOrder(order).setOrderId(paypalOrderObject.getId());

      pizzaOrderService.updatePizzaOrder(pizzaOrderUpdate, securityContext);

    } else {

    }

    return order;
  }

  public com.wizzdi.examples.model.OrderSummary getSummary(PizzaOrder pizzaOrder) {
    return orderSummaryFlow.toOrderSummary(pizzaOrder);
  }
}
