package com.wizzdi.examples.runtime.data;

import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.model.PizzaOrder_;
import com.wizzdi.examples.runtime.model.PizzaToTopping;
import com.wizzdi.examples.runtime.model.PizzaToTopping_;
import com.wizzdi.examples.runtime.model.Pizza_;
import com.wizzdi.examples.runtime.request.PizzaFilter;
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
public class PizzaRepository {
  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  @Autowired private SecuredBasicRepository securedBasicRepository;

  /**
   * @param pizzaFilter Object Used to List Pizza
   * @param securityContext
   * @return List of Pizza
   */
  public List<Pizza> listAllPizzas(PizzaFilter pizzaFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Pizza> q = cb.createQuery(Pizza.class);
    Root<Pizza> r = q.from(Pizza.class);
    List<Predicate> preds = new ArrayList<>();
    addPizzaPredicate(pizzaFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<Pizza> query = em.createQuery(q);

    if (pizzaFilter.getPageSize() != null
        && pizzaFilter.getCurrentPage() != null
        && pizzaFilter.getPageSize() > 0
        && pizzaFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(pizzaFilter.getPageSize() * pizzaFilter.getCurrentPage())
          .setMaxResults(pizzaFilter.getPageSize());
    }

    return query.getResultList();
  }

  public <T extends Pizza> void addPizzaPredicate(
      PizzaFilter pizzaFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    securedBasicRepository.addSecuredBasicPredicate(pizzaFilter, cb, q, r, preds, securityContext);

    if (pizzaFilter.getPizzaOrders() != null && !pizzaFilter.getPizzaOrders().isEmpty()) {
      Set<String> ids =
          pizzaFilter.getPizzaOrders().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, PizzaOrder> join = r.join(Pizza_.pizzaOrder);
      preds.add(join.get(PizzaOrder_.id).in(ids));
    }

    if (pizzaFilter.getPizzaToppingToPizzases() != null
        && !pizzaFilter.getPizzaToppingToPizzases().isEmpty()) {
      Set<String> ids =
          pizzaFilter.getPizzaToppingToPizzases().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, PizzaToTopping> join = r.join(Pizza_.pizzaToppingToPizzas);
      preds.add(join.get(PizzaToTopping_.id).in(ids));
    }
  }

  /**
   * @param pizzaFilter Object Used to List Pizza
   * @param securityContext
   * @return count of Pizza
   */
  public Long countAllPizzas(PizzaFilter pizzaFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<Pizza> r = q.from(Pizza.class);
    List<Predicate> preds = new ArrayList<>();
    addPizzaPredicate(pizzaFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends Pizza, I> List<T> listByIds(
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

  public <T extends Pizza, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends Pizza, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends Pizza, I> T getByIdOrNull(
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
