package com.santt4na.rapidinner_delivery.enums;

public enum PaymentMethod {
  CREDIT_CARD("Cartão de Crédito"),
  DEBIT_CARD("Cartão de Débito"),
  CASH("Dinheiro"),
  PIX("PIX"),
  BANK_TRANSFER("Transferência Bancária"),
  BOLETO("Boleto");

  private final String description;

  PaymentMethod(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }
}
