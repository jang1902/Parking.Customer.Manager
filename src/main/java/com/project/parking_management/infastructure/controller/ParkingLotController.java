package com.project.parking_management.infastructure.controller;

import com.project.parking_management.core.domain.entity.ParkingLot;
import com.project.parking_management.core.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ParkingLotController {
    private final ParkingLotService parkingLotService;

    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @GetMapping("/parkingLots")
    public List<ParkingLot> findAll() {
        return parkingLotService.getAllParkingLots();
    }
}
