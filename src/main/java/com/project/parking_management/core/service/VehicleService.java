package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.dto.Request.VehicleDtoRequest;
import com.project.parking_management.core.domain.dto.Response.VehicleDtoResponse;

public interface VehicleService {
    VehicleDtoResponse getVehicle(VehicleDtoRequest vehicleDtoRequest);
}
