package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.dto.request.MonthlyTickerRequest;
import com.project.parking_management.core.domain.dto.request.MonthlyTicketRequest2;
import org.springframework.http.ResponseEntity;

public interface TicketService {
    ResponseEntity<String> createMonthlyTicket(MonthlyTickerRequest request);
    int getTotalVehicleUsedMonthlyTicket(MonthlyTicketRequest2 request);
    int getTotalVehicleUsedDailyTicket(MonthlyTicketRequest2 request);
}
