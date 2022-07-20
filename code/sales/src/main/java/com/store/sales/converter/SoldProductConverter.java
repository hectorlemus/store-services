package com.store.sales.converter;

import com.store.sales.dto.SoldProductsDto;
import com.store.sales.model.Product;
import com.store.sales.model.Sale;
import com.store.sales.model.SoldProduct;

public class SoldProductConverter {
  
  public SoldProduct toModel(
    final SoldProductsDto dto,
    final Product product,
    final Sale sale
  ) {
    return new SoldProduct(product, dto.getQuantity(), sale);
  }

}
