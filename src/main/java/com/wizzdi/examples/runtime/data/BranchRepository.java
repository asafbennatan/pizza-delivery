package com.wizzdi.examples.runtime.data;

import com.wizzdi.examples.runtime.model.Branch;
import com.wizzdi.examples.runtime.model.Branch_;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.model.PizzaOrder_;
import com.wizzdi.examples.runtime.request.BranchFilter;
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
public class BranchRepository {
  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  @Autowired private BasicRepository basicRepository;

  /**
   * @param branchFilter Object Used to List Branch
   * @param securityContext
   * @return List of Branch
   */
  public List<Branch> listAllBranches(
      BranchFilter branchFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Branch> q = cb.createQuery(Branch.class);
    Root<Branch> r = q.from(Branch.class);
    List<Predicate> preds = new ArrayList<>();
    addBranchPredicate(branchFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<Branch> query = em.createQuery(q);

    if (branchFilter.getPageSize() != null
        && branchFilter.getCurrentPage() != null
        && branchFilter.getPageSize() > 0
        && branchFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(branchFilter.getPageSize() * branchFilter.getCurrentPage())
          .setMaxResults(branchFilter.getPageSize());
    }

    return query.getResultList();
  }

  public <T extends Branch> void addBranchPredicate(
      BranchFilter branchFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    basicRepository.addBasicPredicate(branchFilter, cb, q, r, preds, securityContext);

    if (branchFilter.getFullAddress() != null && !branchFilter.getFullAddress().isEmpty()) {
      preds.add(r.get(Branch_.fullAddress).in(branchFilter.getFullAddress()));
    }

    if (branchFilter.getLatStart() != null) {
      preds.add(cb.greaterThanOrEqualTo(r.get(Branch_.lat), branchFilter.getLatStart()));
    }
    if (branchFilter.getLatEnd() != null) {
      preds.add(cb.lessThanOrEqualTo(r.get(Branch_.lat), branchFilter.getLatEnd()));
    }

    if (branchFilter.getBranchPizzaOrderses() != null
        && !branchFilter.getBranchPizzaOrderses().isEmpty()) {
      Set<String> ids =
          branchFilter.getBranchPizzaOrderses().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, PizzaOrder> join = r.join(Branch_.branchPizzaOrders);
      preds.add(join.get(PizzaOrder_.id).in(ids));
    }

    if (branchFilter.getLonStart() != null) {
      preds.add(cb.greaterThanOrEqualTo(r.get(Branch_.lon), branchFilter.getLonStart()));
    }
    if (branchFilter.getLonEnd() != null) {
      preds.add(cb.lessThanOrEqualTo(r.get(Branch_.lon), branchFilter.getLonEnd()));
    }
  }

  /**
   * @param branchFilter Object Used to List Branch
   * @param securityContext
   * @return count of Branch
   */
  public Long countAllBranches(BranchFilter branchFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<Branch> r = q.from(Branch.class);
    List<Predicate> preds = new ArrayList<>();
    addBranchPredicate(branchFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends Branch, I> List<T> listByIds(
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

  public <T extends Branch, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends Branch, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends Branch, I> T getByIdOrNull(
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
