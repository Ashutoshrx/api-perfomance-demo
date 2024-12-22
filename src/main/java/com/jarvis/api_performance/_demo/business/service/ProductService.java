package com.jarvis.api_performance._demo.business.service;

import com.jarvis.api_performance._demo.data.entity.Product;

import java.util.Map;
import java.util.Set;

public interface ProductService {
  Set<Product> findAllProducts(Map<String, String> queryParams);
}
