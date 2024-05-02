package com.wizzdi.examples.runtime.controller;

import com.wizzdi.examples.runtime.AppInit;
import com.wizzdi.examples.runtime.model.SecuredBasic;
import com.wizzdi.examples.runtime.request.LoginRequest;
import com.wizzdi.examples.runtime.request.SecuredBasicCreate;
import com.wizzdi.examples.runtime.request.SecuredBasicFilter;
import com.wizzdi.examples.runtime.request.SecuredBasicUpdate;
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
public class SecuredBasicControllerTest {

  private SecuredBasic testSecuredBasic;
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
  public void testSecuredBasicCreate() {
    SecuredBasicCreate request = new SecuredBasicCreate();

    ResponseEntity<SecuredBasic> response =
        this.restTemplate.postForEntity(
            "/SecuredBasic/createSecuredBasic", request, SecuredBasic.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testSecuredBasic = response.getBody();
    assertSecuredBasic(request, testSecuredBasic);
  }

  @Test
  @Order(2)
  public void testListAllSecuredBasics() {
    SecuredBasicFilter request = new SecuredBasicFilter();
    ParameterizedTypeReference<PaginationResponse<SecuredBasic>> t =
        new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<SecuredBasic>> response =
        this.restTemplate.exchange(
            "/SecuredBasic/getAllSecuredBasics", HttpMethod.POST, new HttpEntity<>(request), t);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<SecuredBasic> body = response.getBody();
    Assertions.assertNotNull(body);
    List<SecuredBasic> SecuredBasics = body.getList();
    Assertions.assertNotEquals(0, SecuredBasics.size());
    Assertions.assertTrue(
        SecuredBasics.stream().anyMatch(f -> f.getId().equals(testSecuredBasic.getId())));
  }

  public void assertSecuredBasic(SecuredBasicCreate request, SecuredBasic testSecuredBasic) {
    Assertions.assertNotNull(testSecuredBasic);
  }

  @Test
  @Order(3)
  public void testSecuredBasicUpdate() {
    SecuredBasicUpdate request = new SecuredBasicUpdate().setId(testSecuredBasic.getId());
    ResponseEntity<SecuredBasic> response =
        this.restTemplate.exchange(
            "/SecuredBasic/updateSecuredBasic",
            HttpMethod.PUT,
            new HttpEntity<>(request),
            SecuredBasic.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testSecuredBasic = response.getBody();
    assertSecuredBasic(request, testSecuredBasic);
  }
}
