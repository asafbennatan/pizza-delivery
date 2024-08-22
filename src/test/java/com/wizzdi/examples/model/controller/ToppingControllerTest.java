package com.wizzdi.examples.model.controller;

import com.wizzdi.examples.model.AppInit;
import com.wizzdi.examples.model.model.Topping;
import com.wizzdi.examples.model.request.LoginRequest;
import com.wizzdi.examples.model.request.ToppingCreate;
import com.wizzdi.examples.model.request.ToppingFilter;
import com.wizzdi.examples.model.request.ToppingUpdate;
import com.wizzdi.examples.model.response.PaginationResponse;
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
public class ToppingControllerTest {

  private Topping testTopping;
  @Autowired private TestRestTemplate restTemplate;

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
  public void testToppingCreate() {
    ToppingCreate request = new ToppingCreate();

    request.setPrice(10D);

    ResponseEntity<Topping> response =
        this.restTemplate.postForEntity("/Topping/createTopping", request, Topping.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testTopping = response.getBody();
    assertTopping(request, testTopping);
  }

  @Test
  @Order(2)
  public void testListAllToppings() {
    ToppingFilter request = new ToppingFilter();
    ParameterizedTypeReference<PaginationResponse<Topping>> t =
        new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<Topping>> response =
        this.restTemplate.exchange(
            "/Topping/getAllToppings", HttpMethod.POST, new HttpEntity<>(request), t);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<Topping> body = response.getBody();
    Assertions.assertNotNull(body);
    List<Topping> Toppings = body.getList();
    Assertions.assertNotEquals(0, Toppings.size());
    Assertions.assertTrue(Toppings.stream().anyMatch(f -> f.getId().equals(testTopping.getId())));
  }

  public void assertTopping(ToppingCreate request, Topping testTopping) {
    Assertions.assertNotNull(testTopping);

    if (request.getPrice() != null) {
      Assertions.assertEquals(request.getPrice(), testTopping.getPrice());
    }
  }

  @Test
  @Order(3)
  public void testToppingUpdate() {
    ToppingUpdate request = new ToppingUpdate().setId(testTopping.getId());
    ResponseEntity<Topping> response =
        this.restTemplate.exchange(
            "/Topping/updateTopping", HttpMethod.PUT, new HttpEntity<>(request), Topping.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testTopping = response.getBody();
    assertTopping(request, testTopping);
  }
}
