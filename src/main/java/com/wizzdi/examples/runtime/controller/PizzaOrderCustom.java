package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.CheckoutValidatedWebhookFlow;
import com.wizzdi.examples.runtime.OrderSummary;
import com.wizzdi.examples.runtime.OrderSummaryFlow;
import com.wizzdi.examples.runtime.PaypalWebhookResponse;
import com.wizzdi.examples.runtime.PrepareCheckoutFlow;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.paypal.webhooks.v1.request.Event;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.time.OffsetDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("PizzaOrderCustom")
@Tag(name = "PizzaOrderCustom")
public class PizzaOrderCustom {

  @Autowired private PrepareCheckoutFlow prepareCheckoutFlow;

  @Autowired private CheckoutValidatedWebhookFlow checkoutValidatedWebhookFlow;

  @Autowired private OrderSummaryFlow orderSummaryFlow;

  @GetMapping("prepareCheckout/{orderId}")
  @Operation(summary = "prepareCheckout", description = "")
  public PizzaOrder prepareCheckout(
      @PathVariable("orderId") String orderId, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return prepareCheckoutFlow.run(orderId, securityContext);
  }

  @PostMapping("completeOrder")
  @Operation(summary = "completeOrder", description = "")
  public PaypalWebhookResponse completeOrder(
      @RequestHeader("PayPal-Auth-Algo") String PayPalAuthAlgo,
      @RequestHeader("PayPal-Cert-Url") String PayPalCertUrl,
      @RequestHeader("PayPal-Transmission-Id") String PayPalTransmissionId,
      @RequestHeader("PayPal-Transmission-Sig") String PayPalTransmissionSig,
      @RequestHeader("PayPal-Transmission-Time") OffsetDateTime PayPalTransmissionTime,
      @RequestBody Event event,
      Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return checkoutValidatedWebhookFlow.run(
        PayPalAuthAlgo,
        PayPalCertUrl,
        PayPalTransmissionId,
        PayPalTransmissionSig,
        PayPalTransmissionTime,
        event,
        securityContext);
  }

  @GetMapping("getPizzaOrderSummary/{orderId}")
  @Operation(summary = "getPizzaOrderSummary", description = "")
  public OrderSummary getPizzaOrderSummary(
      @PathVariable("orderId") String orderId, Authentication authentication) {

    UserSecurityContext securityContext = (UserSecurityContext) authentication.getPrincipal();

    return orderSummaryFlow.run(orderId, securityContext);
  }
}
