package com.jarvis.api_performance._demo.business.service.impl;

import com.jarvis.api_performance._demo.business.service.CategoryService;
import com.jarvis.api_performance._demo.data.entity.Category;
import com.jarvis.api_performance._demo.data.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jarvis.api_performance._demo.utility.Delayer.addDelay;

@Service
public class CategoryServiceImpl implements CategoryService {
  private static final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> fetchAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  public Category fetchProductCategory(Integer productId) {
    try {
      log.info("Started fetching category based on productId:{}", productId);
      addDelay();
      return categoryRepository.findByProductsProductId(productId);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
