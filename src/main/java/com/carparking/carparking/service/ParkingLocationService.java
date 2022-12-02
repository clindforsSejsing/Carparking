package com.carparking.carparking.service;

import com.carparking.carparking.entity.ParkingLocation;

import java.util.List;

public interface ParkingLocationService{

    ParkingLocation getOneParkingLocation(Long id);
    ParkingLocation saveParkingLocation(ParkingLocation parkinglocation);
    List<ParkingLocation> getParkingLocation();

}

