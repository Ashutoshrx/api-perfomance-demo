package com.jarvis.api_performance._demo.business.service.impl;

import com.jarvis.api_performance._demo.business.service.InventoryService;
import com.jarvis.api_performance._demo.data.entity.Inventory;
import com.jarvis.api_performance._demo.data.repository.InventoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jarvis.api_performance._demo.utility.Delayer.addDelay;

@Service
public class InventoryServiceImpl implements InventoryService {
  private static final Logger log = LoggerFactory.getLogger(InventoryServiceImpl.class);
  @Autowired
  private InventoryRepository inventoryRepository;

  @Override
  public Inventory fetchProductInventory(Integer productId) {
    try {
      log.info("Started fetching inventory based on productId:{}", productId);
      addDelay();
      return inventoryRepository.findByProductProductId(productId);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
