package com.jarvis.api_performance._demo.business.service.impl;

import com.jarvis.api_performance._demo.business.service.CategoryService;
import com.jarvis.api_performance._demo.data.entity.Category;
import com.jarvis.api_performance._demo.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> fetchAllCategories() {
    return categoryRepository.findAll();
  }
}
