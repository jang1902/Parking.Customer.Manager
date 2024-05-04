package com.project.parking_management.core.domain.dto.response;


import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NearestTransitResponse {
    public String origin;
    public String destination;
    public String distance;
    public String duration;
    public String status;
}
