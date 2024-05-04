package com.project.parking_management.infrastructure.store.repository;

import com.project.parking_management.core.domain.entity.LogActivity;
import org.springframework.data.jdbc.repository.query.Query;

import java.util.List;

public interface LogActivityRepository extends BaseRepository<LogActivity, Long> {
    @Query("select log from log_activity log where log.vehicle_id = ?1")
    List<LogActivity> findByVehicleId(Long vehicleId);
}
