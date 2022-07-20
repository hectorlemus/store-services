package com.store.products.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.products.model.Product;
import com.store.products.repository.ProductRepository;

@RestController()
public class ProductsController {
  private final ProductRepository repository;

  public ProductsController(final ProductRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/products")
  public ResponseEntity<List<Product>> products() {
    try {
      final List<Product> products = repository.findAll();
      return new ResponseEntity<>(products, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/products")
  public ResponseEntity<Product> addProducts(final @RequestBody Product newProduct) {
    try {
      final Product product = repository.save(newProduct);
      return new ResponseEntity<>(product, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/products/{id}")
  public ResponseEntity<Product> product(final @PathVariable UUID id) {
    try {
      final Product product = repository.findById(id).get();
      return new ResponseEntity<>(product, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  @PutMapping("/products/{id}")
  public ResponseEntity<Product> replaceProduct(@RequestBody Product newProduct, @PathVariable UUID id) {
    try {
      final Product product = repository.findById(id)
      .map(Product -> {
        Product.setName(newProduct.getName());
        Product.setPrice(newProduct.getPrice());
        return repository.save(Product);
      })
      .orElseGet(() -> {
        return repository.save(newProduct);
      });

      return new ResponseEntity<>(product, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/products/{id}")
  public ResponseEntity<Product> deleteProduct(final @PathVariable UUID id) {
    try {
      repository.deleteById(id);
      return new ResponseEntity<>(null, HttpStatus.OK);
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

}
