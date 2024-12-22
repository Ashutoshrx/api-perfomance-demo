package com.jarvis.api_performance._demo.rest;

import com.jarvis.api_performance._demo.business.service.ProductService;
import com.jarvis.api_performance._demo.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Set;

@RestController
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("/v1/products")
  public Set<Product> fetchAllProducts(@RequestParam Map<String, String> queryParams) {
    return productService.findAllProducts(queryParams);
  }

}
