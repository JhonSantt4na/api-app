package com.santt4na.rapidinner_delivery.model.roles;

import com.santt4na.rapidinner_delivery.model.auxiliary.Address;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@DiscriminatorValue("MERCHANT")
public class Merchant extends User {
  @Column(unique = true, length = 14)
  private String cnpj;

  @Embedded
  private Address businessAddress;

  private String companyName;

  public Merchant(String email, String password, String name, String phone, String cnpj, Address businessAddress,
      String companyName) {
    super(email, password, name, phone);
    this.cnpj = cnpj;
    this.businessAddress = businessAddress;
    this.companyName = companyName;
  }

}