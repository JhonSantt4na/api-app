package com.santt4na.rapidinner_delivery.enums;

public enum PaymentState {
  PENDING("Pagamento pendente"),
  PAID("Pago"),
  FAILED("Falha no pagamento"),
  CANCELED("Cancelado"),
  REFUNDED("Reembolsado"),
  PROCESSING("Em processamento");

  private final String description;

  PaymentState(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
