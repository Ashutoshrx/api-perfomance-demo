package com.jarvis.api_performance._demo.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "category")
@DynamicInsert
@DynamicUpdate
@Setter
@Getter
public class Category implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String categoryName;
  @Column(name = "type")
  private String categoryType;
  @Column(name = "status")
  private String categoryStatus;
  @OneToMany(mappedBy = "category")
  @JsonIgnore
  private Set<Product> products;
}