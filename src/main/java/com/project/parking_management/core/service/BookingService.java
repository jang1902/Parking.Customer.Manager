package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.dto.request.BookingDtoRequest;
import com.project.parking_management.core.domain.dto.request.InvoiceDtoRequest;
import com.project.parking_management.core.domain.dto.request.VehicleDtoRequest;
import com.project.parking_management.core.domain.dto.response.BookingDtoResponse;
import com.project.parking_management.core.domain.dto.response.InvoiceDtoResponse;
import com.project.parking_management.core.domain.dto.response.UserDtoResponse;
import com.project.parking_management.core.domain.dto.response.VehicleDtoResponse;
import com.project.parking_management.core.domain.entity.Booking;

import java.util.List;

public interface BookingService {
    List<Booking> getAllBooking();

    BookingDtoResponse createBooking (BookingDtoRequest bookingDtoRequest);
    VehicleDtoResponse findVehicleByPlate (VehicleDtoRequest vehicleDtoRequest);
    int checkRemaningSpace (Long parkingAreaId);
    UserDtoResponse getUserByUsername (String username);
    InvoiceDtoResponse createInvoice (InvoiceDtoRequest invoiceDtoRequest);
}
