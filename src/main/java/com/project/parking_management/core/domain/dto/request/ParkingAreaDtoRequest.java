package com.project.parking_management.core.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingAreaDtoRequest {
    private Long id;
    private String name;
    private String type;
    private int totalSpace;
    private int prioritySpace;
    private int remainingSpace;
    private int remainingPrioritySpace;
    private int parkingLotId;
}
