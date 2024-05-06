package com.project.parking_management.core.service.impl;

import com.project.parking_management.core.domain.dto.request.BookingDtoRequest;
import com.project.parking_management.core.domain.dto.request.InvoiceDtoRequest;
import com.project.parking_management.core.domain.dto.request.VehicleDtoRequest;
import com.project.parking_management.core.domain.dto.response.BookingDtoResponse;
import com.project.parking_management.core.domain.dto.response.InvoiceDtoResponse;
import com.project.parking_management.core.domain.dto.response.UserDtoResponse;
import com.project.parking_management.core.domain.dto.response.VehicleDtoResponse;
import com.project.parking_management.core.domain.entity.Booking;
import com.project.parking_management.core.service.BookingService;
import com.project.parking_management.core.service.ParkingAreaService;
import com.project.parking_management.infastructure.store.repository.BookingRepository;
import com.project.parking_management.infastructure.store.repository.ParkingAreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    BookingRepository bookingRepository;
    ParkingAreaRepository parkingAreaRepository;
    ParkingAreaService parkingAreaService;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingDtoResponse createBooking(BookingDtoRequest bookingDtoRequest) {
        Booking booking = Booking.builder()
                .estimated_starttime(bookingDtoRequest.getEstimated_starttime())
                .estimated_endtime(bookingDtoRequest.getEstimated_endtime())
                .vehicle_id(bookingDtoRequest.getVehicle_id())
                .parking_area(parkingAreaRepository.findById(bookingDtoRequest.getParking_area_id()).get())
                .build();
        bookingRepository.save(booking);
        BookingDtoResponse bookingDtoResponse = new BookingDtoResponse();
        bookingDtoResponse = booking.toResponseDTO();
        return bookingDtoResponse;
    }

    @Override
    public int checkRemaningSpace(Long parkingAreaId) {
        return parkingAreaRepository.findById(parkingAreaId).get().getRemaining_space();
    }

    @Override
    public VehicleDtoResponse findVehicleByPlate(VehicleDtoRequest vehicleDtoRequest) {
        return null;
    }

    @Override
    public UserDtoResponse getUserByUsername(String username) {
        return null;
    }

    @Override
    public InvoiceDtoResponse createInvoice(InvoiceDtoRequest invoiceDtoRequest) {
        return null;
    }
}
