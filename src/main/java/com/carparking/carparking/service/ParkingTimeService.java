package com.carparking.carparking.service;

import com.carparking.carparking.entity.ParkingTime;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingTimeService {
    List<ParkingTime> getParkingTimes();
    ParkingTime getParkingTimeById(Long carId);
    ParkingTime saveParkingTime(ParkingTime parkingTime, Long carId, Long locationsId, LocalDateTime stoptime);
    ParkingTime updateParkingTime(ParkingTime parkingTime, Long parkingTimeId);
    /*ParkingTime updateModifiedTime(ParkingTime parkingTime, Long parkingTimeId, Long carId);*/
    ParkingTime getCar(Long carId);

    /*ParkingTime updateModifiedTime(Long parkingTimeId, Long carId);*/
}
