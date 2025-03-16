package com.santt4na.rapidinner_delivery.enums;

public enum VehicleType {
  MOTORCYCLE("Moto"),
  CAR("Carro"),
  BICYCLE("Bicicleta");

  private final String description;

  VehicleType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public static VehicleType fromString(String type) {
    return VehicleType.valueOf(type.toUpperCase());
  }
}