package com.store.sales.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class SoldProduct {

  private @Id @GeneratedValue UUID id;

  private int quantity;
  
  @ManyToOne
  private Product product;

  @ManyToOne
  private Sale sale;

  public SoldProduct() {};

  public SoldProduct(final Product product, final int quantity, final Sale sale) {
    this.quantity = quantity;
    this.product = product;
    this.sale = sale;
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }  

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Sale getSale() {
    return sale;
  }

  public void setSale(Sale sale) {
    this.sale = sale;
  }

}
