package com.wizzdi.examples.model.security;

import com.wizzdi.examples.model.model.AppUser;
import com.wizzdi.examples.model.request.AppUserCreate;
import com.wizzdi.examples.model.request.AppUserFilter;
import com.wizzdi.examples.model.service.AppUser1Service;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class AdminConfig {

  @Autowired @Lazy private AppUser1Service appUser1Service;

  @Value("${admin.username:admin@Pizza Delivery App.com}")
  private String username;

  @Value("${admin.password:#{T(java.util.UUID).randomUUID().toString()}}")
  private String password;

  @Bean
  public AdminHolder admin() {
    AppUser appUser =
        appUser1Service
            .listAllAppUsers(new AppUserFilter().setUsername(Collections.singleton(username)), null)
            .stream()
            .findFirst()
            .orElseGet(
                () ->
                    appUser1Service.createAppUser(
                        new AppUserCreate()
                            .setUsername(username)
                            .setPassword(password)
                            .setRoles(Roles.Admin.name()),
                        null));
    return new AdminHolder(appUser);
  }

  public record AdminHolder(AppUser admin) {}
}
