package com.project.parking_management.core.domain.dto.response;

import com.project.parking_management.core.domain.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoResponse {
    private Long id;
    private LocalDateTime estimated_starttime;
    private LocalDateTime estimated_endtime;
    private Long vehicle_id;
    private Long parkingAreaId;

}
