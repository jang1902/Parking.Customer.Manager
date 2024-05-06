package com.project.parking_management.infastructure.store.repository;

import com.project.parking_management.core.domain.entity.ParkingArea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParkingAreaRepository extends JpaRepository<ParkingArea, Long> {
    @Query(value = "SELECT priority_remaining_space FROM parking_area WHERE id = ?1", nativeQuery = true)
    int findPriorityRemainingSpaceById(Long id);

    @Query(value = "SELECT remaining_space FROM parking_area WHERE id = ?1", nativeQuery = true)
    int findRemainingSpaceById(Long id);
}
