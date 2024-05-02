package com.project.parking_management.core.domain.dto.response;

import com.project.parking_management.core.domain.entity.Booking;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDtoResponse {
    private Long id;
    private Date estimated_starttime;
    private Date estimated_endtime;
    private Long vehicle_id;
    private ParkingAreaDtoResponse parkingAreaDtoResponse;

    public Booking toModel () {
        return new Booking(id, estimated_starttime, estimated_endtime, vehicle_id, parkingAreaDtoResponse.toModel());
    }
}
