package com.khazova.bicycles.model.dto;

public record ModelWithId(String name,
                          String id,
                          String clazz,
                          String manufacturer,
                          int diameter,
                          String frame,
                          String brake) {}
