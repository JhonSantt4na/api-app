package com.santt4na.rapidinner_delivery.enums;

public enum Role {
  ROLE_CUSTOMER("Customer"),
  ROLE_DELIVERYMAN("Deliveryman"),
  ROLE_MERCHANT("Merchant"),
  ROLE_ADMIN("Admin");

  private final String description;

  Role(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public static Role fromString(String role) {
    return Role.valueOf(role.toUpperCase());
  }
}
