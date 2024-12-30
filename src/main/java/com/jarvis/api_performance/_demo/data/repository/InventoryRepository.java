package com.jarvis.api_performance._demo.data.repository;

import com.jarvis.api_performance._demo.data.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Integer> {
  Inventory findByProductProductId(Integer productId);
}
