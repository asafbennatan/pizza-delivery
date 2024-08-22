package com.wizzdi.examples.model.service;

import com.wizzdi.examples.model.data.ToppingRepository;
import com.wizzdi.examples.model.model.Topping;
import com.wizzdi.examples.model.model.Topping_;
import com.wizzdi.examples.model.request.ToppingCreate;
import com.wizzdi.examples.model.request.ToppingFilter;
import com.wizzdi.examples.model.request.ToppingUpdate;
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
public class ToppingService {

  @Autowired private ToppingRepository repository;

  @Autowired private BasicService basicService;

  /**
   * @param toppingCreate Object Used to Create Topping
   * @param securityContext
   * @return created Topping
   */
  public Topping createTopping(ToppingCreate toppingCreate, UserSecurityContext securityContext) {
    Topping topping = createToppingNoMerge(toppingCreate, securityContext);
    topping = this.repository.merge(topping);
    return topping;
  }

  /**
   * @param toppingCreate Object Used to Create Topping
   * @param securityContext
   * @return created Topping unmerged
   */
  public Topping createToppingNoMerge(
      ToppingCreate toppingCreate, UserSecurityContext securityContext) {
    Topping topping = new Topping();
    topping.setId(UUID.randomUUID().toString());
    updateToppingNoMerge(topping, toppingCreate);

    return topping;
  }

  /**
   * @param toppingCreate Object Used to Create Topping
   * @param topping
   * @return if topping was updated
   */
  public boolean updateToppingNoMerge(Topping topping, ToppingCreate toppingCreate) {
    boolean update = basicService.updateBasicNoMerge(topping, toppingCreate);

    if (toppingCreate.getPrice() != null
        && (!toppingCreate.getPrice().equals(topping.getPrice()))) {
      topping.setPrice(toppingCreate.getPrice());
      update = true;
    }

    return update;
  }

  /**
   * @param toppingUpdate
   * @param securityContext
   * @return topping
   */
  public Topping updateTopping(ToppingUpdate toppingUpdate, UserSecurityContext securityContext) {
    Topping topping = toppingUpdate.getTopping();
    if (updateToppingNoMerge(topping, toppingUpdate)) {
      topping = this.repository.merge(topping);
    }
    return topping;
  }

  /**
   * @param toppingFilter Object Used to List Topping
   * @param securityContext
   * @return PaginationResponse<Topping> containing paging information for Topping
   */
  public PaginationResponse<Topping> getAllToppings(
      ToppingFilter toppingFilter, UserSecurityContext securityContext) {
    List<Topping> list = listAllToppings(toppingFilter, securityContext);
    long count = this.repository.countAllToppings(toppingFilter, securityContext);
    return new PaginationResponse<>(list, toppingFilter.getPageSize(), count);
  }

  /**
   * @param toppingFilter Object Used to List Topping
   * @param securityContext
   * @return List of Topping
   */
  public List<Topping> listAllToppings(
      ToppingFilter toppingFilter, UserSecurityContext securityContext) {
    return this.repository.listAllToppings(toppingFilter, securityContext);
  }

  public Topping deleteTopping(String id, UserSecurityContext securityContext) {
    Topping topping =
        this.repository.getByIdOrNull(Topping.class, Topping_.id, id, securityContext);
    ;
    if (topping == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Topping not found");
    }

    this.repository.remove(topping);

    return topping;
  }

  public <T extends Topping, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T extends Topping, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T extends Topping, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T extends Topping, I> List<T> listByIds(
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
