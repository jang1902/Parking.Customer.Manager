package com.project.parking_management.core.service.impl;

import com.project.parking_management.core.domain.dto.Enum.InvoiceTypeEnum;
import com.project.parking_management.core.domain.dto.request.BookingDtoRequest;
import com.project.parking_management.core.domain.dto.request.InvoiceDtoRequest;
import com.project.parking_management.core.domain.dto.request.VehicleDtoRequest;
import com.project.parking_management.core.domain.dto.response.BookingDtoResponse;
import com.project.parking_management.core.domain.dto.response.InvoiceDtoResponse;
import com.project.parking_management.core.domain.dto.response.UserDtoResponse;
import com.project.parking_management.core.domain.dto.response.VehicleDtoResponse;
import com.project.parking_management.core.domain.entity.Booking;
import com.project.parking_management.core.domain.entity.ParkingAreaTypeEnum;
import com.project.parking_management.core.service.BookingService;
import com.project.parking_management.core.service.ParkingAreaService;
import com.project.parking_management.infastructure.store.repository.BookingRepository;
import com.project.parking_management.infastructure.store.repository.ParkingAreaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpHeaders;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    BookingRepository bookingRepository;
    ParkingAreaRepository parkingAreaRepository;
    ParkingAreaService parkingAreaService;
    RestTemplate restTemplate;

    @Override
    public List<Booking> getAllBooking() {
        return bookingRepository.findAll();
    }

    @Override
    public ResponseEntity createBooking(BookingDtoRequest bookingDtoRequest) {
//        Kiểm tra đăng nhập

//        Kiểm tra xe của khách có trên hệ thống ko nếu ko thì thêm mới

//        Kiểm tra chỗ trống của khu đỗ
        int remainingSpace = checkRemaningSpace(bookingDtoRequest.getParking_area_id());
//        Nếu hết chỗ trống thì thống báo cho người dùng
        if (remainingSpace == 0) {
            return new ResponseEntity<>("Khu đỗ hết chỗ trống vui lòng chọn khu đỗ khác", HttpStatus.BAD_REQUEST);
        }
        else{
//          Nếu còn chỗ thì trừ remaining space đi 1
            parkingAreaService.changeRemainingSpace(remainingSpace - 1,
                    bookingDtoRequest.getParking_area_id());
            Duration duration = Duration.between(bookingDtoRequest.getEstimated_starttime(),
                    bookingDtoRequest.getEstimated_endtime());
//          Kiểm tra loại bãi đỗ xe
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
//          Tạo hóa đơn
            InvoiceDtoRequest invoiceDtoRequest = InvoiceDtoRequest.builder()
                    .createdDate(LocalDateTime.now())
                    .invoiceType(InvoiceTypeEnum.BOOKINGPAY)
                    .parkingLotId(parkingAreaService.getParkingAreaById
                            (bookingDtoRequest.getParking_area_id()).getParking_lot().getId())
                    .vehicleId(bookingDtoRequest.getVehicle_id())
                    .price(duration.toHours() * price)
                    .build();
            createInvoice(invoiceDtoRequest);
//            Tạo Booking
            Booking booking = Booking.builder()
                    .estimated_starttime(bookingDtoRequest.getEstimated_starttime())
                    .estimated_endtime(bookingDtoRequest.getEstimated_endtime())
                    .vehicle_id(bookingDtoRequest.getVehicle_id())
                    .parking_area(parkingAreaRepository.findById(bookingDtoRequest.getParking_area_id()).get())
                    .build();
            bookingRepository.save(booking);
        }
        return new ResponseEntity<>("Đặt chỗ thành công", HttpStatus.CREATED);
    }

    @Override
    public int checkRemaningSpace(Long parkingAreaId) {
        return parkingAreaRepository.findById(parkingAreaId).get().getRemaining_space();
    }

    @Override
    public VehicleDtoResponse findVehicleByPlate(VehicleDtoRequest vehicleDtoRequest) {
        return null;
    }

    @Override
    public UserDtoResponse getUserByUsername(String username) {
        return null;
    }

    @Override
    public InvoiceDtoResponse createInvoice(InvoiceDtoRequest invoiceDtoRequest) {
        return null;
    }
}
