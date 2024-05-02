package com.project.parking_management.core.port.store;

import com.project.parking_management.core.domain.entity.Vehicle;

public interface VehicleStore {
    Vehicle getVehicle(Long id);
}
