package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.dto.response.ParkingAreaDtoResponse;
import com.project.parking_management.core.domain.entity.ParkingArea;

import java.util.List;

public interface ParkingAreaService {
    List<ParkingAreaDtoResponse> getAllParkingAreas();

    ParkingArea getParkingAreaById(Long id);

    ParkingArea changeRemainingSpace(int remaining_space, Long id);

    int getPriorityRemainingSpaceSpaceById(Long id);

    int getRemainingSpace(Long id);

    ParkingArea changePriority(int priority_space, Long id);
}
