package com.jarvis.api_performance._demo.business.service;

import com.jarvis.api_performance._demo.dto.ProductDetailDTO;

public interface ProductDetailsAsyncService {
  ProductDetailDTO fetchProductDetailsAsync(Integer productId);
}
