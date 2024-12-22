package com.jarvis.api_performance._demo.data.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "product")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
public class Product implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer productId;
  @Column(name = "name")
  private String productName;
  @Column(name = "description")
  private String description;
  @Column(name = "status")
  private String status;
  @ManyToOne
  @JoinColumn(name = "category_id")
  private Category category;
  @OneToOne(mappedBy = "product")
  private Inventory inventory;
  @OneToOne(mappedBy = "product")
  private Price price;
}