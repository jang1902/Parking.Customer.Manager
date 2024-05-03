package com.project.parking_management.core.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLotDtoRequest {
    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}
