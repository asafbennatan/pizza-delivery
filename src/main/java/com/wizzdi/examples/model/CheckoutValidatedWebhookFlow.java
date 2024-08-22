package com.wizzdi.examples.model;

import com.wizzdi.examples.model.model.OrderStatus;
import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.paypal.webhooks.v1.PaypalWebhooksAPI;
import com.wizzdi.examples.model.paypal.webhooks.v1.request.Event;
import com.wizzdi.examples.model.paypal.webhooks.v1.request.VerifyWebhookSignature;
import com.wizzdi.examples.model.request.PizzaOrderFilter;
import com.wizzdi.examples.model.request.PizzaOrderUpdate;
import com.wizzdi.examples.model.security.UserSecurityContext;
import com.wizzdi.examples.model.service.PizzaOrderService;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Component;

@Component
public class CheckoutValidatedWebhookFlow {

  @Autowired private ClientRegistrationRepository clientRegistrationRepository;

  @Autowired private PizzaOrderService pizzaOrderService;

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
        paypalClient.verifywebhooksignaturepost(
            new VerifyWebhookSignature()
                .setCert_url(PayPalCertUrl)
                .setWebhook_event(body)
                .setAuth_algo(PayPalAuthAlgo)
                .setTransmission_id(PayPalTransmissionId)
                .setWebhook_id("My-WEBhookId")
                .setTransmission_sig(PayPalTransmissionSig)
                .setTransmission_time(PayPalTransmissionTime));

    if (result.getStatusCode().is2xxSuccessful()) {

      com.wizzdi.examples.model.paypal.webhooks.v1.response.VerifyWebhookSignatureResponse
          verifywebhooksignatureresponse = result.getBody();

      if (verifywebhooksignatureresponse.getVerification_status()
          == com.wizzdi.examples.model.paypal.webhooks.v1.response
              .VerifyWebhookSignatureResponseVerificationStatus.SUCCESS) {

        PizzaOrderFilter orderFilter = new PizzaOrderFilter().setId(new HashSet<>(Set.of()));

        PizzaOrder order =
            pizzaOrderService.listAllPizzaOrders(orderFilter, securityContext).stream()
                .findFirst()
                .orElse(null);

        PizzaOrderUpdate pizzaOrderUpdate =
            new PizzaOrderUpdate().setPizzaOrder(order).setOrderStatus(OrderStatus.STARTED);

        pizzaOrderService.updatePizzaOrder(pizzaOrderUpdate, securityContext);

        return new PaypalWebhookResponse().setSuccess(true);

      } else {

        return new PaypalWebhookResponse().setSuccess(false);
      }

    } else {

      return new PaypalWebhookResponse().setSuccess(false);
    }
  }
}
