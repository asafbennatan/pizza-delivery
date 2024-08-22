package com.wizzdi.examples.model.security;

import static java.lang.String.format;

import com.wizzdi.examples.model.request.AppUserFilter;
import com.wizzdi.examples.model.service.AppUser1Service;
import java.util.Collections;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class AppUserDetailsServiceImpl implements UserDetailsService {

  private final AppUser1Service appUser1Service;

  public AppUserDetailsServiceImpl(AppUser1Service appUser1Service) {
    this.appUser1Service = appUser1Service;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return appUser1Service
        .listAllAppUsers(new AppUserFilter().setUsername(Collections.singleton(username)), null)
        .stream()
        .findFirst()
        .map(f -> new UserSecurityContext(f))
        .orElseThrow(() -> new UsernameNotFoundException(format("User: %s, not found", username)));
  }
}
