package com.project.parking_management.core.service.impl;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;

import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.LatLng;
import com.project.parking_management.core.config.GeoLocationConfig;
import com.project.parking_management.core.config.GoogleApiConfig;
import com.project.parking_management.core.domain.dto.response.GeoLocationResponse;
import com.project.parking_management.core.domain.dto.response.NearestTransitResponse;
import com.project.parking_management.core.domain.entity.ParkingLot;
import com.project.parking_management.core.service.NearestTransitService;
import com.project.parking_management.core.service.ParkingLotService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.ArrayList;
import java.util.List;

@Service
public class NearestTransitServiceImpl implements NearestTransitService {


    private final GeoApiContext context;
    private final ParkingLotService parkingLotService;
    private final GeoLocationConfig geoLocationConfig;

    @Autowired
    public NearestTransitServiceImpl(GoogleApiConfig config , ParkingLotService parkingLotService, GeoLocationConfig geoLocationConfig) {
        context=new GeoApiContext.Builder().apiKey(config.getApiKey()).build();
        this.parkingLotService=parkingLotService;
        this.geoLocationConfig=geoLocationConfig;
    }

    @Override
    public NearestTransitResponse getNearestLocation() {
        List<ParkingLot> listParkingLot;
        List<DistanceMatrix> distanceMatrixList =new ArrayList<>();
        NearestTransitResponse response=new NearestTransitResponse();
        LatLng currentCoordinates = this.GetCurrentCoordinate();

        listParkingLot=parkingLotService.getAllParkingLots();
        try {
            for(ParkingLot parkingLot:listParkingLot){
                DistanceMatrix distanceMatrix= DistanceMatrixApi.newRequest(context)
                        .origins(currentCoordinates)
                        .destinations(new LatLng(parkingLot.getLatitude(),parkingLot.getLongitude())).await();
                distanceMatrixList.add(distanceMatrix);
            }
            DistanceMatrix minDistance = findMinimumPath(distanceMatrixList);
            response.origin=minDistance.originAddresses[0];
            response.destination=minDistance.destinationAddresses[0];
            response.distance=minDistance.rows[0].elements[0].distance.humanReadable;
            response.duration=minDistance.rows[0].elements[0].duration.humanReadable;
            response.status=minDistance.rows[0].elements[0].status.toString();
            return response;
        }catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }

    public DistanceMatrix findMinimumPath(List<DistanceMatrix> list) {
        DistanceMatrix objectMin=new DistanceMatrix(null,null,null);

        if(list==null || list.isEmpty()) { return null;}
        double min =0;
        for(DistanceMatrix distanceMatrix:list) {
            if(min<=distanceMatrix.rows[0].elements[0].distance.inMeters){
                objectMin=distanceMatrix;
                min=distanceMatrix.rows[0].elements[0].distance.inMeters;
            }
        }

        return objectMin;
    }

    @Override
    public LatLng GetCurrentCoordinate(){
        LatLng currentCoordinates = new LatLng();
        String geoLocationUrl= geoLocationConfig.getUrl();

        RestTemplate restTemplate = new RestTemplate();
        GeoLocationResponse geoLocationResponse = restTemplate.getForObject(geoLocationUrl, GeoLocationResponse.class);
        if(geoLocationResponse!=null) {
            currentCoordinates.lat=geoLocationResponse.getLatitude();
            currentCoordinates.lng=geoLocationResponse.getLongitude();
        }
        return currentCoordinates;
    }
}
