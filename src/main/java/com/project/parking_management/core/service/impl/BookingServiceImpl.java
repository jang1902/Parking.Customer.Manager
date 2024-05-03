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
import com.project.parking_management.infastructure.store.repository.BookingRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    BookingRepository bookingRepository;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public BookingDtoResponse createBooking(BookingDtoRequest bookingDtoRequest) {
        return null;
    }

    @Override
    public VehicleDtoResponse findVehicleByPlate(VehicleDtoRequest vehicleDtoRequest) {
        return null;
    }

    @Override
    public int checkRemaningSpace(Long parkingAreaId) {
        return 0;
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
