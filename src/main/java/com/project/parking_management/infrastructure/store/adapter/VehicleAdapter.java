package com.project.parking_management.infrastructure.store.adapter;

import com.project.parking_management.core.domain.entity.Vehicle;
import com.project.parking_management.core.port.store.VehicleStore;
import com.project.parking_management.infrastructure.store.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class VehicleAdapter extends BaseJPAAdapter<Vehicle, Long, VehicleRepository> implements VehicleStore {


    @Override
    public Vehicle getVehicle(Long id) {
        return this.get(id);
    }
}
