package com.project.parking_management.core.domain.dto.request;

import com.project.parking_management.core.domain.entity.VehicleTypeEnum;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;


@Data
public class MonthlyTicketRequest2 {
    private Long parkingLotId;
    private LocalDateTime date;
    private VehicleTypeEnum type;
}
