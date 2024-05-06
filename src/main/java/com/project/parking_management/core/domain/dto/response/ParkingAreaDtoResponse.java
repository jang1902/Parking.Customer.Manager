package com.project.parking_management.core.domain.dto.response;

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
public class ParkingAreaDtoResponse {
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private ParkingAreaTypeEnum type;
    private int total_space;
    private int priority_space;
    private int remaining_space;
    private int priority_remaining_space;
    private Long parkingLotID;

}
