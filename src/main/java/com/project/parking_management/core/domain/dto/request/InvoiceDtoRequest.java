package com.project.parking_management.core.domain.dto.request;

import com.project.parking_management.core.domain.dto.Enum.InvoiceTypeEnum;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceDtoRequest {
    private Long id;
    @Enumerated(EnumType.STRING)
    private InvoiceTypeEnum invoiceType;
    private double price;
    private LocalDateTime createdDate;
    private Long vehicleId;
    private Long parkingLotId;
}
