package com.wizzdi.examples.runtime.service;

import com.wizzdi.examples.runtime.data.PizzaRepository;
import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.model.Pizza_;
import com.wizzdi.examples.runtime.request.PizzaCreate;
import com.wizzdi.examples.runtime.request.PizzaFilter;
import com.wizzdi.examples.runtime.request.PizzaUpdate;
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
public class PizzaService {

  @Autowired private PizzaRepository repository;

  @Autowired private SecuredBasicService securedBasicService;

  /**
   * @param pizzaCreate Object Used to Create Pizza
   * @param securityContext
   * @return created Pizza
   */
  public Pizza createPizza(PizzaCreate pizzaCreate, UserSecurityContext securityContext) {
    Pizza pizza = createPizzaNoMerge(pizzaCreate, securityContext);
    pizza = this.repository.merge(pizza);
    return pizza;
  }

  /**
   * @param pizzaCreate Object Used to Create Pizza
   * @param securityContext
   * @return created Pizza unmerged
   */
  public Pizza createPizzaNoMerge(PizzaCreate pizzaCreate, UserSecurityContext securityContext) {
    Pizza pizza = new Pizza();
    pizza.setId(UUID.randomUUID().toString());
    updatePizzaNoMerge(pizza, pizzaCreate);

    return pizza;
  }

  /**
   * @param pizzaCreate Object Used to Create Pizza
   * @param pizza
   * @return if pizza was updated
   */
  public boolean updatePizzaNoMerge(Pizza pizza, PizzaCreate pizzaCreate) {
    boolean update = securedBasicService.updateSecuredBasicNoMerge(pizza, pizzaCreate);

    if (pizzaCreate.getPizzaOrder() != null
        && (pizza.getPizzaOrder() == null
            || !pizzaCreate.getPizzaOrder().getId().equals(pizza.getPizzaOrder().getId()))) {
      pizza.setPizzaOrder(pizzaCreate.getPizzaOrder());
      update = true;
    }

    return update;
  }

  /**
   * @param pizzaUpdate
   * @param securityContext
   * @return pizza
   */
  public Pizza updatePizza(PizzaUpdate pizzaUpdate, UserSecurityContext securityContext) {
    Pizza pizza = pizzaUpdate.getPizza();
    if (updatePizzaNoMerge(pizza, pizzaUpdate)) {
      pizza = this.repository.merge(pizza);
    }
    return pizza;
  }

  /**
   * @param pizzaFilter Object Used to List Pizza
   * @param securityContext
   * @return PaginationResponse<Pizza> containing paging information for Pizza
   */
  public PaginationResponse<Pizza> getAllPizzas(
      PizzaFilter pizzaFilter, UserSecurityContext securityContext) {
    List<Pizza> list = listAllPizzas(pizzaFilter, securityContext);
    long count = this.repository.countAllPizzas(pizzaFilter, securityContext);
    return new PaginationResponse<>(list, pizzaFilter.getPageSize(), count);
  }

  /**
   * @param pizzaFilter Object Used to List Pizza
   * @param securityContext
   * @return List of Pizza
   */
  public List<Pizza> listAllPizzas(PizzaFilter pizzaFilter, UserSecurityContext securityContext) {
    return this.repository.listAllPizzas(pizzaFilter, securityContext);
  }

  public Pizza deletePizza(String id, UserSecurityContext securityContext) {
    Pizza pizza = this.repository.getByIdOrNull(Pizza.class, Pizza_.id, id, securityContext);
    ;
    if (pizza == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pizza not found");
    }

    this.repository.remove(pizza);

    return pizza;
  }

  public <T extends Pizza, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T extends Pizza, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T extends Pizza, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T extends Pizza, I> List<T> listByIds(
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
