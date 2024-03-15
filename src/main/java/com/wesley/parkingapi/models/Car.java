package com.wesley.parkingapi.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(unique = true)
    private String licensePlate;

    @NotNull
    private String color;

    @NotNull
    private String model;

    private LocalDateTime check_in;
    private LocalDateTime check_out;

    private CarStatus status;

}
