package com.project.parking_management.infrastructure.controller;

import com.project.parking_management.core.domain.dto.request.MonthlyTickerRequest;
import com.project.parking_management.core.domain.dto.request.MonthlyTicketRequest2;
import com.project.parking_management.core.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    @RequestMapping("/api/v1/ticket")
    public ResponseEntity<String> createMonthlyTicket(@RequestBody MonthlyTickerRequest request) {
        return ticketService.createMonthlyTicket(request);
    }

    @GetMapping("api/v1/ticket/getTotalVehicleUsedMonthlyTicket")
    public ResponseEntity<Integer> getTotalVehicleUsedMonthlyTicket(@RequestBody MonthlyTicketRequest2 request2) {
        int result = ticketService.getTotalVehicleUsedMonthlyTicket(request2);
        return ResponseEntity.ok(result);
    }

    @GetMapping("api/v1/ticket/getTotalVehicleUsedDailyTicket")
    public ResponseEntity<Integer> getTotalVehicleUsedDailyTicket(@RequestBody MonthlyTicketRequest2 request2) {
        int result = ticketService.getTotalVehicleUsedDailyTicket(request2);
        return ResponseEntity.ok(result);
    }
}
