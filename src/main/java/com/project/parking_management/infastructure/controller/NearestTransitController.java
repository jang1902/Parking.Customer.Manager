package com.project.parking_management.infastructure.controller;

import com.google.maps.model.LatLng;
import com.project.parking_management.core.domain.dto.response.NearestTransitResponse;
import com.project.parking_management.core.service.NearestTransitService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class NearestTransitController {
    private final NearestTransitService nearestTransitService;

    public NearestTransitController(NearestTransitService nearestTransitService) {
        this.nearestTransitService=nearestTransitService;
    }

    @GetMapping("/getNearestTransit")
    public NearestTransitResponse getNearestTransit() {
        return nearestTransitService.getNearestLocation();
    }

    @GetMapping("/getCurrentCoordinate")
    public LatLng getCurrentCoordinate() {
        return nearestTransitService.GetCurrentCoordinate();
    }
}
