package com.wizzdi.examples.runtime.security;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<com.wizzdi.examples.runtime.model.AppUser> {
  @Override
  public Optional<com.wizzdi.examples.runtime.model.AppUser> getCurrentAuditor() {
    Authentication securityContext = SecurityContextHolder.getContext().getAuthentication();
    return Optional.ofNullable(securityContext)
        .map(f -> (com.wizzdi.examples.runtime.security.UserSecurityContext) f.getPrincipal())
        .map(f -> f.getUser());
  }
}
