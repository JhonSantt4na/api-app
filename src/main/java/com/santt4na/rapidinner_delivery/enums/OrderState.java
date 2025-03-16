package com.santt4na.rapidinner_delivery.enums;

public enum OrderState {
  PENDING("Pedido pendente"),
  CONFIRMED("Pedido confirmado"),
  PREPARING("Preparando pedido"),
  READY_FOR_PICKUP("Pronto para retirada"),
  OUT_FOR_DELIVERY("Saiu para entrega"),
  DELIVERED("Entregue"),
  CANCELED("Cancelado");

  private final String description;

  OrderState(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
