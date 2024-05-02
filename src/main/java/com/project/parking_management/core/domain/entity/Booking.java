package com.project.parking_management.core.domain.entity;

import com.project.parking_management.core.domain.dto.request.BookingDtoRequest;
import com.project.parking_management.core.domain.dto.response.BookingDtoResponse;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "estimated_starttime", nullable = false)
    private Date estimated_starttime;

    @Column(name = "estimated_endtime", nullable = false)
    private Date estimated_endtime;

    @Column(name = "vehicle_id", nullable = false)
    private Long vehicle_id;

    @ManyToOne
    @JoinColumn(name = "parking_area_id", nullable = false)
    private ParkingArea parking_area;

    public BookingDtoRequest toRequestDTO () {
        return new BookingDtoRequest(id, estimated_starttime, estimated_endtime,
                vehicle_id, parking_area.toRequestDTO());
    }

    public BookingDtoResponse toResponseDTO () {
        return new BookingDtoResponse(id, estimated_starttime, estimated_endtime,
                vehicle_id, parking_area.toResponseDTO());
    }
}
