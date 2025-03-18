package com.santt4na.rapidinner_delivery.model;

import com.santt4na.rapidinner_delivery.enums.VehicleType;
import com.santt4na.rapidinner_delivery.model.identity.DeliveryMan;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Vehicle {

  @Version
  private Long version;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  @NotNull(message = "Vehicle type cannot be null")
  private VehicleType type;

  @NotBlank(message = "Model cannot be blank")
  @Column(length = 50)
  private String model;

  @NotBlank(message = "License plate cannot be blank")
  @Pattern(regexp = "[A-Z]{3}-\\d{4}[A-Z]?", message = "Invalid format. Use ABC-1234 ou ABC1D23")
  @Column(unique = true, length = 8)
  private String licensePlate;

  @Min(value = 1900, message = "Year must be after 1900")
  private int year;

  @Column(length = 30)
  private String color;

  @OneToOne(mappedBy = "vehicle")
  private DeliveryMan deliveryMan;

  // private BigDecimal mileage;
}