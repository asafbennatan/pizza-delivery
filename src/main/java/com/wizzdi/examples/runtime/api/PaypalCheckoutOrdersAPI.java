package com.wizzdi.examples.runtime.api;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.wizzdi.examples.runtime.api.config.OAuthClientCredentialsRestTemplateInterceptor;
import com.wizzdi.examples.runtime.api.request.OrderRequest;
import com.wizzdi.examples.runtime.api.response.Order;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

public class PaypalCheckoutOrdersAPI {

  private static final String DEFAULT_BASE_PATH = "https://api-m.sandbox.paypal.com";

  private static final Logger logger = LoggerFactory.getLogger(PaypalCheckoutOrdersAPI.class);

  private static final ObjectMapper objectMapper =
      new ObjectMapper()
          .setSerializationInclusion(JsonInclude.Include.NON_NULL)
          .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
          .registerModule(new JavaTimeModule());

  private String basePath = DEFAULT_BASE_PATH;
  private final RestTemplate restTemplate;

  public PaypalCheckoutOrdersAPI(
      OAuth2AuthorizedClientManager authorizedClientManager,
      ClientRegistrationRepository clientRegistrationRepository) {
    this.restTemplate = getRestTemplate(authorizedClientManager, clientRegistrationRepository);
  }

  public <T extends PaypalCheckoutOrdersAPI> T setBasePath(String basePath) {
    this.basePath = basePath;
    restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(basePath));

    return (T) this;
  }

  private RestTemplate getRestTemplate(
      OAuth2AuthorizedClientManager authorizedClientManager,
      ClientRegistrationRepository clientRegistrationRepository) {
    var clientRegistration =
        clientRegistrationRepository.findByRegistrationId(getClass().getSimpleName());
    return new RestTemplateBuilder()
        .additionalInterceptors(
            new OAuthClientCredentialsRestTemplateInterceptor(
                authorizedClientManager, clientRegistration))
        .uriTemplateHandler(new DefaultUriBuilderFactory(DEFAULT_BASE_PATH))
        .additionalMessageConverters(
            new MappingJackson2HttpMessageConverter(objectMapper), new FormHttpMessageConverter())
        .build();
  }

  public ResponseEntity<Order> orderscreate(
      OrderRequest orderRequest,
      String payPalRequestId,
      String payPalPartnerAttributionId,
      String payPalClientMetadataId,
      String prefer,
      String contentType) {
    Map<String, Object> uriParameters = new HashMap<>();
    HttpHeaders headers = new HttpHeaders();
    HttpMethod httpMethod = HttpMethod.POST;
    String path = "/v2/checkout/orders";

    headers.setContentType(MediaType.valueOf("application/json"));

    if (payPalRequestId != null) {
      headers.add("PayPalRequestId", payPalRequestId + "");
    }

    if (payPalPartnerAttributionId != null) {
      headers.add("PayPalPartnerAttributionId", payPalPartnerAttributionId + "");
    }

    if (payPalClientMetadataId != null) {
      headers.add("PayPalClientMetadataId", payPalClientMetadataId + "");
    }

    if (prefer != null) {
      headers.add("Prefer", prefer + "");
    }

    if (contentType != null) {
      headers.add("ContentType", contentType + "");
    }

    final UriComponentsBuilder builder =
        UriComponentsBuilder.fromHttpUrl(basePath).path(path).uriVariables(uriParameters);

    HttpEntity<OrderRequest> entity = new HttpEntity<>(orderRequest, headers);

    ParameterizedTypeReference<Order> parameterizedTypeReference =
        new ParameterizedTypeReference<>() {};
    return restTemplate.exchange(
        builder.toUriString(), httpMethod, entity, parameterizedTypeReference);
  }
}
