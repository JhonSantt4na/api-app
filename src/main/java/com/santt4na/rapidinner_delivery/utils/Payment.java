package com.santt4na.rapidinner_delivery.utils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.santt4na.rapidinner_delivery.entities.order_management.Order;
import com.santt4na.rapidinner_delivery.enums.PaymentMethod;
import com.santt4na.rapidinner_delivery.enums.PaymentState;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {

  @Version
  private Long version;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "payment_expires_at")
  private LocalDateTime paymentExpiresAt;

  @Column(name = "payment_at")
  private LocalDateTime paymentAt;

  @Column(unique = true, updatable = false, length = 50)
  @NotBlank(message = "Transaction ID cannot be blank")
  private String transactionId;

  @Column(precision = 10, scale = 2, nullable = false)
  @Positive(message = "Payment value must be positive")
  private BigDecimal value;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private PaymentState paymentState;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private PaymentMethod paymentMethod;

  @OneToOne(mappedBy = "payment")
  private Order order;

  // private String gatewayTransactionId;
  // private Integer installments;
  // private String payerDocument;
}