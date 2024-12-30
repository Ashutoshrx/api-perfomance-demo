package com.jarvis.api_performance._demo.business.service.impl;

import com.jarvis.api_performance._demo.business.mapper.ProductDetailMapper;
import com.jarvis.api_performance._demo.business.service.*;
import com.jarvis.api_performance._demo.data.entity.Category;
import com.jarvis.api_performance._demo.data.entity.Inventory;
import com.jarvis.api_performance._demo.data.entity.Price;
import com.jarvis.api_performance._demo.data.entity.Product;
import com.jarvis.api_performance._demo.dto.ProductDetailDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class ProductDetailsAsyncServiceImpl implements ProductDetailsAsyncService {
  private static final Logger log = LoggerFactory.getLogger(ProductDetailsAsyncServiceImpl.class);
  @Autowired
  private ProductService productService;
  @Autowired
  private InventoryService inventoryService;
  @Autowired
  private CategoryService categoryService;
  @Autowired
  private PriceService priceService;
  @Autowired
  private ProductDetailMapper productDetailMapper;

  @Override
  public ProductDetailDTO fetchProductDetailsAsync(Integer productId) {
    try {
      log.info("Started fetching productDetails in async based on productId:{}", productId);
      CompletableFuture<Product> productFuture = getProduct(productId);
      CompletableFuture<Category> categoryFuture = getCategory(productId);
      CompletableFuture<Price> priceFuture = getPrice(productId);
      CompletableFuture<Inventory> inventoryFuture = getInventory(productId);
      //wait for all the futures to complete
      CompletableFuture.allOf(productFuture, categoryFuture, priceFuture, inventoryFuture);
      //combine all the futures
      return productDetailMapper.mapProductDetails(productFuture.join(), categoryFuture.join(), priceFuture.join(),
              inventoryFuture.join());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private CompletableFuture<Product> getProduct(Integer productId) {
    log.warn("Product Thread's name:{}", Thread.currentThread().getName());
    return CompletableFuture.supplyAsync(() -> productService.findProduct(productId));
  }

  private CompletableFuture<Category> getCategory(Integer productId) {
    log.warn("Category Thread's name:{}", Thread.currentThread().getName());
    return CompletableFuture.supplyAsync(() -> categoryService.fetchProductCategory(productId));
  }

  private CompletableFuture<Price> getPrice(Integer productId) {
    log.warn("Price Thread's name:{}", Thread.currentThread().getName());
    return CompletableFuture.supplyAsync(() -> priceService.fetchProductPrice(productId));
  }

  private CompletableFuture<Inventory> getInventory(Integer productId) {
    log.warn("Inventory Thread's name:{}", Thread.currentThread().getName());
    return CompletableFuture.supplyAsync(() -> inventoryService.fetchProductInventory(productId));
  }
}