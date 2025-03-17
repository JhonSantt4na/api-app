package com.santt4na.rapidinner_delivery.model;

import com.santt4na.rapidinner_delivery.model.identity.Customer;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Version;
import jakarta.validation.constraints.NotBlank;
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
public class Address {

  @Version
  private Long version;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank(message = "Street cannot be blank")
  @Column(length = 150)
  private String street;

  @NotBlank(message = "City cannot be blank")
  @Column(length = 50)
  private String city;

  @NotBlank(message = "State cannot be blank")
  @Column(length = 2)
  private String state;

  @NotBlank(message = "Number cannot be blank")
  @Pattern(regexp = "^\\d+[A-Za-z]?$", message = "Invalid format. Valid examples: 123, 456B")
  @Column(length = 10)
  private String number;

  @NotBlank(message = "ZIP code cannot be blank")
  @Pattern(regexp = "^\\d{5}-\\d{3}$", message = "Invalid format. Use XXXXX-XXX")
  @Column(name = "zip_code", length = 9)
  private String zipCode;

  @Column(length = 50)
  @NotBlank(message = "Country cannot be blank")
  private String country; // Depois add enum CountryCode

  @Column(name = "is_primary")
  private boolean primary;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "customer_id")
  private Customer customer;

  // private String complement;
  // private String referencePoint;
  // private AddressType type; Enum
}