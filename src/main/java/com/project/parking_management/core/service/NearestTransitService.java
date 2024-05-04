package com.project.parking_management.core.service;

import com.google.maps.model.DistanceMatrix;
import com.project.parking_management.core.domain.dto.response.NearestTransitResponse;

public interface NearestTransitService {
    public NearestTransitResponse getNearestLocation(Double latitude, Double longitude);
}
