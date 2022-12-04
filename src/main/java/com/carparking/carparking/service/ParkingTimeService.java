package com.carparking.carparking.service;

import com.carparking.carparking.entity.ParkingTime;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingTimeService {
    List<ParkingTime> getParkingTimes();
    ParkingTime getParkingTimeById(Long parkingTimeId);
    ParkingTime saveParkingTime(ParkingTime parkingTime, Long carId, Long parkingLocationsId, LocalDateTime modified);
    ParkingTime updateModifiedTime(ParkingTime parkingTime, Long parkingTimeId, Long carId, LocalDateTime modified, LocalDateTime timestart);
    ParkingTime getCar(Long carId);
}
