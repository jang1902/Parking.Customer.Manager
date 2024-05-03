package com.project.parking_management.core.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLotDtoResponse {
    Long id;
    String name;
    String address;
    double latitude;
    double longitude;
}
