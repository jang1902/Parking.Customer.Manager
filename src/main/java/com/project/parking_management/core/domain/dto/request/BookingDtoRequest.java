package com.project.parking_management.core.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingDtoRequest {
    private Long id;
    private LocalDateTime estimatedStartTime;
    private LocalDateTime estimatedEndTime;
    private Long parkingAreaId;
    private Long vehicleId;
}
