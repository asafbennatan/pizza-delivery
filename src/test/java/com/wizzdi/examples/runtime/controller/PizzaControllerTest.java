package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.AppInit;
import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.request.LoginRequest;
import com.wizzdi.examples.runtime.request.PizzaCreate;
import com.wizzdi.examples.runtime.request.PizzaFilter;
import com.wizzdi.examples.runtime.request.PizzaUpdate;
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
public class PizzaControllerTest {

  private Pizza testPizza;
  @Autowired private TestRestTemplate restTemplate;

  @Autowired private PizzaOrder pizzaOrder;

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
  public void testPizzaCreate() {
    PizzaCreate request = new PizzaCreate();

    request.setPizzaOrderId(this.pizzaOrder.getId());

    ResponseEntity<Pizza> response =
        this.restTemplate.postForEntity("/Pizza/createPizza", request, Pizza.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testPizza = response.getBody();
    assertPizza(request, testPizza);
  }

  @Test
  @Order(2)
  public void testListAllPizzas() {
    PizzaFilter request = new PizzaFilter();
    ParameterizedTypeReference<PaginationResponse<Pizza>> t = new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<Pizza>> response =
        this.restTemplate.exchange(
            "/Pizza/getAllPizzas", HttpMethod.POST, new HttpEntity<>(request), t);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<Pizza> body = response.getBody();
    Assertions.assertNotNull(body);
    List<Pizza> Pizzas = body.getList();
    Assertions.assertNotEquals(0, Pizzas.size());
    Assertions.assertTrue(Pizzas.stream().anyMatch(f -> f.getId().equals(testPizza.getId())));
  }

  public void assertPizza(PizzaCreate request, Pizza testPizza) {
    Assertions.assertNotNull(testPizza);

    if (request.getPizzaOrderId() != null) {

      Assertions.assertNotNull(testPizza.getPizzaOrder());
      Assertions.assertEquals(request.getPizzaOrderId(), testPizza.getPizzaOrder().getId());
    }
  }

  @Test
  @Order(3)
  public void testPizzaUpdate() {
    PizzaUpdate request = new PizzaUpdate().setId(testPizza.getId());
    ResponseEntity<Pizza> response =
        this.restTemplate.exchange(
            "/Pizza/updatePizza", HttpMethod.PUT, new HttpEntity<>(request), Pizza.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testPizza = response.getBody();
    assertPizza(request, testPizza);
  }
}
