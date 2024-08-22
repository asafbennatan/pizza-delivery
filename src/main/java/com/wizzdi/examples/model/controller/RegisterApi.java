package com.wizzdi.examples.model.controller;

import com.wizzdi.examples.model.model.AppUser;
import com.wizzdi.examples.model.request.AppUserCreate;
import com.wizzdi.examples.model.request.AppUserFilter;
import com.wizzdi.examples.model.security.Roles;
import com.wizzdi.examples.model.service.AppUser1Service;
import io.swagger.v3.oas.annotations.security.SecurityRequirements;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Tag(name = "RegisterApi")
@RestController
public class RegisterApi {

  private final AppUser1Service appUser1Service;

  public RegisterApi(AppUser1Service appUser1Service) {
    this.appUser1Service = appUser1Service;
  }

  @SecurityRequirements
  @PostMapping("register")
  public AppUser register(
      @RequestBody
          @org.springframework.validation.annotation.Validated(
              com.wizzdi.examples.model.validation.Create.class)
          AppUserCreate appUserCreate) {
    appUser1Service
        .listAllAppUsers(
            new AppUserFilter().setUsername(Collections.singleton(appUserCreate.getUsername())),
            null)
        .stream()
        .findAny()
        .ifPresent(
            f -> {
              throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "username already exists");
            });
    AppUser appUser =
        appUser1Service.createAppUser(appUserCreate.setRoles(Roles.User.name()), null);

    return appUser;
  }
}
