package com.jarvis.api_performance._demo.rest;

import com.jarvis.api_performance._demo.business.service.ProductDetailSyncService;
import com.jarvis.api_performance._demo.business.service.ProductDetailsAsyncService;
import com.jarvis.api_performance._demo.dto.ProductDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductDetailsController {
  @Autowired
  private ProductDetailSyncService productDetailSyncService;
  @Autowired
  private ProductDetailsAsyncService productDetailsAsyncService;

  @GetMapping(value = "/v1/products/{productId}/sync", produces = MediaType.APPLICATION_JSON_VALUE)
  public ProductDetailDTO fetchProductsInSync(@PathVariable Integer productId) {
    return productDetailSyncService.fetchProductDetailsInSync(productId);
  }

  @GetMapping(value = "/v1/products/{productId}/async", produces = MediaType.APPLICATION_JSON_VALUE)
  public ProductDetailDTO fetchProductsInAsync(@PathVariable Integer productId) {
    return productDetailsAsyncService.fetchProductDetailsAsync(productId);
  }
}
