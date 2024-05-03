package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.dto.request.VehicleDtoRequest;
import com.project.parking_management.core.domain.dto.response.VehicleDtoResponse;

public interface VehicleService {
    VehicleDtoResponse getVehicle(VehicleDtoRequest vehicleDtoRequest);
}
