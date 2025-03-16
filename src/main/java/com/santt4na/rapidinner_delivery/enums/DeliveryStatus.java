package com.santt4na.rapidinner_delivery.enums;

public enum DeliveryStatus {
  PENDING("Pendente"),
  IN_TRANSIT("Em Rota"),
  DELIVERED("Entregue"),
  CANCELED("Cancelado"),
  RETURNED("Devolvido"),
  FAILED("Falhou");

  private final String description;

  DeliveryStatus(String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }
}
