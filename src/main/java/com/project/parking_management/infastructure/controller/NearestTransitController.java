package com.project.parking_management.infastructure.controller;

import com.project.parking_management.core.domain.dto.response.NearestTransitResponse;
import com.project.parking_management.core.service.NearestTransitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NearestTransitController {
    private final NearestTransitService nearestTransitService;

    public NearestTransitController(NearestTransitService nearestTransitService) {
        this.nearestTransitService=nearestTransitService;
    }

    @GetMapping("/getNearestTransit")
    public NearestTransitResponse getNearestTransit(@RequestParam Double Latitude,@RequestParam Double Longitude) {
        return nearestTransitService.getNearestLocation(Latitude,Longitude );
    }
}
