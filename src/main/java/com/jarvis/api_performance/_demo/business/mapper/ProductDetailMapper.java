package com.jarvis.api_performance._demo.business.mapper;

import com.jarvis.api_performance._demo.data.entity.Category;
import com.jarvis.api_performance._demo.data.entity.Inventory;
import com.jarvis.api_performance._demo.data.entity.Price;
import com.jarvis.api_performance._demo.data.entity.Product;
import com.jarvis.api_performance._demo.dto.ProductDetailDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductDetailMapper {
  @Mapping(target = "id", source = "product.productId")
  @Mapping(target = "categoryName", source = "category.categoryName")
  @Mapping(target = "productName", source = "product.productName")
  @Mapping(target = "description", source = "product.description")
  @Mapping(target = "price", source = "price.price")
  @Mapping(target = "availableQuantity", source = "inventory.availableQuantity")
  @Mapping(target = "status", source = "product.status")
  ProductDetailDTO mapProductDetails(Product product, Category category, Price price, Inventory inventory);
}
