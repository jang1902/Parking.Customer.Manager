package com.project.parking_management.infastructure.controller;

import com.project.parking_management.core.domain.entity.Booking;
import com.project.parking_management.core.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    BookingService bookingService;

    @GetMapping("/hello")
    public String hello(){
        return "hello kien";
    }

    @GetMapping("/")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }
}
