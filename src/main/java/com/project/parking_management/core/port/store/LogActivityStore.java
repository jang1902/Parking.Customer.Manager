package com.project.parking_management.core.port.store;

import com.project.parking_management.core.domain.entity.LogActivity;

import java.util.List;

public interface LogActivityStore {
    List<LogActivity> findByVehicleId(Long vehicleId);
    void saveLog(LogActivity logActivity);
}
