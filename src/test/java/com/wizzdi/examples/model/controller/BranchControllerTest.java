package com.wizzdi.examples.model.controller;

import com.wizzdi.examples.model.AppInit;
import com.wizzdi.examples.model.model.Branch;
import com.wizzdi.examples.model.request.BranchCreate;
import com.wizzdi.examples.model.request.BranchFilter;
import com.wizzdi.examples.model.request.BranchUpdate;
import com.wizzdi.examples.model.request.LoginRequest;
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
public class BranchControllerTest {

  private Branch testBranch;
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
  public void testBranchCreate() {
    BranchCreate request = new BranchCreate();

    request.setFullAddress("test-string");

    request.setLat(10D);

    request.setLon(10D);

    ResponseEntity<Branch> response =
        this.restTemplate.postForEntity("/Branch/createBranch", request, Branch.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testBranch = response.getBody();
    assertBranch(request, testBranch);
  }

  @Test
  @Order(2)
  public void testListAllBranches() {
    BranchFilter request = new BranchFilter();
    ParameterizedTypeReference<PaginationResponse<Branch>> t =
        new ParameterizedTypeReference<>() {};

    ResponseEntity<PaginationResponse<Branch>> response =
        this.restTemplate.exchange(
            "/Branch/getAllBranches", HttpMethod.POST, new HttpEntity<>(request), t);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    PaginationResponse<Branch> body = response.getBody();
    Assertions.assertNotNull(body);
    List<Branch> Branches = body.getList();
    Assertions.assertNotEquals(0, Branches.size());
    Assertions.assertTrue(Branches.stream().anyMatch(f -> f.getId().equals(testBranch.getId())));
  }

  public void assertBranch(BranchCreate request, Branch testBranch) {
    Assertions.assertNotNull(testBranch);

    if (request.getFullAddress() != null) {
      Assertions.assertEquals(request.getFullAddress(), testBranch.getFullAddress());
    }

    if (request.getLat() != null) {
      Assertions.assertEquals(request.getLat(), testBranch.getLat());
    }

    if (request.getLon() != null) {
      Assertions.assertEquals(request.getLon(), testBranch.getLon());
    }
  }

  @Test
  @Order(3)
  public void testBranchUpdate() {
    BranchUpdate request = new BranchUpdate().setId(testBranch.getId());
    ResponseEntity<Branch> response =
        this.restTemplate.exchange(
            "/Branch/updateBranch", HttpMethod.PUT, new HttpEntity<>(request), Branch.class);
    Assertions.assertEquals(200, response.getStatusCodeValue());
    testBranch = response.getBody();
    assertBranch(request, testBranch);
  }
}
