package com.santt4na.rapidinner_delivery.enums;

public enum Role {
  ROLE_CUSTOMER,
  ROLE_DELIVERYMAN,
  ROLE_ADMIN;

  public static Role fromString(String role) {
    return Role.valueOf(role.toUpperCase());
  }
}
