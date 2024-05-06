package com.project.parking_management.core.service.impl;

import com.project.parking_management.core.domain.entity.*;
import com.project.parking_management.core.port.store.InvoiceStore;
import com.project.parking_management.core.port.store.LogActivityStore;
import com.project.parking_management.core.port.store.TicketStore;
import com.project.parking_management.core.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final TicketStore ticketStore;
    private final InvoiceStore invoiceStore;
    private final LogActivityStore logActivityStore;

    @Override
    public ResponseEntity<String> enterParkingLot(Long ticketId, Long parkingLotId) {
        Ticket ticket = ticketStore.getTicket(ticketId);
        LocalDateTime localTime = LocalDateTime.now();
        if (ticket == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ticket not found");
        } else {
            if (ticket.getExpiredDate().isAfter(localTime)) {
                LogActivity logActivity = new LogActivity(Activity.IN,ticket.getVehicle());
                logActivityStore.saveLog(logActivity);
            } else {
                ticket.setExpiredDate(localTime);
                LogActivity logActivity = new LogActivity(Activity.IN,ticket.getVehicle());
                logActivityStore.saveLog(logActivity);
            }
            return ResponseEntity.status(HttpStatus.CREATED).body("Successful entered the parking lot");
        }
    }

    @Override
    public ResponseEntity<String> exitParkingLot(Long ticketId, Long parkingLotId) {
        try {
            Optional<LogActivity> logActivityOptional = lastLogActivity(ticketId);
            if (!logActivityOptional.isPresent()
                    || !logActivityOptional.get().getActivity().equals(Activity.IN)) {
                return new ResponseEntity<>("Vehicle does not exist", HttpStatus.BAD_REQUEST);
            }
            Ticket ticket = ticketStore.getTicket(ticketId);
            LogActivity logActivity = new LogActivity(Activity.OUT, ticket.getVehicle());
            logActivityStore.saveLog(logActivity);
            double fee = calculateParkingFee(ticket.getExpiredDate(), LocalDateTime.now(), feePerDay(ticket.getVehicle().getVehicleType()));
            Invoice invoice = new Invoice(InvoiceTypeEnum.PARKINGPAY, fee, ticket.getVehicle(), parkingLotId);
            invoiceStore.saveInvoice(invoice);
            return new ResponseEntity<>("Vehicle exited successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>("Vehicle does not exist or can't exit parking lot", HttpStatus.BAD_REQUEST);
        }
    }

    private Optional<LogActivity> lastLogActivity(Long ticketId) {
        Vehicle vehicle = ticketStore.getTicket(ticketId).getVehicle();
        return logActivityStore.findByVehicleId(vehicle.getId()).stream()
                .max(Comparator.comparing(LogActivity::getTimestamp));
    }

    private double feePerDay(VehicleTypeEnum vehicleType) {
        double parkingCarFeePerDay = 10000;
        double parkingMotorbikeFeePerDay = 5000;
        double parkingBikeFeePerDay = 2000;
        return switch (vehicleType) {
            case CAR -> parkingCarFeePerDay;
            case MOTORBIKE -> parkingMotorbikeFeePerDay;
            case BIKE -> parkingBikeFeePerDay;
        };
    }

    private double calculateParkingFee(LocalDateTime expiredTime, LocalDateTime exitTime, double feePerDay) {
        if (expiredTime.isAfter(exitTime)) return 0.0;
        double parkingFee;
        Duration duration = Duration.between(expiredTime, exitTime);
        parkingFee = (duration.toDays() + ((duration.toHours() > duration.toDays() * 24) ? 1 : 0)) * feePerDay;
        return parkingFee;
    }
}
