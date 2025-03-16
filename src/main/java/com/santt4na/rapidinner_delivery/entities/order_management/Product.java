package com.santt4na.rapidinner_delivery.entities.order_management;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.santt4na.rapidinner_delivery.enums.ProductCategory;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Version;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

  @Version
  private Long version;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, length = 50)
  @NotBlank(message = "SKU cannot be blank")
  private String sku;

  @Column(nullable = false, length = 200, unique = true)
  @NotBlank(message = "Product name cannot be blank")
  private String name;

  @Column(nullable = false)
  @Min(value = 0, message = "Quantity should be non-negative")
  private Integer stockQuantity;

  @Column(precision = 10, scale = 2, nullable = false)
  @DecimalMin("0.00")
  private BigDecimal price;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private ProductCategory category;

  @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderProduct> orderProducts = new ArrayList<>();

  @Column(length = 1000)
  private String description;

  // private String barcode;
  // private String imageUrl;
  // private LocalDateTime addedDate;
}