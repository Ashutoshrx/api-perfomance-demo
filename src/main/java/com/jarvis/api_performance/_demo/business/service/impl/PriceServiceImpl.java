package com.jarvis.api_performance._demo.business.service.impl;

import com.jarvis.api_performance._demo.business.service.PriceService;
import com.jarvis.api_performance._demo.data.entity.Price;
import com.jarvis.api_performance._demo.data.repository.PriceRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.jarvis.api_performance._demo.utility.Delayer.addDelay;

@Slf4j
@Service
public class PriceServiceImpl implements PriceService {
  @Autowired
  private PriceRepository priceRepository;

  @Override
  public Price fetchProductPrice(Integer productId) {
    try {
      log.info("Started fetching price for productId:{}", productId);
      addDelay();
      return priceRepository.findByProductProductId(productId);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
