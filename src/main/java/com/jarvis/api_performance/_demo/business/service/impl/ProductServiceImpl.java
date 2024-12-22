package com.jarvis.api_performance._demo.business.service.impl;

import com.jarvis.api_performance._demo.business.service.ProductService;
import com.jarvis.api_performance._demo.data.entity.Product;
import com.jarvis.api_performance._demo.data.repository.ProductRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
  @Autowired
  private ProductRepository productRepository;

  private Set<Product> findAllProducts() {
    List<Product> products = productRepository.findAll();
    return CollectionUtils.isNotEmpty(products) ? new HashSet<>(products) : Set.of();
  }

  @Override
  public Set<Product> findAllProducts(Map<String, String> queryParams) {
    try {
      if (ObjectUtils.isEmpty(queryParams)) {
        return findAllProducts();
      } else {
        Integer categoryId = Integer.valueOf(queryParams.get("categoryId"));
        return productRepository.findByCategoryId(categoryId);
      }
    } catch (Exception e) {
      System.out.println("Something went wrong:{}" + e.getMessage());
      throw new RuntimeException(e.getMessage());
    }
  }
}