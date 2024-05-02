package com.project.parking_management.core.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private VehicleTypeEnum vehicleType;

    @Column(nullable = false)
    private String plate;

    @ManyToOne
    @JoinColumn(nullable = false)
    private User user;
}