package com.wizzdi.examples.model.config;

import com.wizzdi.examples.model.model.AppUser;
import java.util.Collection;
import java.util.Map;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.core.user.OAuth2User;

public class CustomOAuth2User implements OAuth2User {
  private final OAuth2User oAuth2User;
  private final AppUser appUser;

  public CustomOAuth2User(OAuth2User oAuth2User, AppUser appUser) {
    this.oAuth2User = oAuth2User;
    this.appUser = appUser;
  }

  public AppUser getAppUser() {
    return appUser;
  }

  @Override
  public Map<String, Object> getAttributes() {
    return oAuth2User.getAttributes();
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return oAuth2User.getAuthorities();
  }

  @Override
  public String getName() {
    return oAuth2User.getAttribute("name"); // Adjust according to provider
  }
}
