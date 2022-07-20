package com.store.sales.dto;

import java.util.UUID;

public class SoldProductsDto {
  
  private int quantity;  
  private UUID productId;

  public int getQuantity() {
    return quantity;
  }
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
  public UUID getProductId() {
    return productId;
  }
  public void setProductId(UUID productId) {
    this.productId = productId;
  }

}
