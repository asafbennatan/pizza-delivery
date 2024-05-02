package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.AppInit;
import com.wizzdi.examples.runtime.model.Branch;
import com.wizzdi.examples.runtime.model.OrderStatus;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.request.LoginRequest;
import com.wizzdi.examples.runtime.request.PizzaOrderCreate;
import com.wizzdi.examples.runtime.request.PizzaOrderFilter;
import com.wizzdi.examples.runtime.request.PizzaOrderUpdate;
import com.wizzdi.examples.runtime.response.PaginationResponse;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = AppInit.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ActiveProfiles("test")
public class PizzaOrderControllerTest {

  private PizzaOrder testPizzaOrder;
  @Autowired private TestRestTemplate restTemplate;

  @Autowired private Branch branch;

  @BeforeAll
  private void init() {
    ResponseEntity<Object> authenticationResponse =
        this.restTemplate.postForEntity(
            "/login",
            new LoginRequest().setUsername("admin@flexicore.com").setPassword("admin"),
            Object.class);
    String authenticationKey =
        authenticationResponse.getHeaders().get(HttpHeaders.AUTHORIZATION).stream()
            .findFirst()
            .orElse(null);
    restTemplate
        .getRestTemplate()
        .setInterceptors(
            Collections.singletonList(
                (request, body, execution) -> {
                  request.getHeaders().add("Authorization", "Bearer " + authenticationKey);
                  return execution.execute(request, body);
                }));
  }

  @Test
  @Order(1)
  public void testPizzaOrderCreate() {
    PizzaOrderCreate request = new PizzaOrderCreate();

    request.setLat(10D);

    request.setBranchId(this.branch.getId());

    request.setOrderStatus(OrderStatus.DRAFT);

    request.setLon(10D);

    request.setOrderId("test-string");

    ResponseEntity<PizzaOrder> response =
        this.restTemplate.postForEntity("/PizzaOrder/createPizzaOrder", request, PizzaOrder.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testPizzaOrder = response.getBody();
    assertPizzaOrder(request, testPizzaOrder);
  }

  @Test
  @Order(2)
  public void testListAllPizzaOrders() {
    PizzaOrderFilter request = new PizzaOrderFilter();
    ParameterizedTypeReference<PaginationResponse<PizzaOrder>> t =
        new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<PizzaOrder>> response =
        this.restTemplate.exchange(
            "/PizzaOrder/getAllPizzaOrders", HttpMethod.POST, new HttpEntity<>(request), t);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<PizzaOrder> body = response.getBody();
    Assertions.assertNotNull(body);
    List<PizzaOrder> PizzaOrders = body.getList();
    Assertions.assertNotEquals(0, PizzaOrders.size());
    Assertions.assertTrue(
        PizzaOrders.stream().anyMatch(f -> f.getId().equals(testPizzaOrder.getId())));
  }

  public void assertPizzaOrder(PizzaOrderCreate request, PizzaOrder testPizzaOrder) {
    Assertions.assertNotNull(testPizzaOrder);

    if (request.getLat() != null) {
      Assertions.assertEquals(request.getLat(), testPizzaOrder.getLat());
    }

    if (request.getBranchId() != null) {

      Assertions.assertNotNull(testPizzaOrder.getBranch());
      Assertions.assertEquals(request.getBranchId(), testPizzaOrder.getBranch().getId());
    }

    if (request.getOrderStatus() != null) {
      Assertions.assertEquals(request.getOrderStatus(), testPizzaOrder.getOrderStatus());
    }

    if (request.getLon() != null) {
      Assertions.assertEquals(request.getLon(), testPizzaOrder.getLon());
    }

    if (request.getOrderId() != null) {
      Assertions.assertEquals(request.getOrderId(), testPizzaOrder.getOrderId());
    }
  }

  @Test
  @Order(3)
  public void testPizzaOrderUpdate() {
    PizzaOrderUpdate request = new PizzaOrderUpdate().setId(testPizzaOrder.getId());
    ResponseEntity<PizzaOrder> response =
        this.restTemplate.exchange(
            "/PizzaOrder/updatePizzaOrder",
            HttpMethod.PUT,
            new HttpEntity<>(request),
            PizzaOrder.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testPizzaOrder = response.getBody();
    assertPizzaOrder(request, testPizzaOrder);
  }
}
