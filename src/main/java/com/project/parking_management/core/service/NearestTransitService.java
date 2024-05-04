package com.project.parking_management.core.service;

import com.project.parking_management.core.domain.dto.response.NearestTransitResponse;

public interface NearestTransitService {
    NearestTransitResponse getNearestLocation(Double latitude, Double longitude);
}
