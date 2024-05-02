package com.wizzdi.examples.runtime.service;

import com.wizzdi.examples.runtime.data.PizzaToToppingRepository;
import com.wizzdi.examples.runtime.model.PizzaToTopping;
import com.wizzdi.examples.runtime.model.PizzaToTopping_;
import com.wizzdi.examples.runtime.request.PizzaToToppingCreate;
import com.wizzdi.examples.runtime.request.PizzaToToppingFilter;
import com.wizzdi.examples.runtime.request.PizzaToToppingUpdate;
import com.wizzdi.examples.runtime.response.PaginationResponse;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import jakarta.persistence.metamodel.SingularAttribute;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class PizzaToToppingService {

  @Autowired private PizzaToToppingRepository repository;

  /**
   * @param pizzaToToppingCreate Object Used to Create PizzaToTopping
   * @param securityContext
   * @return created PizzaToTopping
   */
  public PizzaToTopping createPizzaToTopping(
      PizzaToToppingCreate pizzaToToppingCreate, UserSecurityContext securityContext) {
    PizzaToTopping pizzaToTopping =
        createPizzaToToppingNoMerge(pizzaToToppingCreate, securityContext);
    pizzaToTopping = this.repository.merge(pizzaToTopping);
    return pizzaToTopping;
  }

  /**
   * @param pizzaToToppingCreate Object Used to Create PizzaToTopping
   * @param securityContext
   * @return created PizzaToTopping unmerged
   */
  public PizzaToTopping createPizzaToToppingNoMerge(
      PizzaToToppingCreate pizzaToToppingCreate, UserSecurityContext securityContext) {
    PizzaToTopping pizzaToTopping = new PizzaToTopping();
    pizzaToTopping.setId(UUID.randomUUID().toString());
    updatePizzaToToppingNoMerge(pizzaToTopping, pizzaToToppingCreate);

    return pizzaToTopping;
  }

  /**
   * @param pizzaToToppingCreate Object Used to Create PizzaToTopping
   * @param pizzaToTopping
   * @return if pizzaToTopping was updated
   */
  public boolean updatePizzaToToppingNoMerge(
      PizzaToTopping pizzaToTopping, PizzaToToppingCreate pizzaToToppingCreate) {
    boolean update = false;

    if (pizzaToToppingCreate.getPizza() != null
        && (pizzaToTopping.getPizza() == null
            || !pizzaToToppingCreate
                .getPizza()
                .getId()
                .equals(pizzaToTopping.getPizza().getId()))) {
      pizzaToTopping.setPizza(pizzaToToppingCreate.getPizza());
      update = true;
    }

    if (pizzaToToppingCreate.getPizzaCoverage() != null
        && (!pizzaToToppingCreate.getPizzaCoverage().equals(pizzaToTopping.getPizzaCoverage()))) {
      pizzaToTopping.setPizzaCoverage(pizzaToToppingCreate.getPizzaCoverage());
      update = true;
    }

    if (pizzaToToppingCreate.getTopping() != null
        && (pizzaToTopping.getTopping() == null
            || !pizzaToToppingCreate
                .getTopping()
                .getId()
                .equals(pizzaToTopping.getTopping().getId()))) {
      pizzaToTopping.setTopping(pizzaToToppingCreate.getTopping());
      update = true;
    }

    return update;
  }

  /**
   * @param pizzaToToppingUpdate
   * @param securityContext
   * @return pizzaToTopping
   */
  public PizzaToTopping updatePizzaToTopping(
      PizzaToToppingUpdate pizzaToToppingUpdate, UserSecurityContext securityContext) {
    PizzaToTopping pizzaToTopping = pizzaToToppingUpdate.getPizzaToTopping();
    if (updatePizzaToToppingNoMerge(pizzaToTopping, pizzaToToppingUpdate)) {
      pizzaToTopping = this.repository.merge(pizzaToTopping);
    }
    return pizzaToTopping;
  }

  /**
   * @param pizzaToToppingFilter Object Used to List PizzaToTopping
   * @param securityContext
   * @return PaginationResponse<PizzaToTopping> containing paging information for PizzaToTopping
   */
  public PaginationResponse<PizzaToTopping> getAllPizzaToToppings(
      PizzaToToppingFilter pizzaToToppingFilter, UserSecurityContext securityContext) {
    List<PizzaToTopping> list = listAllPizzaToToppings(pizzaToToppingFilter, securityContext);
    long count = this.repository.countAllPizzaToToppings(pizzaToToppingFilter, securityContext);
    return new PaginationResponse<>(list, pizzaToToppingFilter.getPageSize(), count);
  }

  /**
   * @param pizzaToToppingFilter Object Used to List PizzaToTopping
   * @param securityContext
   * @return List of PizzaToTopping
   */
  public List<PizzaToTopping> listAllPizzaToToppings(
      PizzaToToppingFilter pizzaToToppingFilter, UserSecurityContext securityContext) {
    return this.repository.listAllPizzaToToppings(pizzaToToppingFilter, securityContext);
  }

  public PizzaToTopping deletePizzaToTopping(String id, UserSecurityContext securityContext) {
    PizzaToTopping pizzaToTopping =
        this.repository.getByIdOrNull(
            PizzaToTopping.class, PizzaToTopping_.id, id, securityContext);
    ;
    if (pizzaToTopping == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "PizzaToTopping not found");
    }

    this.repository.remove(pizzaToTopping);

    return pizzaToTopping;
  }

  public <T extends PizzaToTopping, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T extends PizzaToTopping, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T extends PizzaToTopping, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T extends PizzaToTopping, I> List<T> listByIds(
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
