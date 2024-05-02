package com.project.parking_management.core.domain.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkinglotDtoRequest {
    Long id;
    String name;
    String address;
    double latitude;
    double longitude;
}
