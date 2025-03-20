package com.santt4na.rapidinner_delivery.dtos.rolesDTO;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.santt4na.rapidinner_delivery.enums.Role;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "role")
@JsonSubTypes({
    @JsonSubTypes.Type(value = CustomerDTO.class, name = "ROLE_CUSTOMER"),
    @JsonSubTypes.Type(value = MerchantDTO.class, name = "ROLE_MERCHANT"),
    @JsonSubTypes.Type(value = DeliveryManDTO.class, name = "ROLE_DELIVERYMAN"),
    @JsonSubTypes.Type(value = AdminDTO.class, name = "ROLE_ADMIN")
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
public abstract class UserDTO {

  private Instant createAt;
  private Instant updateAt;
  private String name;
  private String email;
  private String password;
  private String phone;
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private Role role;

}