package com.project.parking_management.core.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class BookingDtoResponse {
    private Long id;
    private LocalDateTime estimated_starttime;
    private LocalDateTime estimated_endtime;
    private Long parking_area_id;
    private Long vehicle_id;
}
