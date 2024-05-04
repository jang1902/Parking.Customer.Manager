package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.dto.request.MonthlyTickerRequest;
import org.springframework.http.ResponseEntity;

public interface TicketService {
    ResponseEntity<String> createMonthlyTicket(MonthlyTickerRequest request);
}
