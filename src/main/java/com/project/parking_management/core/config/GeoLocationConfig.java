package com.project.parking_management.core.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@Getter
public class GeoLocationConfig {
    @Value("${geolocation.url}")
    private String url;

}
