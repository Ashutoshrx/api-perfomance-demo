package com.jarvis.api_performance._demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
  @Autowired
  private WebClient.Builder webclientBuilder;
  @Value("${category.base.url}")
  private String categoryBaseUri;
  @Value("${category.default.size}")
  private Integer size;

  @Bean("categoryIntegrationWebClient")
  public WebClient categoryIntegrationWebClient() {
    return WebClient.builder().baseUrl(categoryBaseUri).codecs(codecs ->
            codecs.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)).build();
//            codecs.defaultCodecs().maxInMemorySize(size)).build();
  }
}
