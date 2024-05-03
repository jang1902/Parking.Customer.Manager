package com.project.parking_management.core.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TicketDtoResponse {

    private Long id;
    private LocalDateTime expiredDate;
    private Long vehicleId;
}
