package com.santt4na.rapidinner_delivery.model.identity;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.santt4na.rapidinner_delivery.model.Location;
import com.santt4na.rapidinner_delivery.model.Vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeliveryMan {

  @Version
  private Long version;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Min(0)
  @Max(5)
  @Column(precision = 3, scale = 2)
  private BigDecimal rating;

  @PastOrPresent
  private LocalDate hireDate;
  private boolean available;

  @Embedded
  private Location location;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "vehicle_id")
  private Vehicle vehicle;

  @OneToOne
  @JoinColumn(name = "user_id")
  private User user;

}