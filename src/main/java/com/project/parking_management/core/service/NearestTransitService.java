package com.project.parking_management.core.service;

import com.google.maps.model.LatLng;
import com.project.parking_management.core.domain.dto.response.NearestTransitResponse;

public interface NearestTransitService {
    NearestTransitResponse getNearestLocation();

    LatLng GetCurrentCoordinate();
}
