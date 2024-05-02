package com.project.parking_management.core.domain.dto.Response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkinglotDtoResponse {
    Long id;
    String name;
    String address;
    double latitude;
    double longitude;
}
