package com.project.parking_management.core.domain.dto.request;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MonthlyTickerRequest {
    private Long userId;
    private LocalDateTime expiredDate;
    private Double price;
    private Long vehicleId;
    private Long parkingLotId;
}
