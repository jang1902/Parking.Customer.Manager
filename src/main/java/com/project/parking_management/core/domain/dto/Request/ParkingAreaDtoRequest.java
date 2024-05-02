package com.project.parking_management.core.domain.dto.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingAreaDtoRequest {
    private Long id;
    private String name;
    private String type;
    private int total_space;
    private int priority_space;
    private int remaining_space;
    private int remaining_priority_space;
    private int parking_lot_id;
}
