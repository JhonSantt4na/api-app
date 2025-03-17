package com.santt4na.rapidinner_delivery.model.order_management;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.santt4na.rapidinner_delivery.enums.OrderState;
import com.santt4na.rapidinner_delivery.model.Address;
import com.santt4na.rapidinner_delivery.model.Payment;
import com.santt4na.rapidinner_delivery.model.identity.Customer;
import com.santt4na.rapidinner_delivery.model.identity.DeliveryMan;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;

@Entity
@Log4j2
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_tb")
public class Order {

  @Version
  private Long version;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Instant updatedAt;

  @DecimalMin("0.0")
  @Digits(integer = 10, fraction = 2)
  private BigDecimal totalPrice;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private OrderState orderState;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<OrderProduct> orderProducts = new ArrayList<>();

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "payment_id", unique = true)
  private Payment payment;

  @ManyToOne
  @JoinColumn(name = "delivery_man_id")
  private DeliveryMan deliveryMan;

  @ManyToOne
  @JoinColumn(name = "delivery_address_id", nullable = false)
  private Address deliveryAddress;

  public Order(Customer customer, DeliveryMan deliveryMan) {
    this.customer = customer;
    this.deliveryMan = deliveryMan;
  }

}