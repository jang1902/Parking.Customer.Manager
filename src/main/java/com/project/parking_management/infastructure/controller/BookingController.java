package com.project.parking_management.infastructure.controller;

import com.project.parking_management.core.domain.dto.Enum.InvoiceTypeEnum;
import com.project.parking_management.core.domain.dto.request.BookingDtoRequest;
import com.project.parking_management.core.domain.dto.request.InvoiceDtoRequest;
import com.project.parking_management.core.domain.entity.Booking;
import com.project.parking_management.core.domain.entity.ParkingAreaTypeEnum;
import com.project.parking_management.core.service.BookingService;
import com.project.parking_management.core.service.ParkingAreaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    BookingService bookingService;
    ParkingAreaService parkingAreaService;

    @GetMapping("/")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @PostMapping("/")
    public ResponseEntity<String> addBooking(@RequestBody BookingDtoRequest bookingDtoRequest){
        return bookingService.createBooking(bookingDtoRequest);
    }
}
