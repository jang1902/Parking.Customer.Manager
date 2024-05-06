package com.project.parking_management.core.service;

import org.springframework.http.ResponseEntity;

public interface CustomerService {
    ResponseEntity<String> enterParkingLot(Long ticketId, Long parkingLotId);
    ResponseEntity<String> exitParkingLot(Long id, Long parking_lot_id);
}
