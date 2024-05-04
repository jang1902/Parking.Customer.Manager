package com.project.parking_management.infrastructure.controller;

import com.project.parking_management.core.domain.dto.request.MonthlyTickerRequest;
import com.project.parking_management.core.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/ticket")
public class TicketController {

    private final TicketService ticketService;

    @PostMapping
    public ResponseEntity<String> createMonthlyTicket(@RequestBody MonthlyTickerRequest request) {
        return ticketService.createMonthlyTicket(request);
    }
}
