package com.project.parking_management.infastructure.store.repository;

import com.project.parking_management.core.domain.entity.ParkingArea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkingAreaRepository extends JpaRepository<ParkingArea, Long> {
}
