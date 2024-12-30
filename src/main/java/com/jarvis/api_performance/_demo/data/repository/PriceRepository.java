package com.jarvis.api_performance._demo.data.repository;

import com.jarvis.api_performance._demo.data.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer> {
  Price findByProductProductId(Integer productId);
}
