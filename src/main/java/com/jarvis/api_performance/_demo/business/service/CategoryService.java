package com.jarvis.api_performance._demo.business.service;

import com.jarvis.api_performance._demo.data.entity.Category;

import java.util.List;

public interface CategoryService {
  List<Category> fetchAllCategories();
}
