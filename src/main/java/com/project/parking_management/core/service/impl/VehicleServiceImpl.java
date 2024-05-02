package com.project.parking_management.core.service.impl;

import com.project.parking_management.core.domain.dto.Request.VehicleDtoRequest;
import com.project.parking_management.core.domain.entity.Vehicle;
import com.project.parking_management.core.port.store.VehicleStore;
import com.project.parking_management.core.service.VehicleService;
import com.project.parking_management.core.domain.dto.Response.VehicleDtoResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VehicleServiceImpl implements VehicleService {

    private ModelMapper modelMapper;

    @Autowired
    private VehicleStore vehicleStore;

    @Override
    public VehicleDtoResponse getVehicle(VehicleDtoRequest vehicleDtoRequest) {
        return modelMapper.map(vehicleStore.getVehicle(vehicleDtoRequest.getId()), VehicleDtoResponse.class);
    }

    public Vehicle toEntity(VehicleDtoRequest dto) {
        return modelMapper.map(dto, Vehicle.class);
    }
}
