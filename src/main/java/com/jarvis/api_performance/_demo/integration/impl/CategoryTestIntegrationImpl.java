package com.jarvis.api_performance._demo.integration.impl;

import com.jarvis.api_performance._demo.data.entity.Category;
import com.jarvis.api_performance._demo.integration.CategoryTestIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class CategoryTestIntegrationImpl implements CategoryTestIntegration {
  @Autowired
  private WebClient categoryIntegrationWebClient;
  @Value("${fetch.category.uri}")
  private String fetchCategoryUri;

  @Override
  public List<Category> invokeCategoryService() {
    try {
      return categoryIntegrationWebClient.get().uri(fetchCategoryUri).retrieve().
              bodyToFlux(Category.class).collectList()
//              bodyToMono(new ParameterizedTypeReference<List<Category>>() {})
              .block();
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage(), e);
    }
  }

}
