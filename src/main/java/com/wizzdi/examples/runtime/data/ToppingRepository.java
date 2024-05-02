package com.wizzdi.examples.runtime.data;

import com.wizzdi.examples.runtime.model.PizzaToTopping;
import com.wizzdi.examples.runtime.model.PizzaToTopping_;
import com.wizzdi.examples.runtime.model.Topping;
import com.wizzdi.examples.runtime.model.Topping_;
import com.wizzdi.examples.runtime.request.ToppingFilter;
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
public class ToppingRepository {
  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  @Autowired private BasicRepository basicRepository;

  /**
   * @param toppingFilter Object Used to List Topping
   * @param securityContext
   * @return List of Topping
   */
  public List<Topping> listAllToppings(
      ToppingFilter toppingFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Topping> q = cb.createQuery(Topping.class);
    Root<Topping> r = q.from(Topping.class);
    List<Predicate> preds = new ArrayList<>();
    addToppingPredicate(toppingFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<Topping> query = em.createQuery(q);

    if (toppingFilter.getPageSize() != null
        && toppingFilter.getCurrentPage() != null
        && toppingFilter.getPageSize() > 0
        && toppingFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(toppingFilter.getPageSize() * toppingFilter.getCurrentPage())
          .setMaxResults(toppingFilter.getPageSize());
    }

    return query.getResultList();
  }

  public <T extends Topping> void addToppingPredicate(
      ToppingFilter toppingFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    basicRepository.addBasicPredicate(toppingFilter, cb, q, r, preds, securityContext);

    if (toppingFilter.getToppingToppingToPizzases() != null
        && !toppingFilter.getToppingToppingToPizzases().isEmpty()) {
      Set<String> ids =
          toppingFilter.getToppingToppingToPizzases().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, PizzaToTopping> join = r.join(Topping_.toppingToppingToPizzas);
      preds.add(join.get(PizzaToTopping_.id).in(ids));
    }

    if (toppingFilter.getPriceStart() != null) {
      preds.add(cb.greaterThanOrEqualTo(r.get(Topping_.price), toppingFilter.getPriceStart()));
    }
    if (toppingFilter.getPriceEnd() != null) {
      preds.add(cb.lessThanOrEqualTo(r.get(Topping_.price), toppingFilter.getPriceEnd()));
    }
  }

  /**
   * @param toppingFilter Object Used to List Topping
   * @param securityContext
   * @return count of Topping
   */
  public Long countAllToppings(ToppingFilter toppingFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<Topping> r = q.from(Topping.class);
    List<Predicate> preds = new ArrayList<>();
    addToppingPredicate(toppingFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends Topping, I> List<T> listByIds(
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

  public <T extends Topping, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends Topping, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends Topping, I> T getByIdOrNull(
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
