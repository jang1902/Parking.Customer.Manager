package com.project.parking_management.core.domain.dto.request;

import com.project.parking_management.core.domain.dto.Enum.VehicleTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDtoRequest {
    private Long id;
    @Enumerated(EnumType.STRING)
    private VehicleTypeEnum vehicleType;
    private String plate;
    private Long userId;
}
