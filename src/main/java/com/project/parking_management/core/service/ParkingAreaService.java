package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.entity.ParkingArea;

public interface ParkingAreaService {
    ParkingArea getParkingAreaById(Long id);
    ParkingArea changeRemainingSpace(int remaining_space, Long id);
}
