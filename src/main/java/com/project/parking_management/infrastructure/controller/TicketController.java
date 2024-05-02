package com.project.parking_management.infrastructure.controller;

import com.project.parking_management.core.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;
}
