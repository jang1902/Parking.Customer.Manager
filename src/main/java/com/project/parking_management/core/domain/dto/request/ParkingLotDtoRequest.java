package com.project.parking_management.core.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLotDtoRequest {
    Long id;
    String name;
    String address;
    double latitude;
    double longitude;
}
