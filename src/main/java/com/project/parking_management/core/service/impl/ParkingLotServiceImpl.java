package com.project.parking_management.core.service.impl;

import com.project.parking_management.core.domain.entity.ParkingLot;
import com.project.parking_management.core.service.ParkingLotService;
import com.project.parking_management.infastructure.store.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class ParkingLotServiceImpl implements ParkingLotService {
    ParkingLotRepository parkingLotRepository;

    public ParkingLotServiceImpl(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }


    @Override
    public List<ParkingLot> getAllParkingLots() {
        return parkingLotRepository.findAll();
    }

    @Override
    public ParkingLot getParkingLotById(Long id) {
        return parkingLotRepository.findById(id).orElse(null);
    }
}
