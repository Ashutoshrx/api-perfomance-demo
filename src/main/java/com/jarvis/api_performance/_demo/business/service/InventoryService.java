package com.jarvis.api_performance._demo.business.service;

import com.jarvis.api_performance._demo.data.entity.Inventory;

public interface InventoryService {
  Inventory fetchProductInventory(Integer productId);
}
