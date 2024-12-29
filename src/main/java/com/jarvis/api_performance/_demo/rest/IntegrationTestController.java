package com.jarvis.api_performance._demo.rest;

import com.jarvis.api_performance._demo.data.entity.Category;
import com.jarvis.api_performance._demo.integration.CategoryTestIntegration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IntegrationTestController {
  @Autowired
  private CategoryTestIntegration categoryTestIntegration;

  @GetMapping("/v1/integration/categories")
  List<Category> getIntegrationCategories() {
    return categoryTestIntegration.invokeCategoryService();
  }

}
