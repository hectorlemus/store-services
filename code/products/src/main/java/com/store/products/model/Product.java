package com.store.products.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Product {

  private @Id @GeneratedValue UUID id;
  private String name;
  private double price;

  public Product() {}

  public Product(final String name, final double price) {
    this.name = name;    
    this.price = price;    
  }

  public UUID getId() {
    return this.id;
  }
  
  public void setId(UUID id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

}