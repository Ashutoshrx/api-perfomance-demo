package com.jarvis.api_performance._demo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;

@Entity
@Table(name = "inventory")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
public class Inventory implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer inventoryId;
  @Column(name = "ware_house_id")
  private Integer wareHouseId;
  @Column(name = "available_quantity")
  private Integer availableQuantity;
  @Column(name = "reserved_quantity")
  private Integer reservedQuantity;
  @Column(name = "status")
  private String status;
  @OneToOne
  @JoinColumn(name = "product_id")
  @JsonIgnore
  private Product product;
}