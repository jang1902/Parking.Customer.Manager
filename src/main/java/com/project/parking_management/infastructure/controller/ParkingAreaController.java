package com.project.parking_management.infastructure.controller;

import com.project.parking_management.core.domain.dto.response.ParkingAreaDtoResponse;
import com.project.parking_management.core.service.ParkingAreaService;
import com.project.parking_management.core.service.ParkingLotService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking_area")
@AllArgsConstructor
public class ParkingAreaController {
    ParkingAreaService parkingAreaService;
    ParkingLotService parkingLotService;

    @GetMapping
    public List<ParkingAreaDtoResponse> getAllParkingAreas() {
        return parkingAreaService.getAllParkingAreas();
    }

    @GetMapping("{id}")
    public ParkingAreaDtoResponse getParkingAreaById(@PathVariable Long id) {
        return parkingAreaService.getParkingAreaById(id).toResponseDTO();
    }

    @GetMapping("/priority_remaining_space/{id}")
    public int getPriorityRemainingSpace(@PathVariable Long id){
        return parkingAreaService.getPriorityRemainingSpaceSpaceById(id);
    }

    @GetMapping("/remaining_space/{id}")
    public int getRemainingSpace(@PathVariable Long id){
        return parkingAreaService.getRemainingSpace(id);
    }

    @GetMapping("/change_remaining_space")
    public ResponseEntity<String> getRemainingSpace(@RequestParam("remaining_space") int remaining_space,
                                                    @RequestParam("id") Long id){
        parkingAreaService.changeRemainingSpace(remaining_space, id);
        int space = parkingAreaService.getRemainingSpace(id);
        String nameArea = parkingAreaService.getParkingAreaById(id).getName();
        String nameLot = parkingLotService.getParkingLotById
                (parkingAreaService.getParkingAreaById(id).getParking_lot().getId()).getName();
        return new ResponseEntity<>("Sửa chỗ trống khu " + nameArea + " của bãi đỗ " + nameLot +
                " thành công thành " + space + " chỗ trống", HttpStatus.OK);
    }
}
