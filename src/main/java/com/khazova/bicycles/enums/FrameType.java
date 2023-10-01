package com.khazova.bicycles.enums;

public enum FrameType {
    MALE("Мужской"),
    FEMALE("Женский"),
    UNIVERSAL("Универсал");

    private final String description;

    FrameType(String description) {
        this.description = description;
    }
}
