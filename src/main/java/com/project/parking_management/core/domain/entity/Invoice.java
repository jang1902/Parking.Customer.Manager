package com.project.parking_management.core.domain.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private VehicleTypeEnum vehicleType;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Vehicle vehicle;

    @Column(nullable = false)
    private Long parkingLotId;
}
