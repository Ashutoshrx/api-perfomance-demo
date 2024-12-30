package com.jarvis.api_performance._demo.business.service;

import com.jarvis.api_performance._demo.data.entity.Price;

public interface PriceService {
  Price fetchProductPrice(Integer productId);
}
