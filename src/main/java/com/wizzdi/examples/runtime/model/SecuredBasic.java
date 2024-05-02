package com.wizzdi.examples.runtime.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class SecuredBasic extends Basic {

  @ManyToOne(targetEntity = AppUser.class)
  @CreatedBy
  private AppUser creator;

  /**
   * @return creator
   */
  @ManyToOne(targetEntity = AppUser.class)
  public AppUser getCreator() {
    return this.creator;
  }

  /**
   * @param creator creator to set
   * @return SecuredBasic
   */
  public <T extends SecuredBasic> T setCreator(AppUser creator) {
    this.creator = creator;
    return (T) this;
  }
}
