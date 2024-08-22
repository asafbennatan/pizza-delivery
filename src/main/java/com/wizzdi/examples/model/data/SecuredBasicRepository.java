package com.wizzdi.examples.model.data;

import com.wizzdi.examples.model.model.SecuredBasic;
import com.wizzdi.examples.model.model.SecuredBasic_;
import com.wizzdi.examples.model.request.SecuredBasicFilter;
import com.wizzdi.examples.model.security.UserSecurityContext;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SecuredBasicRepository {
  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  @Autowired private BasicRepository basicRepository;

  /**
   * @param securedBasicFilter Object Used to List SecuredBasic
   * @param securityContext
   * @return List of SecuredBasic
   */
  public List<SecuredBasic> listAllSecuredBasics(
      SecuredBasicFilter securedBasicFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<SecuredBasic> q = cb.createQuery(SecuredBasic.class);
    Root<SecuredBasic> r = q.from(SecuredBasic.class);
    List<Predicate> preds = new ArrayList<>();
    addSecuredBasicPredicate(securedBasicFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<SecuredBasic> query = em.createQuery(q);

    if (securedBasicFilter.getPageSize() != null
        && securedBasicFilter.getCurrentPage() != null
        && securedBasicFilter.getPageSize() > 0
        && securedBasicFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(securedBasicFilter.getPageSize() * securedBasicFilter.getCurrentPage())
          .setMaxResults(securedBasicFilter.getPageSize());
    }

    return query.getResultList();
  }

  public <T extends SecuredBasic> void addSecuredBasicPredicate(
      SecuredBasicFilter securedBasicFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    basicRepository.addBasicPredicate(securedBasicFilter, cb, q, r, preds, securityContext);

    if (securityContext != null && !securityContext.isAdmin()) {
      preds.add(cb.equal(r.get(SecuredBasic_.creator), securityContext.getUser()));
    }
  }

  /**
   * @param securedBasicFilter Object Used to List SecuredBasic
   * @param securityContext
   * @return count of SecuredBasic
   */
  public Long countAllSecuredBasics(
      SecuredBasicFilter securedBasicFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<SecuredBasic> r = q.from(SecuredBasic.class);
    List<Predicate> preds = new ArrayList<>();
    addSecuredBasicPredicate(securedBasicFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends SecuredBasic, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<T> q = cb.createQuery(c);
    Root<T> r = q.from(c);
    List<Predicate> preds = new ArrayList<>();
    preds.add(r.get(idField).in(ids));

    if (securityContext != null && !securityContext.isAdmin()) {
      preds.add(cb.equal(r.get(SecuredBasic_.creator), securityContext.getUser()));
    }

    q.select(r).where(preds.toArray(new Predicate[0]));
    return em.createQuery(q).getResultList();
  }

  public <T extends SecuredBasic, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends SecuredBasic, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends SecuredBasic, I> T getByIdOrNull(
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
