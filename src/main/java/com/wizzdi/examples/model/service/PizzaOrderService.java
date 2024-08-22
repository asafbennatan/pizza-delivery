package com.wizzdi.examples.model.service;

import com.wizzdi.examples.model.data.PizzaOrderRepository;
import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.model.PizzaOrder_;
import com.wizzdi.examples.model.request.PizzaOrderCreate;
import com.wizzdi.examples.model.request.PizzaOrderFilter;
import com.wizzdi.examples.model.request.PizzaOrderUpdate;
import com.wizzdi.examples.model.response.PaginationResponse;
import com.wizzdi.examples.model.security.UserSecurityContext;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class PizzaOrderService {

  @Autowired private PizzaOrderRepository repository;

  @Autowired private SecuredBasicService securedBasicService;

  /**
   * @param pizzaOrderCreate Object Used to Create PizzaOrder
   * @param securityContext
   * @return created PizzaOrder
   */
  public PizzaOrder createPizzaOrder(
      PizzaOrderCreate pizzaOrderCreate, UserSecurityContext securityContext) {
    PizzaOrder pizzaOrder = createPizzaOrderNoMerge(pizzaOrderCreate, securityContext);
    pizzaOrder = this.repository.merge(pizzaOrder);
    return pizzaOrder;
  }

  /**
   * @param pizzaOrderCreate Object Used to Create PizzaOrder
   * @param securityContext
   * @return created PizzaOrder unmerged
   */
  public PizzaOrder createPizzaOrderNoMerge(
      PizzaOrderCreate pizzaOrderCreate, UserSecurityContext securityContext) {
    PizzaOrder pizzaOrder = new PizzaOrder();
    pizzaOrder.setId(UUID.randomUUID().toString());
    updatePizzaOrderNoMerge(pizzaOrder, pizzaOrderCreate);

    return pizzaOrder;
  }

  /**
   * @param pizzaOrderCreate Object Used to Create PizzaOrder
   * @param pizzaOrder
   * @return if pizzaOrder was updated
   */
  public boolean updatePizzaOrderNoMerge(PizzaOrder pizzaOrder, PizzaOrderCreate pizzaOrderCreate) {
    boolean update = securedBasicService.updateSecuredBasicNoMerge(pizzaOrder, pizzaOrderCreate);

    if (pizzaOrderCreate.getLat() != null
        && (!pizzaOrderCreate.getLat().equals(pizzaOrder.getLat()))) {
      pizzaOrder.setLat(pizzaOrderCreate.getLat());
      update = true;
    }

    if (pizzaOrderCreate.getBranch() != null
        && (pizzaOrder.getBranch() == null
            || !pizzaOrderCreate.getBranch().getId().equals(pizzaOrder.getBranch().getId()))) {
      pizzaOrder.setBranch(pizzaOrderCreate.getBranch());
      update = true;
    }

    if (pizzaOrderCreate.getOrderStatus() != null
        && (!pizzaOrderCreate.getOrderStatus().equals(pizzaOrder.getOrderStatus()))) {
      pizzaOrder.setOrderStatus(pizzaOrderCreate.getOrderStatus());
      update = true;
    }

    if (pizzaOrderCreate.getLon() != null
        && (!pizzaOrderCreate.getLon().equals(pizzaOrder.getLon()))) {
      pizzaOrder.setLon(pizzaOrderCreate.getLon());
      update = true;
    }

    if (pizzaOrderCreate.getOrderId() != null
        && (!pizzaOrderCreate.getOrderId().equals(pizzaOrder.getOrderId()))) {
      pizzaOrder.setOrderId(pizzaOrderCreate.getOrderId());
      update = true;
    }

    return update;
  }

  /**
   * @param pizzaOrderUpdate
   * @param securityContext
   * @return pizzaOrder
   */
  public PizzaOrder updatePizzaOrder(
      PizzaOrderUpdate pizzaOrderUpdate, UserSecurityContext securityContext) {
    PizzaOrder pizzaOrder = pizzaOrderUpdate.getPizzaOrder();
    if (updatePizzaOrderNoMerge(pizzaOrder, pizzaOrderUpdate)) {
      pizzaOrder = this.repository.merge(pizzaOrder);
    }
    return pizzaOrder;
  }

  /**
   * @param pizzaOrderFilter Object Used to List PizzaOrder
   * @param securityContext
   * @return PaginationResponse<PizzaOrder> containing paging information for PizzaOrder
   */
  public PaginationResponse<PizzaOrder> getAllPizzaOrders(
      PizzaOrderFilter pizzaOrderFilter, UserSecurityContext securityContext) {
    List<PizzaOrder> list = listAllPizzaOrders(pizzaOrderFilter, securityContext);
    long count = this.repository.countAllPizzaOrders(pizzaOrderFilter, securityContext);
    return new PaginationResponse<>(list, pizzaOrderFilter.getPageSize(), count);
  }

  /**
   * @param pizzaOrderFilter Object Used to List PizzaOrder
   * @param securityContext
   * @return List of PizzaOrder
   */
  public List<PizzaOrder> listAllPizzaOrders(
      PizzaOrderFilter pizzaOrderFilter, UserSecurityContext securityContext) {
    return this.repository.listAllPizzaOrders(pizzaOrderFilter, securityContext);
  }

  public PizzaOrder deletePizzaOrder(String id, UserSecurityContext securityContext) {
    PizzaOrder pizzaOrder =
        this.repository.getByIdOrNull(PizzaOrder.class, PizzaOrder_.id, id, securityContext);
    ;
    if (pizzaOrder == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PizzaOrder not found");
    }

    this.repository.remove(pizzaOrder);

    return pizzaOrder;
  }

  public <T extends PizzaOrder, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T extends PizzaOrder, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T extends PizzaOrder, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T extends PizzaOrder, I> List<T> listByIds(
      Class<T> c, SingularAttribute<? super T, I> idField, Set<I> ids) {
    return repository.listByIds(c, idField, ids);
  }

  public <T> T merge(T base) {
    return this.repository.merge(base);
  }

  public void massMerge(List<?> toMerge) {
    this.repository.massMerge(toMerge);
  }
}
