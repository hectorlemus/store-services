package com.store.sales.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.sales.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {
  
}
