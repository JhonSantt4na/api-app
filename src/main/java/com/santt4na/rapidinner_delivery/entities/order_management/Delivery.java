package com.santt4na.rapidinner_delivery.entities.order_management;

import java.time.LocalDateTime;

import com.santt4na.rapidinner_delivery.entities.identity.Customer;
import com.santt4na.rapidinner_delivery.entities.identity.DeliveryMan;
import com.santt4na.rapidinner_delivery.enums.DeliveryStatus;
import com.santt4na.rapidinner_delivery.utils.Location;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

  @Version
  private Long version;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(unique = true, updatable = false, length = 10)
  @NotBlank(message = "Tracking code cannot be blank")
  @Pattern(regexp = "^[A-Z0-9]{3}-[A-Z0-9]{6}$", message = "Invalid tracking code. Use XXX-XXXXXX")
  private String trackingCode;

  @PastOrPresent
  private LocalDateTime deliveredAt;

  @Future
  private LocalDateTime estimatedAt;

  private LocalDateTime startedAt;

  @Embedded
  private Location location;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private DeliveryStatus deliveryStatus;

  @ManyToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

  @ManyToOne
  @JoinColumn(name = "delivery_man_id")
  private DeliveryMan deliveryMan;

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;
}