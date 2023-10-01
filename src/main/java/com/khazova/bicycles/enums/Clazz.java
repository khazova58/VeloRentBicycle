package com.khazova.bicycles.enums;

public enum Clazz {
    HYBRID("Гибрид"),
    CITY("Городской"),
    CRUISE("Круизер"),
    FOLDING("Складной");

    private final String description;

    Clazz(String description) {
        this.description = description;
    }
}
