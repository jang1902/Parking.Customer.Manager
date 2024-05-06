package com.project.parking_management.core.service.impl;

import com.project.parking_management.core.domain.dto.response.ParkingAreaDtoResponse;
import com.project.parking_management.core.domain.entity.ParkingArea;
import com.project.parking_management.core.service.ParkingAreaService;
import com.project.parking_management.infastructure.store.repository.ParkingAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParkingAreaServiceImpl implements ParkingAreaService {
    @Autowired
    ParkingAreaRepository parkingAreaRepository;

    @Override
    public List<ParkingAreaDtoResponse> getAllParkingAreas() {
        return parkingAreaRepository.findAll().stream().map(e -> e.toResponseDTO())
                .collect(Collectors.toList());

    }

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

    @Override
    public int getPriorityRemainingSpaceSpaceById(Long id) {
        return parkingAreaRepository.findPriorityRemainingSpaceById(id);
    }

    @Override
    public int getRemainingSpace(Long id) {
        return parkingAreaRepository.findRemainingSpaceById(id);
    }

    @Override
    public ParkingArea changePriority(int priority_space, Long id) {
        ParkingArea parkingAreaInDB = parkingAreaRepository.findById(id).get();
        parkingAreaInDB.setRemaining_space(priority_space);
        return parkingAreaRepository.save(parkingAreaInDB);
    }
}
