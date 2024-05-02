package com.project.parking_management.core.domain.entity;

import com.project.parking_management.core.domain.dto.request.BookingDtoRequest;
import com.project.parking_management.core.domain.dto.request.ParkingLotDtoRequest;
import com.project.parking_management.core.domain.dto.response.ParkingLotDtoResponse;
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
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "logitude", nullable = false)
    private double longitude;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    public ParkingLotDtoRequest toRequestDTO () {
        return new ParkingLotDtoRequest(id, name, address, longitude, latitude);
    }

    public ParkingLotDtoResponse toResponseDTO () {
        return new ParkingLotDtoResponse(id, name, address, longitude, latitude);
    }
}
