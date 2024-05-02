package com.project.parking_management.core.domain.dto.Request;

import com.project.parking_management.core.domain.entity.VehicleTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDtoRequest {
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private VehicleTypeEnum vehicleType;

    private String plate;

    private Long user_id;
}
