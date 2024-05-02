package com.project.parking_management.core.domain.dto.request;

import com.project.parking_management.core.domain.entity.ParkingLot;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLotDtoRequest {

    private Long id;
    private String name;
    private String address;
    private double longitude;
    private double latitude;

    public ParkingLot toModel () {
        return new ParkingLot(id, name, address, longitude, latitude);
    }
}
