package com.project.parking_management.infrastructure.controller;
import com.project.parking_management.core.domain.dto.response.Response;
import com.project.parking_management.core.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/exit")
    public Response exitParkingLot(@RequestParam Long parkingLotId, @RequestParam Long ticketId) {
        return Response.build().message(customerService.exitParkingLot(ticketId,  parkingLotId).toString());
    }
}
