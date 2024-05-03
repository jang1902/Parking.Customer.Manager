package com.project.parking_management.core.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingDtoResponse {
    private Long id;
    private LocalDateTime estimatedStartTime;
    private LocalDateTime estimatedEndTime;
    private Long parkingAreaId;
    private Long vehicleId;
}