package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.AppInit;
import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.model.PizzaToTopping;
import com.wizzdi.examples.runtime.model.Topping;
import com.wizzdi.examples.runtime.request.LoginRequest;
import com.wizzdi.examples.runtime.request.PizzaToToppingCreate;
import com.wizzdi.examples.runtime.request.PizzaToToppingFilter;
import com.wizzdi.examples.runtime.request.PizzaToToppingUpdate;
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
public class PizzaToToppingControllerTest {

  private PizzaToTopping testPizzaToTopping;
  @Autowired private TestRestTemplate restTemplate;

  @Autowired private Topping topping;

  @Autowired private Pizza pizza;

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
  public void testPizzaToToppingCreate() {
    PizzaToToppingCreate request = new PizzaToToppingCreate();

    request.setPizzaId(this.pizza.getId());

    request.setPizzaCoverage(10D);

    request.setToppingId(this.topping.getId());

    ResponseEntity<PizzaToTopping> response =
        this.restTemplate.postForEntity(
            "/PizzaToTopping/createPizzaToTopping", request, PizzaToTopping.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testPizzaToTopping = response.getBody();
    assertPizzaToTopping(request, testPizzaToTopping);
  }

  @Test
  @Order(2)
  public void testListAllPizzaToToppings() {
    PizzaToToppingFilter request = new PizzaToToppingFilter();
    ParameterizedTypeReference<PaginationResponse<PizzaToTopping>> t =
        new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<PizzaToTopping>> response =
        this.restTemplate.exchange(
            "/PizzaToTopping/getAllPizzaToToppings", HttpMethod.POST, new HttpEntity<>(request), t);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<PizzaToTopping> body = response.getBody();
    Assertions.assertNotNull(body);
    List<PizzaToTopping> PizzaToToppings = body.getList();
    Assertions.assertNotEquals(0, PizzaToToppings.size());
    Assertions.assertTrue(
        PizzaToToppings.stream().anyMatch(f -> f.getId().equals(testPizzaToTopping.getId())));
  }

  public void assertPizzaToTopping(
      PizzaToToppingCreate request, PizzaToTopping testPizzaToTopping) {
    Assertions.assertNotNull(testPizzaToTopping);

    if (request.getPizzaId() != null) {

      Assertions.assertNotNull(testPizzaToTopping.getPizza());
      Assertions.assertEquals(request.getPizzaId(), testPizzaToTopping.getPizza().getId());
    }

    if (request.getPizzaCoverage() != null) {
      Assertions.assertEquals(request.getPizzaCoverage(), testPizzaToTopping.getPizzaCoverage());
    }

    if (request.getToppingId() != null) {

      Assertions.assertNotNull(testPizzaToTopping.getTopping());
      Assertions.assertEquals(request.getToppingId(), testPizzaToTopping.getTopping().getId());
    }
  }

  @Test
  @Order(3)
  public void testPizzaToToppingUpdate() {
    PizzaToToppingUpdate request = new PizzaToToppingUpdate().setId(testPizzaToTopping.getId());
    ResponseEntity<PizzaToTopping> response =
        this.restTemplate.exchange(
            "/PizzaToTopping/updatePizzaToTopping",
            HttpMethod.PUT,
            new HttpEntity<>(request),
            PizzaToTopping.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testPizzaToTopping = response.getBody();
    assertPizzaToTopping(request, testPizzaToTopping);
  }
}
