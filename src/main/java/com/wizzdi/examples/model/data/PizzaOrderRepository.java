package com.wizzdi.examples.model.data;

import com.wizzdi.examples.model.model.Branch;
import com.wizzdi.examples.model.model.Branch_;
import com.wizzdi.examples.model.model.Pizza;
import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.model.PizzaOrder_;
import com.wizzdi.examples.model.model.Pizza_;
import com.wizzdi.examples.model.request.PizzaOrderFilter;
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
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class PizzaOrderRepository {
  @PersistenceContext private EntityManager em;

  @Autowired private ApplicationEventPublisher applicationEventPublisher;

  @Autowired private SecuredBasicRepository securedBasicRepository;

  /**
   * @param pizzaOrderFilter Object Used to List PizzaOrder
   * @param securityContext
   * @return List of PizzaOrder
   */
  public List<PizzaOrder> listAllPizzaOrders(
      PizzaOrderFilter pizzaOrderFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<PizzaOrder> q = cb.createQuery(PizzaOrder.class);
    Root<PizzaOrder> r = q.from(PizzaOrder.class);
    List<Predicate> preds = new ArrayList<>();
    addPizzaOrderPredicate(pizzaOrderFilter, cb, q, r, preds, securityContext);
    q.select(r).where(preds.toArray(new Predicate[0]));
    TypedQuery<PizzaOrder> query = em.createQuery(q);

    if (pizzaOrderFilter.getPageSize() != null
        && pizzaOrderFilter.getCurrentPage() != null
        && pizzaOrderFilter.getPageSize() > 0
        && pizzaOrderFilter.getCurrentPage() > -1) {
      query
          .setFirstResult(pizzaOrderFilter.getPageSize() * pizzaOrderFilter.getCurrentPage())
          .setMaxResults(pizzaOrderFilter.getPageSize());
    }

    return query.getResultList();
  }

  public <T extends PizzaOrder> void addPizzaOrderPredicate(
      PizzaOrderFilter pizzaOrderFilter,
      CriteriaBuilder cb,
      CommonAbstractCriteria q,
      From<?, T> r,
      List<Predicate> preds,
      UserSecurityContext securityContext) {

    securedBasicRepository.addSecuredBasicPredicate(
        pizzaOrderFilter, cb, q, r, preds, securityContext);

    if (pizzaOrderFilter.getLatStart() != null) {
      preds.add(cb.greaterThanOrEqualTo(r.get(PizzaOrder_.lat), pizzaOrderFilter.getLatStart()));
    }
    if (pizzaOrderFilter.getLatEnd() != null) {
      preds.add(cb.lessThanOrEqualTo(r.get(PizzaOrder_.lat), pizzaOrderFilter.getLatEnd()));
    }

    if (pizzaOrderFilter.getBranches() != null && !pizzaOrderFilter.getBranches().isEmpty()) {
      Set<String> ids =
          pizzaOrderFilter.getBranches().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, Branch> join = r.join(PizzaOrder_.branch);
      preds.add(join.get(Branch_.id).in(ids));
    }

    if (pizzaOrderFilter.getOrderStatus() != null && !pizzaOrderFilter.getOrderStatus().isEmpty()) {
      preds.add(r.get(PizzaOrder_.orderStatus).in(pizzaOrderFilter.getOrderStatus()));
    }

    if (pizzaOrderFilter.getPizzaOrderPizzases() != null
        && !pizzaOrderFilter.getPizzaOrderPizzases().isEmpty()) {
      Set<String> ids =
          pizzaOrderFilter.getPizzaOrderPizzases().parallelStream()
              .map(f -> f.getId())
              .collect(Collectors.toSet());
      Join<T, Pizza> join = r.join(PizzaOrder_.pizzaOrderPizzas);
      preds.add(join.get(Pizza_.id).in(ids));
    }

    if (pizzaOrderFilter.getLonStart() != null) {
      preds.add(cb.greaterThanOrEqualTo(r.get(PizzaOrder_.lon), pizzaOrderFilter.getLonStart()));
    }
    if (pizzaOrderFilter.getLonEnd() != null) {
      preds.add(cb.lessThanOrEqualTo(r.get(PizzaOrder_.lon), pizzaOrderFilter.getLonEnd()));
    }

    if (pizzaOrderFilter.getOrderId() != null && !pizzaOrderFilter.getOrderId().isEmpty()) {
      preds.add(r.get(PizzaOrder_.orderId).in(pizzaOrderFilter.getOrderId()));
    }
  }

  /**
   * @param pizzaOrderFilter Object Used to List PizzaOrder
   * @param securityContext
   * @return count of PizzaOrder
   */
  public Long countAllPizzaOrders(
      PizzaOrderFilter pizzaOrderFilter, UserSecurityContext securityContext) {
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Long> q = cb.createQuery(Long.class);
    Root<PizzaOrder> r = q.from(PizzaOrder.class);
    List<Predicate> preds = new ArrayList<>();
    addPizzaOrderPredicate(pizzaOrderFilter, cb, q, r, preds, securityContext);
    q.select(cb.count(r)).where(preds.toArray(new Predicate[0]));
    TypedQuery<Long> query = em.createQuery(q);
    return query.getSingleResult();
  }

  public void remove(Object o) {
    em.remove(o);
  }

  public <T extends PizzaOrder, I> List<T> listByIds(
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

  public <T extends PizzaOrder, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return getByIdOrNull(c, idField, id, null);
  }

  public <T extends PizzaOrder, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return listByIds(c, idField, ids, null);
  }

  public <T extends PizzaOrder, I> T getByIdOrNull(
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
