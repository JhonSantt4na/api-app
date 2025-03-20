package com.santt4na.rapidinner_delivery.model.roles;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
@NoArgsConstructor
public abstract class User {

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
  private String email;

  @Column(nullable = false, length = 60)
  private String password;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false)
  private String phone;

  public User(String email, String password, String name, String phone) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.phone = phone;
  }

}