package com.project.parking_management.core.service.impl;

import com.project.parking_management.core.domain.entity.ParkingArea;
import com.project.parking_management.core.service.ParkingAreaService;
import com.project.parking_management.infastructure.store.repository.ParkingAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingAreaServiceImpl implements ParkingAreaService {
    @Autowired
    ParkingAreaRepository parkingAreaRepository;

    @Override
    public ParkingArea getParkingAreaById(Long id) {
        return parkingAreaRepository.findById(id).get();
    }

    @Override
    public ParkingArea changeRemainingSpace(int remainingSpace, Long id) {
        ParkingArea parkingAreaInDB = parkingAreaRepository.findById(id).get();
        parkingAreaInDB.setRemaining_space(remainingSpace);
        return parkingAreaRepository.save(parkingAreaInDB);
    }
}
