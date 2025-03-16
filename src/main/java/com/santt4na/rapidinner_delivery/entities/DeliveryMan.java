package com.santt4na.rapidinner_delivery.entities;

import com.santt4na.rapidinner_delivery.utils.Location;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryMan {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String vehicle;
  private boolean available = false;
  private Location location;

  @OneToOne
  @JoinColumn(name = "user_id")
  @MapsId
  private User user;

  public boolean isAvailable(boolean available) {
    return this.available;
  }
}
