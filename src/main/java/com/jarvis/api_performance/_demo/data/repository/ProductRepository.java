package com.jarvis.api_performance._demo.data.repository;

import com.jarvis.api_performance._demo.data.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
  Set<Product> findByCategoryId(Integer categoryId);
}
