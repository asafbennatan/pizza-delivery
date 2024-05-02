package com.wizzdi.examples.runtime.config;

import com.wizzdi.examples.runtime.model.AppUser;
import com.wizzdi.examples.runtime.request.AppUserCreate;
import com.wizzdi.examples.runtime.request.AppUserFilter;
import com.wizzdi.examples.runtime.service.AppUserService;
import java.util.Collections;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

  private final AppUserService appUserService;

  public CustomOAuth2UserService(AppUserService appUserService) {
    this.appUserService = appUserService;
  }

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
    OAuth2User oAuth2User = super.loadUser(userRequest);
    // Handle custom logic here, like saving the user to the database
    AppUser appUser =
        appUserService
            .listAllAppUsers(
                new AppUserFilter().setUsername(Collections.singleton(oAuth2User.getName())), null)
            .stream()
            .findFirst()
            .orElseGet(() -> registerUser(oAuth2User));

    return new CustomOAuth2User(oAuth2User, appUser);
  }

  private AppUser registerUser(OAuth2User oAuth2User) {
    AppUser appUser =
        appUserService.createAppUser(
            new AppUserCreate()
                .setUsername(oAuth2User.getName())
                .setRoles(com.wizzdi.examples.runtime.security.Roles.User.name()),
            null);

    return appUser;
  }
}
