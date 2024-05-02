package com.wizzdi.examples.runtime;

import com.wizzdi.examples.runtime.api.PaypalWebhooksAPI;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.paypal.webhooks.v1.request.Event;
import com.wizzdi.examples.runtime.paypal.webhooks.v1.request.VerifyWebhookSignature;
import com.wizzdi.examples.runtime.request.PizzaOrderFilter;
import com.wizzdi.examples.runtime.request.PizzaOrderUpdate;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import com.wizzdi.examples.runtime.service.PizzaOrderService;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Component;

@Component
public class CheckoutValidatedWebhookFlow {

  @Autowired private PizzaOrderService pizzaOrderService;

  @Autowired private ClientRegistrationRepository clientRegistrationRepository;

  @Autowired private OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

  public PaypalWebhookResponse run(
      String PayPalAuthAlgo,
      String PayPalCertUrl,
      String PayPalTransmissionId,
      String PayPalTransmissionSig,
      OffsetDateTime PayPalTransmissionTime,
      Event body,
      UserSecurityContext securityContext) {

    PaypalWebhooksAPI paypalClient =
        new PaypalWebhooksAPI(oAuth2AuthorizedClientManager, clientRegistrationRepository);

    var result =
        Optional.of(
                paypalClient.verifywebhooksignaturepost(
                    new VerifyWebhookSignature()
                        .setAuth_algo(PayPalAuthAlgo)
                        .setCert_url(PayPalCertUrl)
                        .setTransmission_id(PayPalTransmissionId)
                        .setTransmission_sig(PayPalTransmissionSig)
                        .setTransmission_time(PayPalTransmissionTime)
                        .setWebhook_id("MY-WEBhookId")
                        .setWebhook_event(body)))
            .map(f -> f.getBody())
            .orElseThrow(() -> new RuntimeException("No response from external api"));

    if (result.getVerification_status()
        == com.wizzdi.examples.runtime.paypal.webhooks.v1.response
            .VerifyWebhookSignatureResponseVerificationStatus.SUCCESS) {

      PizzaOrderFilter orderFilter =
          new PizzaOrderFilter().setId(new HashSet<>(Set.of(body.getResource().get("custom_id"))));

      PizzaOrder order =
          pizzaOrderService.listAllPizzaOrders(orderFilter, securityContext).stream()
              .findFirst()
              .orElse(null);

      PizzaOrderUpdate pizzaOrderUpdate =
          new PizzaOrderUpdate()
              .setPizzaOrder(order)
              .setOrderStatus(com.wizzdi.examples.runtime.model.OrderStatus.STARTED);
      pizzaOrderService.updatePizzaOrder(pizzaOrderUpdate, securityContext);

      return new PaypalWebhookResponse().setSuccess(true);

    } else {

      return new PaypalWebhookResponse().setSuccess(false);
    }
  }
}
