package com.project.parking_management.infastructure.controller;

import com.project.parking_management.core.domain.dto.Enum.InvoiceTypeEnum;
import com.project.parking_management.core.domain.dto.request.BookingDtoRequest;
import com.project.parking_management.core.domain.dto.request.InvoiceDtoRequest;
import com.project.parking_management.core.domain.entity.Booking;
import com.project.parking_management.core.domain.entity.ParkingAreaTypeEnum;
import com.project.parking_management.core.service.BookingService;
import com.project.parking_management.core.service.ParkingAreaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/booking")
@AllArgsConstructor
public class BookingController {

    BookingService bookingService;
    ParkingAreaService parkingAreaService;

    @GetMapping("/")
    public List<Booking> getAllBooking(){
        return bookingService.getAllBooking();
    }

    @PostMapping("/")
    public ResponseEntity<String> addBooking(@RequestBody BookingDtoRequest bookingDtoRequest){
//        Kiểm tra đăng nhập

//        Kiểm tra xe của khách có trên hệ tống ko nếu ko thì thêm mới

//        Kiểm tra chỗ trống của khu đỗ
        int remainingSpace = bookingService.checkRemaningSpace(bookingDtoRequest.getParking_area_id());
//        Nếu hết chỗ trống thì thống báo cho người dùng
        if (remainingSpace == 0) {
            return new ResponseEntity<>("Khu đỗ hết chỗ trống vui lòng chọn khu đỗ khác", HttpStatus.BAD_REQUEST);
        }
        else{
//            Nếu còn chỗ thì trừ remaining space đi 1
            parkingAreaService.changeRemainingSpace(remainingSpace - 1,
                    bookingDtoRequest.getParking_area_id());
            Duration duration = Duration.between(bookingDtoRequest.getEstimated_starttime(),
                    bookingDtoRequest.getEstimated_endtime());
//            Kiểm tra loại bãi đỗ xe
            double price = 0;
            ParkingAreaTypeEnum type = parkingAreaService.getParkingAreaById(bookingDtoRequest.getParking_area_id()).getType();
            switch (type){
                case CAR:
                    price = 10000;
                    break;
                case MOTORBIKE:
                    price = 5000;
                    break;
                case BIKE:
                    price = 2000;
                    break;
            }
//            Tạo hóa đơn
            InvoiceDtoRequest invoiceDtoRequest = new InvoiceDtoRequest();
            invoiceDtoRequest.setCreatedDate(LocalDateTime.now());
            invoiceDtoRequest.setInvoiceType(InvoiceTypeEnum.BOOKINGPAY);
            invoiceDtoRequest.setParkingLotId(parkingAreaService.getParkingAreaById
                    (bookingDtoRequest.getParking_area_id()).getParking_lot().getId());
            invoiceDtoRequest.setVehicleId(bookingDtoRequest.getVehicle_id());
            invoiceDtoRequest.setPrice(duration.toHours() * price);
            bookingService.createInvoice(invoiceDtoRequest);
//            Tạo Booking
            bookingService.createBooking(bookingDtoRequest);
        }
        return new ResponseEntity<>("Đặt chỗ thành công", HttpStatus.CREATED);
    }
}
