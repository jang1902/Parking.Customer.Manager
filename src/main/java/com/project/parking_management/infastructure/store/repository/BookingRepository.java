package com.project.parking_management.infastructure.store.repository;

import com.project.parking_management.core.domain.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
