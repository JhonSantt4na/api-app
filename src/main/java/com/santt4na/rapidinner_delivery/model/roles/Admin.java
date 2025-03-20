package com.santt4na.rapidinner_delivery.model.roles;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue("ADMIN")
public class Admin extends User {

  @ElementCollection
  private List<String> permissions;
  private boolean active;
  private LocalDateTime lastLogin;

  public Admin(String name, String email, String password, String phone, boolean active) {
    super(name, email, password, phone);
    this.active = active;
  }

}