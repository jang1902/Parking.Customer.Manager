package com.project.parking_management.core.domain.dto.response;

import com.project.parking_management.core.domain.entity.VehicleTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleDtoResponse {
    private Long id;

    @Enumerated(EnumType.ORDINAL)
    private VehicleTypeEnum vehicleType;

    private String plate;

    private Long userId;

}
