package com.santt4na.rapidinner_delivery.model.roles;

import java.util.ArrayList;
import java.util.List;

import com.santt4na.rapidinner_delivery.model.auxiliary.Address;
import com.santt4na.rapidinner_delivery.model.orderManagement.Order;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("CUSTOMER")
public class Customer extends User {

  @Pattern(regexp = "\\d{11}")
  @Column(unique = true, length = 11)
  private String cpf;

  @Embedded
  private List<Address> addresses = new ArrayList<>();

  @Embedded
  private List<Order> orders = new ArrayList<>();

  public Customer(String email, String password, String name, String phone, String cpf) {
    super(email, password, name, phone);
    this.cpf = cpf;
  }

}