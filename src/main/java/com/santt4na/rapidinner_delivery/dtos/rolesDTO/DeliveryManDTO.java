package com.santt4na.rapidinner_delivery.dtos.rolesDTO;

import java.math.BigDecimal;
import java.time.Instant;

import com.santt4na.rapidinner_delivery.model.auxiliary.Location;
import com.santt4na.rapidinner_delivery.model.auxiliary.Vehicle;

import jakarta.persistence.DiscriminatorValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("DELIVERYMAN")
public class DeliveryManDTO extends UserDTO {

  private Instant createAt;
  private Instant updateAt;
  private Long id;
  private BigDecimal rating;
  private String cnh;
  private boolean available;
  private Location location;
  private Vehicle vehicle;

}
