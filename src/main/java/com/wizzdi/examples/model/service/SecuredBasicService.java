package com.wizzdi.examples.model.service;

import com.wizzdi.examples.model.data.SecuredBasicRepository;
import com.wizzdi.examples.model.model.SecuredBasic;
import com.wizzdi.examples.model.model.SecuredBasic_;
import com.wizzdi.examples.model.request.SecuredBasicCreate;
import com.wizzdi.examples.model.request.SecuredBasicFilter;
import com.wizzdi.examples.model.request.SecuredBasicUpdate;
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
public class SecuredBasicService {

  @Autowired private SecuredBasicRepository repository;

  @Autowired private BasicService basicService;

  /**
   * @param securedBasicCreate Object Used to Create SecuredBasic
   * @param securityContext
   * @return created SecuredBasic
   */
  public SecuredBasic createSecuredBasic(
      SecuredBasicCreate securedBasicCreate, UserSecurityContext securityContext) {
    SecuredBasic securedBasic = createSecuredBasicNoMerge(securedBasicCreate, securityContext);
    securedBasic = this.repository.merge(securedBasic);
    return securedBasic;
  }

  /**
   * @param securedBasicCreate Object Used to Create SecuredBasic
   * @param securityContext
   * @return created SecuredBasic unmerged
   */
  public SecuredBasic createSecuredBasicNoMerge(
      SecuredBasicCreate securedBasicCreate, UserSecurityContext securityContext) {
    SecuredBasic securedBasic = new SecuredBasic();
    securedBasic.setId(UUID.randomUUID().toString());
    updateSecuredBasicNoMerge(securedBasic, securedBasicCreate);

    return securedBasic;
  }

  /**
   * @param securedBasicCreate Object Used to Create SecuredBasic
   * @param securedBasic
   * @return if securedBasic was updated
   */
  public boolean updateSecuredBasicNoMerge(
      SecuredBasic securedBasic, SecuredBasicCreate securedBasicCreate) {
    boolean update = basicService.updateBasicNoMerge(securedBasic, securedBasicCreate);

    return update;
  }

  /**
   * @param securedBasicUpdate
   * @param securityContext
   * @return securedBasic
   */
  public SecuredBasic updateSecuredBasic(
      SecuredBasicUpdate securedBasicUpdate, UserSecurityContext securityContext) {
    SecuredBasic securedBasic = securedBasicUpdate.getSecuredBasic();
    if (updateSecuredBasicNoMerge(securedBasic, securedBasicUpdate)) {
      securedBasic = this.repository.merge(securedBasic);
    }
    return securedBasic;
  }

  /**
   * @param securedBasicFilter Object Used to List SecuredBasic
   * @param securityContext
   * @return PaginationResponse<SecuredBasic> containing paging information for SecuredBasic
   */
  public PaginationResponse<SecuredBasic> getAllSecuredBasics(
      SecuredBasicFilter securedBasicFilter, UserSecurityContext securityContext) {
    List<SecuredBasic> list = listAllSecuredBasics(securedBasicFilter, securityContext);
    long count = this.repository.countAllSecuredBasics(securedBasicFilter, securityContext);
    return new PaginationResponse<>(list, securedBasicFilter.getPageSize(), count);
  }

  /**
   * @param securedBasicFilter Object Used to List SecuredBasic
   * @param securityContext
   * @return List of SecuredBasic
   */
  public List<SecuredBasic> listAllSecuredBasics(
      SecuredBasicFilter securedBasicFilter, UserSecurityContext securityContext) {
    return this.repository.listAllSecuredBasics(securedBasicFilter, securityContext);
  }

  public SecuredBasic deleteSecuredBasic(String id, UserSecurityContext securityContext) {
    SecuredBasic securedBasic =
        this.repository.getByIdOrNull(SecuredBasic.class, SecuredBasic_.id, id, securityContext);
    ;
    if (securedBasic == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "SecuredBasic not found");
    }

    this.repository.remove(securedBasic);

    return securedBasic;
  }

  public <T extends SecuredBasic, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T extends SecuredBasic, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T extends SecuredBasic, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T extends SecuredBasic, I> List<T> listByIds(
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
