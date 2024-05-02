package com.wizzdi.examples.runtime.data;

import com.wizzdi.examples.runtime.model.AppUser;
import com.wizzdi.examples.runtime.model.AppUser_;
import com.wizzdi.examples.runtime.model.SecuredBasic;
import com.wizzdi.examples.runtime.model.SecuredBasic_;
import com.wizzdi.examples.runtime.request.AppUserFilter;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AppUserRepository {
  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  /**
   * @param appUserFilter Object Used to List AppUser
   * @param securityContext
   * @return List of AppUser
   */
  public List<AppUser> listAllAppUsers(
      AppUserFilter appUserFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<AppUser> q = cb.createQuery(AppUser.class);
    Root<AppUser> r = q.from(AppUser.class);
    List<Predicate> preds = new ArrayList<>();
    addAppUserPredicate(appUserFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<AppUser> query = em.createQuery(q);

    if (appUserFilter.getPageSize() != null
        && appUserFilter.getCurrentPage() != null
        && appUserFilter.getPageSize() > 0
        && appUserFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(appUserFilter.getPageSize() * appUserFilter.getCurrentPage())
          .setMaxResults(appUserFilter.getPageSize());
    }

    return query.getResultList();
  }

  public <T extends AppUser> void addAppUserPredicate(
      AppUserFilter appUserFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    if (appUserFilter.getFullAddress() != null && !appUserFilter.getFullAddress().isEmpty()) {
      preds.add(r.get(AppUser_.fullAddress).in(appUserFilter.getFullAddress()));
    }

    if (appUserFilter.getUsername() != null && !appUserFilter.getUsername().isEmpty()) {
      preds.add(r.get(AppUser_.username).in(appUserFilter.getUsername()));
    }

    if (appUserFilter.getCreatorSecuredBasicses() != null
        && !appUserFilter.getCreatorSecuredBasicses().isEmpty()) {
      Set<String> ids =
          appUserFilter.getCreatorSecuredBasicses().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, SecuredBasic> join = r.join(AppUser_.creatorSecuredBasics);
      preds.add(join.get(SecuredBasic_.id).in(ids));
    }

    if (appUserFilter.getId() != null && !appUserFilter.getId().isEmpty()) {
      preds.add(r.get(AppUser_.id).in(appUserFilter.getId()));
    }

    if (appUserFilter.getRoles() != null && !appUserFilter.getRoles().isEmpty()) {
      preds.add(r.get(AppUser_.roles).in(appUserFilter.getRoles()));
    }
  }

  /**
   * @param appUserFilter Object Used to List AppUser
   * @param securityContext
   * @return count of AppUser
   */
  public Long countAllAppUsers(AppUserFilter appUserFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<AppUser> r = q.from(AppUser.class);
    List<Predicate> preds = new ArrayList<>();
    addAppUserPredicate(appUserFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends AppUser, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(c);
    Root<T> r = q.from(c);
    List<Predicate> preds = new ArrayList<>();
    preds.add(r.get(idField).in(ids));

    q.select(r).where(preds.toArray(new Predicate[0]));
    return em.createQuery(q).getResultList();
  }

  public <T extends AppUser, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends AppUser, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends AppUser, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return listByIds(c, idField, Collections.singleton(id), securityContext).stream()
        .findFirst()
        .orElse(null);
  }

  @Transactional
  public <T> T merge(T base) {
    T updated = em.merge(base);
    applicationEventPublisher.publishEvent(updated);
    return updated;
  }

  @Transactional
  public void massMerge(List<?> toMerge) {
    for (Object o : toMerge) {
      java.lang.Object updated = em.merge(o);
      applicationEventPublisher.publishEvent(updated);
    }
  }
}
