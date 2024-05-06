package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.entity.ParkingLot;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ParkingLotService {
    List<ParkingLot> getAllParkingLots();

    ParkingLot getParkingLotById(Long id);
}
