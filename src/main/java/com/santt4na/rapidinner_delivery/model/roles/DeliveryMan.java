package com.santt4na.rapidinner_delivery.model.roles;

import java.math.BigDecimal;

import com.santt4na.rapidinner_delivery.model.auxiliary.Location;
import com.santt4na.rapidinner_delivery.model.auxiliary.Vehicle;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("DELIVERY_MAN")
public class DeliveryMan extends User {
  @DecimalMin("0.0")
  @DecimalMax("5.0")
  @Column(precision = 3, scale = 2)
  private BigDecimal rating;

  private String cnh;

  private boolean available;

  @Embedded
  private Location location;

  @Embedded
  private Vehicle vehicle;

  public DeliveryMan(String email, String password, String name, String phone,
      @DecimalMin("0.0") @DecimalMax("5.0") BigDecimal rating, String cnh, boolean available,
      Location location, Vehicle vehicle) {
    super(email, password, name, phone);
    this.rating = rating;
    this.cnh = cnh;
    this.available = available;
    this.location = location;
    this.vehicle = vehicle;
  }

}
