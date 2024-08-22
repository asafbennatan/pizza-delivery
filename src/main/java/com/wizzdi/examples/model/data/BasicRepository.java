package com.wizzdi.examples.model.data;

import com.wizzdi.examples.model.model.Basic;
import com.wizzdi.examples.model.model.Basic_;
import com.wizzdi.examples.model.request.BasicFilter;
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
public class BasicRepository {
  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  /**
   * @param basicFilter Object Used to List Basic
   * @param securityContext
   * @return List of Basic
   */
  public List<Basic> listAllBasics(BasicFilter basicFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Basic> q = cb.createQuery(Basic.class);
    Root<Basic> r = q.from(Basic.class);
    List<Predicate> preds = new ArrayList<>();
    addBasicPredicate(basicFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<Basic> query = em.createQuery(q);

    if (basicFilter.getPageSize() != null
        && basicFilter.getCurrentPage() != null
        && basicFilter.getPageSize() > 0
        && basicFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(basicFilter.getPageSize() * basicFilter.getCurrentPage())
          .setMaxResults(basicFilter.getPageSize());
    }

    return query.getResultList();
  }

  public <T extends Basic> void addBasicPredicate(
      BasicFilter basicFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    if (basicFilter.getUpdateDateStart() != null) {
      preds.add(
          cb.greaterThanOrEqualTo(r.get(Basic_.updateDate), basicFilter.getUpdateDateStart()));
    }
    if (basicFilter.getUpdateDateEnd() != null) {
      preds.add(cb.lessThanOrEqualTo(r.get(Basic_.updateDate), basicFilter.getUpdateDateEnd()));
    }

    if (basicFilter.getCreationDateStart() != null) {
      preds.add(
          cb.greaterThanOrEqualTo(r.get(Basic_.creationDate), basicFilter.getCreationDateStart()));
    }
    if (basicFilter.getCreationDateEnd() != null) {
      preds.add(cb.lessThanOrEqualTo(r.get(Basic_.creationDate), basicFilter.getCreationDateEnd()));
    }

    if (basicFilter.getName() != null && !basicFilter.getName().isEmpty()) {
      preds.add(r.get(Basic_.name).in(basicFilter.getName()));
    }

    if (basicFilter.getId() != null && !basicFilter.getId().isEmpty()) {
      preds.add(r.get(Basic_.id).in(basicFilter.getId()));
    }
  }

  /**
   * @param basicFilter Object Used to List Basic
   * @param securityContext
   * @return count of Basic
   */
  public Long countAllBasics(BasicFilter basicFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<Basic> r = q.from(Basic.class);
    List<Predicate> preds = new ArrayList<>();
    addBasicPredicate(basicFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends Basic, I> List<T> listByIds(
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

  public <T extends Basic, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends Basic, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends Basic, I> T getByIdOrNull(
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
