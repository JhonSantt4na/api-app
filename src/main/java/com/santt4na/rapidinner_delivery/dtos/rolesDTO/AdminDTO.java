package com.santt4na.rapidinner_delivery.dtos.rolesDTO;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@DiscriminatorValue("ADMIN")
public class AdminDTO extends UserDTO {

  private Instant createAt;
  private Instant updateAt;
  private Long id;
  @ElementCollection
  private List<String> permissions;
  private boolean active;
  private LocalDateTime lastLogin;
}