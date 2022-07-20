package com.store.products.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.products.model.Product;

public interface ProductRepository extends JpaRepository<Product, UUID> {

}
