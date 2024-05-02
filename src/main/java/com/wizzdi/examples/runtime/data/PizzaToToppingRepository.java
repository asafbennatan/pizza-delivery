package com.wizzdi.examples.runtime.data;

import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.model.PizzaToTopping;
import com.wizzdi.examples.runtime.model.PizzaToTopping_;
import com.wizzdi.examples.runtime.model.Pizza_;
import com.wizzdi.examples.runtime.model.Topping;
import com.wizzdi.examples.runtime.model.Topping_;
import com.wizzdi.examples.runtime.request.PizzaToToppingFilter;
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
public class PizzaToToppingRepository {
  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  /**
   * @param pizzaToToppingFilter Object Used to List PizzaToTopping
   * @param securityContext
   * @return List of PizzaToTopping
   */
  public List<PizzaToTopping> listAllPizzaToToppings(
      PizzaToToppingFilter pizzaToToppingFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<PizzaToTopping> q = cb.createQuery(PizzaToTopping.class);
    Root<PizzaToTopping> r = q.from(PizzaToTopping.class);
    List<Predicate> preds = new ArrayList<>();
    addPizzaToToppingPredicate(pizzaToToppingFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<PizzaToTopping> query = em.createQuery(q);

    if (pizzaToToppingFilter.getPageSize() != null
        && pizzaToToppingFilter.getCurrentPage() != null
        && pizzaToToppingFilter.getPageSize() > 0
        && pizzaToToppingFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(
              pizzaToToppingFilter.getPageSize() * pizzaToToppingFilter.getCurrentPage())
          .setMaxResults(pizzaToToppingFilter.getPageSize());
    }

    return query.getResultList();
  }

  public <T extends PizzaToTopping> void addPizzaToToppingPredicate(
      PizzaToToppingFilter pizzaToToppingFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    if (pizzaToToppingFilter.getPizzas() != null && !pizzaToToppingFilter.getPizzas().isEmpty()) {
      Set<String> ids =
          pizzaToToppingFilter.getPizzas().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, Pizza> join = r.join(PizzaToTopping_.pizza);
      preds.add(join.get(Pizza_.id).in(ids));
    }

    if (pizzaToToppingFilter.getPizzaCoverageStart() != null) {
      preds.add(
          cb.greaterThanOrEqualTo(
              r.get(PizzaToTopping_.pizzaCoverage), pizzaToToppingFilter.getPizzaCoverageStart()));
    }
    if (pizzaToToppingFilter.getPizzaCoverageEnd() != null) {
      preds.add(
          cb.lessThanOrEqualTo(
              r.get(PizzaToTopping_.pizzaCoverage), pizzaToToppingFilter.getPizzaCoverageEnd()));
    }

    if (pizzaToToppingFilter.getToppings() != null
        && !pizzaToToppingFilter.getToppings().isEmpty()) {
      Set<String> ids =
          pizzaToToppingFilter.getToppings().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, Topping> join = r.join(PizzaToTopping_.topping);
      preds.add(join.get(Topping_.id).in(ids));
    }

    if (pizzaToToppingFilter.getId() != null && !pizzaToToppingFilter.getId().isEmpty()) {
      preds.add(r.get(PizzaToTopping_.id).in(pizzaToToppingFilter.getId()));
    }
  }

  /**
   * @param pizzaToToppingFilter Object Used to List PizzaToTopping
   * @param securityContext
   * @return count of PizzaToTopping
   */
  public Long countAllPizzaToToppings(
      PizzaToToppingFilter pizzaToToppingFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<PizzaToTopping> r = q.from(PizzaToTopping.class);
    List<Predicate> preds = new ArrayList<>();
    addPizzaToToppingPredicate(pizzaToToppingFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends PizzaToTopping, I> List<T> listByIds(
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

  public <T extends PizzaToTopping, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends PizzaToTopping, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends PizzaToTopping, I> T getByIdOrNull(
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
