package com.project.parking_management.core.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleApiConfig {
    @Value("${google.maps.api.key}")
    private String apiKey;

    public String getApiKey() {
        return apiKey;
    }
}
