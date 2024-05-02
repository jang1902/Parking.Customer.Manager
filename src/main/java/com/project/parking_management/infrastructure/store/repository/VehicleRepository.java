package com.project.parking_management.infrastructure.store.repository;

import com.project.parking_management.core.domain.entity.Vehicle;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends BaseRepository<Vehicle, Long> {

}
