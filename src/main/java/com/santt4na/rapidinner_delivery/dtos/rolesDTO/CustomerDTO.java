package com.santt4na.rapidinner_delivery.dtos.rolesDTO;

import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.santt4na.rapidinner_delivery.model.auxiliary.Address;
import com.santt4na.rapidinner_delivery.model.orderManagement.Order;

import jakarta.persistence.DiscriminatorValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("CUSTOMER")
public class CustomerDTO extends UserDTO {

  private Instant createAt;
  private Instant updateAt;
  private Long id;
  private String cpf;
  private LocalDate birthDate;
  private List<Address> addresses = new ArrayList<>();
  private List<Order> orders = new ArrayList<>();

}