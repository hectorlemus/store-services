package com.store.sales.dto;

import java.util.List;

public class AddSaleDto {

  private List<SoldProductsDto> products;

  public List<SoldProductsDto> getProducts() {
    return products;
  }

  public void setProducts(List<SoldProductsDto> products) {
    this.products = products;
  }

}
