package com.khazova.bicycles.model.entity;

import com.khazova.bicycles.enums.Clazz;
import com.khazova.bicycles.enums.FrameType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bicycle")
@Data
public class Bicycle {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "clazz")
    @Enumerated(EnumType.STRING)
    private Clazz clazz;

    @Column(name = "manufacturer")
    private String manufacturer; //производитель

    @Column(name = "diameter")
    private int diameter; //диаметр колеса

    @Column(name = "frame")
    @Enumerated(EnumType.STRING)
    private FrameType frame; //тип рамы

    @Column(name = "brake")
    private String brake; //тип тормозов
}
