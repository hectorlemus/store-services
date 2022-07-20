package com.store.sales.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.store.sales.converter.SoldProductConverter;
import com.store.sales.dto.AddSaleDto;
import com.store.sales.dto.SoldProductsDto;
import com.store.sales.model.Product;
import com.store.sales.model.Sale;
import com.store.sales.model.SoldProduct;
import com.store.sales.repository.ProductRepository;
import com.store.sales.repository.SalesRepository;
import com.store.sales.repository.SoldProductsRepository;

@RestController()
public class SalesController {
  private final SoldProductsRepository soldProductsRepository;
  private final ProductRepository productRepository;
  private final SalesRepository salesRepository;

  public SalesController(
    final SoldProductsRepository soldProductsRepository,
    final ProductRepository productRepository,
    final SalesRepository repository
  ) {
    this.soldProductsRepository = soldProductsRepository;
    this.productRepository = productRepository;
    this.salesRepository = repository;
  }

  @GetMapping("/sales")
  public ResponseEntity<List<Sale>> sales() {
    try {
      final List<Sale> sales = salesRepository.findAll();
      return new ResponseEntity<>(sales, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PostMapping("/sales")
  public ResponseEntity<Sale> addSale(final @RequestBody AddSaleDto newSale) {
    try {
      final List<SoldProductsDto> products = newSale.getProducts();

      if (!products.isEmpty()) {
        final Sale sale = this.saveSale(products);
        return new ResponseEntity<>(sale, HttpStatus.CREATED);
      }
      
      return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  private Sale saveSale(final List<SoldProductsDto> products) {
    final Sale sale = salesRepository.save(new Sale());
    products.forEach((product) -> this.saveSoldProduct(product, sale));
    return sale;
  }

  private void saveSoldProduct(final SoldProductsDto productDto, final Sale sale) {
    final Product product = productRepository.findById(productDto.getProductId()).get();
    final SoldProductConverter converter = new SoldProductConverter();
    final SoldProduct soldProduct = converter.toModel(productDto, product, sale);
    soldProductsRepository.save(soldProduct);
  }

}
