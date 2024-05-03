package com.project.parking_management.core.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class TicketDtoRequest {

    private Long id;
    private LocalDateTime expiredDate;
    private Long vehicleId;
}
