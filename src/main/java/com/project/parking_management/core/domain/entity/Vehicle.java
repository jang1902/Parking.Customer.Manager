package com.project.parking_management.core.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleTypeEnum vehicleType;

    @Column(name = "plate", nullable = false)
    private String plate;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}