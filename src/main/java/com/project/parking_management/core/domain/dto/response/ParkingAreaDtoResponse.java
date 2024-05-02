package com.project.parking_management.core.domain.dto.response;

import com.project.parking_management.core.domain.entity.ParkingArea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingAreaDtoResponse {
    private Long id;
    private String name;
    private String type;
    private int total_space;
    private int priority_space;
    private int remaining_space;
    private int priority_remaining_space;
    private ParkingLotDtoResponse parkingLotDtoResponse;

    public ParkingArea toModel () {
        return new ParkingArea(id, name, type, total_space, priority_space, remaining_space,
                priority_remaining_space, parkingLotDtoResponse.toModel());
    }
}
