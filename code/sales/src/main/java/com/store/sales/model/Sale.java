package com.store.sales.model;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.data.annotation.CreatedDate;

@Entity
public class Sale {

  private @Id @GeneratedValue UUID id;

  @Column(name="created_at", nullable = false, updatable = false)
  @CreatedDate
  private Date createdAt;

  public Sale() {
    this.createdAt = new Date();
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

}
