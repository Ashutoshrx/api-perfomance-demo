package com.jarvis.api_performance._demo.data.repository;

import com.jarvis.api_performance._demo.data.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
  Category findByProductsProductId(Integer productId);
}
