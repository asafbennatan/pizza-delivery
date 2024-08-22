package com.wizzdi.examples.model.security;

import java.util.Optional;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuditorAwareImpl implements AuditorAware<com.wizzdi.examples.model.model.AppUser> {
  @Override
  public Optional<com.wizzdi.examples.model.model.AppUser> getCurrentAuditor() {
    Authentication securityContext = SecurityContextHolder.getContext().getAuthentication();
    return Optional.ofNullable(securityContext)
        .map(f -> (com.wizzdi.examples.model.security.UserSecurityContext) f.getPrincipal())
        .map(f -> f.getUser());
  }
}
