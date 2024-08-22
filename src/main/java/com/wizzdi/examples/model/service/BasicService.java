package com.wizzdi.examples.model.service;

import com.wizzdi.examples.model.data.BasicRepository;
import com.wizzdi.examples.model.model.Basic;
import com.wizzdi.examples.model.model.Basic_;
import com.wizzdi.examples.model.request.BasicCreate;
import com.wizzdi.examples.model.request.BasicFilter;
import com.wizzdi.examples.model.request.BasicUpdate;
import com.wizzdi.examples.model.response.PaginationResponse;
import com.wizzdi.examples.model.security.UserSecurityContext;
import jakarta.persistence.metamodel.SingularAttribute;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

@Component
public class BasicService {

  @Autowired private BasicRepository repository;

  /**
   * @param basicCreate Object Used to Create Basic
   * @param securityContext
   * @return created Basic
   */
  public Basic createBasic(BasicCreate basicCreate, UserSecurityContext securityContext) {
    Basic basic = createBasicNoMerge(basicCreate, securityContext);
    basic = this.repository.merge(basic);
    return basic;
  }

  /**
   * @param basicCreate Object Used to Create Basic
   * @param securityContext
   * @return created Basic unmerged
   */
  public Basic createBasicNoMerge(BasicCreate basicCreate, UserSecurityContext securityContext) {
    Basic basic = new Basic();
    basic.setId(UUID.randomUUID().toString());
    updateBasicNoMerge(basic, basicCreate);

    basic.setCreationDate(OffsetDateTime.now());

    return basic;
  }

  /**
   * @param basicCreate Object Used to Create Basic
   * @param basic
   * @return if basic was updated
   */
  public boolean updateBasicNoMerge(Basic basic, BasicCreate basicCreate) {
    boolean update = false;

    if (basicCreate.getUpdateDate() != null
        && (!basicCreate.getUpdateDate().equals(basic.getUpdateDate()))) {
      basic.setUpdateDate(basicCreate.getUpdateDate());
      update = true;
    }

    if (basicCreate.getCreationDate() != null
        && (!basicCreate.getCreationDate().equals(basic.getCreationDate()))) {
      basic.setCreationDate(basicCreate.getCreationDate());
      update = true;
    }

    if (basicCreate.getName() != null && (!basicCreate.getName().equals(basic.getName()))) {
      basic.setName(basicCreate.getName());
      update = true;
    }

    if (update) {
      basic.setUpdateDate(OffsetDateTime.now());
    }

    return update;
  }

  /**
   * @param basicUpdate
   * @param securityContext
   * @return basic
   */
  public Basic updateBasic(BasicUpdate basicUpdate, UserSecurityContext securityContext) {
    Basic basic = basicUpdate.getBasic();
    if (updateBasicNoMerge(basic, basicUpdate)) {
      basic = this.repository.merge(basic);
    }
    return basic;
  }

  /**
   * @param basicFilter Object Used to List Basic
   * @param securityContext
   * @return PaginationResponse<Basic> containing paging information for Basic
   */
  public PaginationResponse<Basic> getAllBasics(
      BasicFilter basicFilter, UserSecurityContext securityContext) {
    List<Basic> list = listAllBasics(basicFilter, securityContext);
    long count = this.repository.countAllBasics(basicFilter, securityContext);
    return new PaginationResponse<>(list, basicFilter.getPageSize(), count);
  }

  /**
   * @param basicFilter Object Used to List Basic
   * @param securityContext
   * @return List of Basic
   */
  public List<Basic> listAllBasics(BasicFilter basicFilter, UserSecurityContext securityContext) {
    return this.repository.listAllBasics(basicFilter, securityContext);
  }

  public Basic deleteBasic(String id, UserSecurityContext securityContext) {
    Basic basic = this.repository.getByIdOrNull(Basic.class, Basic_.id, id, securityContext);
    ;
    if (basic == null) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Basic not found");
    }

    this.repository.remove(basic);

    return basic;
  }

  public <T extends Basic, I> List<T> listByIds(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      Set<I> ids,
      UserSecurityContext securityContext) {
    return repository.listByIds(c, idField, ids, securityContext);
  }

  public <T extends Basic, I> T getByIdOrNull(
      Class<T> c,
      SingularAttribute<? super T, I> idField,
      I id,
      UserSecurityContext securityContext) {
    return repository.getByIdOrNull(c, idField, id, securityContext);
  }

  public <T extends Basic, I> T getByIdOrNull(
      Class<T> c, SingularAttribute<? super T, I> idField, I id) {
    return repository.getByIdOrNull(c, idField, id);
  }

  public <T extends Basic, I> List<T> listByIds(
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
