package com.project.parking_management.infastructure.controller;

import com.project.parking_management.core.domain.dto.request.BookingDtoRequest;
import com.project.parking_management.core.domain.dto.response.BookingDtoResponse;
import com.project.parking_management.core.domain.entity.Booking;
import com.project.parking_management.core.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    BookingService bookingService;

    @GetMapping("/")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @GetMapping("/{id}")
    public BookingDtoResponse getBookingById(@PathVariable (name = "id") Long id){
        return bookingService.getBookingById(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> addBooking(@RequestBody BookingDtoRequest bookingDtoRequest){
        return bookingService.createBooking(bookingDtoRequest);
    }
}
