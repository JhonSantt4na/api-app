package com.santt4na.rapidinner_delivery.dtos.rolesDTO;

import java.time.Instant;

import com.santt4na.rapidinner_delivery.model.auxiliary.Address;

import jakarta.persistence.DiscriminatorValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("MERCHANT")
public class MerchantDTO extends UserDTO {

  private Instant createAt;
  private Instant updateAt;
  private Long id;
  private String cnpj;
  private Address businessAddress;
  private String companyName;
  private String paymentDetails;

}