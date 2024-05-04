package com.project.parking_management.core.service.impl;

import com.project.parking_management.core.domain.dto.request.MonthlyTickerRequest;
import com.project.parking_management.core.domain.entity.Invoice;
import com.project.parking_management.core.domain.entity.InvoiceTypeEnum;
import com.project.parking_management.core.domain.entity.Ticket;
import com.project.parking_management.core.domain.entity.Vehicle;
import com.project.parking_management.core.service.TicketService;
import com.project.parking_management.infrastructure.store.repository.InvoiceRepository;
import com.project.parking_management.infrastructure.store.repository.TicketRepository;
import com.project.parking_management.infrastructure.store.repository.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final VehicleRepository vehicleRepository;
    private final InvoiceRepository invoiceRepository;

    @Override
    public ResponseEntity<String> createMonthlyTicket(MonthlyTickerRequest request) {
        try {
            boolean checkVehicleOwner = checkVehicleOwner(request.getUserId(), request.getVehicleId());
            boolean checkExistedMonthlyTicket = checkExistedMonthlyTicket(request.getVehicleId(), request.getParkingLotId());

            if(!checkVehicleOwner) return new ResponseEntity<>("Xe không thuộc về chủ sở hữu", HttpStatus.BAD_REQUEST);
            if(checkExistedMonthlyTicket) return new ResponseEntity<>("Xe đã đăng ký vé tháng trước đó", HttpStatus.BAD_REQUEST);

            LocalDateTime currentTime = LocalDateTime.now();

            Ticket ticket = Ticket.builder()
                    .createdDate(currentTime)
                    .expiredDate(request.getExpiredDate())
                    .vehicle(findVehicle(request.getVehicleId()))
                    .build();

            Invoice invoice = Invoice.builder()
                    .invoiceType(InvoiceTypeEnum.MONTHLYTICKETPAY)
                    .price(request.getPrice())
                    .createdDate(currentTime)
                    .vehicle(findVehicle(request.getVehicleId()))
                    .parkingLotId(request.getParkingLotId())
                    .build();

            ticketRepository.save(ticket);
            invoiceRepository.save(invoice);

            return new ResponseEntity<>("Tạo vé tháng thành công", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Tạo vé tháng thất bại", HttpStatus.BAD_REQUEST);
        }

    }

    private boolean checkVehicleOwner(Long userId, Long vehicleId) {
        Vehicle vehicle = findVehicle(vehicleId);
        return Objects.equals(userId, vehicle.getUser().getId());
    }

    private boolean checkExistedMonthlyTicket(Long vehicleId, Long parkingLotId) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findAll().stream()
                .filter(invoice -> invoice.getInvoiceType() == InvoiceTypeEnum.MONTHLYTICKETPAY)
                .filter(invoice -> invoice.getVehicle().getId().equals(vehicleId))
                .filter(invoice -> invoice.getParkingLotId().equals(parkingLotId))
                .max(Comparator.comparing(Invoice::getCreatedDate));

        LocalDateTime createdDate = optionalInvoice.map(Invoice::getCreatedDate).orElse(null);

        if(createdDate == null) return false;

        Optional<Ticket> optionalTicket = ticketRepository.findAll().stream()
                .filter(invoice -> invoice.getVehicle().getId().equals(vehicleId))
                .filter(ticket -> ticket.getCreatedDate().equals(createdDate))
                .findFirst();

        LocalDateTime expiredDate = optionalTicket.map(Ticket::getExpiredDate).orElse(null);

        if(expiredDate == null) return false;

        LocalDateTime current = LocalDateTime.now();

        return current.isBefore(expiredDate);
    }

    private Vehicle findVehicle(Long id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Vehicle is not found with id " + id));
    }
}
