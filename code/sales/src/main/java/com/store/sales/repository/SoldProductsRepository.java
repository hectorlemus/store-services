package com.store.sales.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.sales.model.SoldProduct;

public interface SoldProductsRepository extends JpaRepository<SoldProduct, UUID> {
  
}
