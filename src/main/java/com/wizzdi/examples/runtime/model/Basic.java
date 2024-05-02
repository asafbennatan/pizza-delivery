package com.wizzdi.examples.runtime.model;

import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import java.time.OffsetDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Basic {

  @Id private String id;

  private String name;

  @CreatedDate private OffsetDateTime creationDate;

  @LastModifiedDate private OffsetDateTime updateDate;

  /**
   * @return id
   */
  @Id
  public String getId() {
    return this.id;
  }

  /**
   * @param id id to set
   * @return Basic
   */
  public <T extends Basic> T setId(String id) {
    this.id = id;
    return (T) this;
  }

  /**
   * @return name
   */
  public String getName() {
    return this.name;
  }

  /**
   * @param name name to set
   * @return Basic
   */
  public <T extends Basic> T setName(String name) {
    this.name = name;
    return (T) this;
  }

  /**
   * @return creationDate
   */
  public OffsetDateTime getCreationDate() {
    return this.creationDate;
  }

  /**
   * @param creationDate creationDate to set
   * @return Basic
   */
  public <T extends Basic> T setCreationDate(OffsetDateTime creationDate) {
    this.creationDate = creationDate;
    return (T) this;
  }

  /**
   * @return updateDate
   */
  public OffsetDateTime getUpdateDate() {
    return this.updateDate;
  }

  /**
   * @param updateDate updateDate to set
   * @return Basic
   */
  public <T extends Basic> T setUpdateDate(OffsetDateTime updateDate) {
    this.updateDate = updateDate;
    return (T) this;
  }
}
