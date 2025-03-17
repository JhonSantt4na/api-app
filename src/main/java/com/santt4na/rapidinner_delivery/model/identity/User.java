package com.santt4na.rapidinner_delivery.model.identity;

import java.time.Instant;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.santt4na.rapidinner_delivery.enums.Role;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@Table(name = "users")
public class User {

  @Version
  private Long version;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private Instant createdAt;

  @UpdateTimestamp
  @Column(name = "updated_at")
  private Instant updatedAt;

  @Column(unique = true, nullable = false)
  @NotBlank(message = "Email cannot be blank")
  @Email(message = "Invalid email format")
  private String email;

  @Column(nullable = false, length = 60) // BCrypt hash length
  @NotBlank(message = "Password cannot be blank")
  @Size(min = 8, message = "Password must be at least 8 characters")
  @JsonIgnore
  private String password;

  @Column(nullable = false, length = 100)
  @NotBlank(message = "Name cannot be blank")
  @Size(min = 2, max = 100)
  private String name;

  @Column(nullable = false)
  @NotBlank(message = "Phone cannot be blank")
  @Pattern(regexp = "^\\(?(\\d{2})\\)?[\\s-]?\\d{4,5}[\\s-]?\\d{4}$")
  private String phone;

  @Enumerated(EnumType.STRING)
  @Column(nullable = false, length = 20)
  private Role role;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Admin admin;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private Customer customer;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private DeliveryMan deliveryMan;

  public User(String name, String email, String password, Role role) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.role = role;
  }
}