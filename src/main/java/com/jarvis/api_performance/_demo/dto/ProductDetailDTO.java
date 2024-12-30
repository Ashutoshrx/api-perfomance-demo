package com.jarvis.api_performance._demo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
public class ProductDetailDTO implements Serializable {
  private Long id;
  private String categoryName;
  private String productName;
  private String description;
  private Integer availableQuantity;
  private BigDecimal price;
  private String status;
}
