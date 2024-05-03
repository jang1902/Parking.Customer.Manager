package com.project.parking_management.core.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLotDtoResponse {
    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}
