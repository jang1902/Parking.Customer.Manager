package com.project.parking_management.core.domain.dto.request;

import com.project.parking_management.core.domain.entity.ParkingArea;
import com.project.parking_management.core.domain.entity.ParkingAreaTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingAreaDtoRequest {

    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ParkingAreaTypeEnum type;
    private int total_space;
    private int priority_space;
    private int remaining_space;
    private int priority_remaining_space;
    private ParkingLotDtoRequest parkingLotDtoRequest;

    public ParkingArea toModel () {
        return new ParkingArea(id, name, type, total_space, priority_space, remaining_space,
                priority_remaining_space, parkingLotDtoRequest.toModel());
    }
}
