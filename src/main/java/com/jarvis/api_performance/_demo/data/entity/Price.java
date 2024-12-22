package com.jarvis.api_performance._demo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "price")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
public class Price implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private BigDecimal price;
  private LocalDateTime valid_from;
  private LocalDateTime valid_to;
  private String status;
  @OneToOne
  @JoinColumn(name = "product_id")
  @JsonIgnore
  private Product product;
}