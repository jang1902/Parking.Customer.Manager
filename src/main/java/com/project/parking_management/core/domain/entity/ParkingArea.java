package com.project.parking_management.core.domain.entity;

import com.project.parking_management.core.domain.dto.request.ParkingAreaDtoRequest;
import com.project.parking_management.core.domain.dto.response.ParkingAreaDtoResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingArea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ParkingAreaTypeEnum type;

    @Column(name = "total_space", nullable = false)
    private int total_space;

    @Column(name = "priority_space", nullable = false)
    private int priority_space;

    @Column(name = "remaining_space", nullable = false)
    private int remaining_space;

    @Column(name = "priority_remaining_space", nullable = false)
    private int priority_remaining_space;

    @ManyToOne
    @JoinColumn(name = "parking_lot_id", nullable = false)
    private ParkingLot parking_lot;

    public ParkingAreaDtoResponse toResponseDTO () {
        return new ParkingAreaDtoResponse(id, name, type, total_space, priority_space, remaining_space,
                priority_remaining_space, parking_lot.getId());
    }
}
