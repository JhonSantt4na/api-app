package com.santt4na.rapidinner_delivery.enums;

public enum ProductCategory {
    MEAL("Refeição"),
    BEVERAGE("Bebida"),
    DESSERT("Sobremesa"),
    APPETIZER("Entrada"),
    VEGETARIAN("Vegetariano"),
    VEGAN("Vegano"),
    SEAFOOD("Frutos do Mar"),
    MEATS("Carnes"),
    FAST_FOOD("Lanches Rápidos"),
    COMBO("Combos"),
    BREAKFAST("Café da Manhã"),
    SNACK("Petiscos");

    private final String description;

    ProductCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    public static ProductCategory fromString(String categoria) {
        return ProductCategory.valueOf(categoria.toUpperCase());
    }
}