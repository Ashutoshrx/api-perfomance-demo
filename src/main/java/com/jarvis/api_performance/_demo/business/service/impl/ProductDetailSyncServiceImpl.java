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

@Service
public class ProductDetailSyncServiceImpl implements ProductDetailSyncService {
  private static final Logger log = LoggerFactory.getLogger(ProductDetailSyncServiceImpl.class);
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
  public ProductDetailDTO fetchProductDetailsInSync(Integer productId) {
    try {
      log.info("Started fetching productDetails in sync based on productId:{}", productId);
      Product product = productService.findProduct(productId);
      Category category = categoryService.fetchProductCategory(productId);
      Price price = priceService.fetchProductPrice(productId);
      Inventory inventory = inventoryService.fetchProductInventory(productId);
      return productDetailMapper.mapProductDetails(product,category,price,inventory);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
