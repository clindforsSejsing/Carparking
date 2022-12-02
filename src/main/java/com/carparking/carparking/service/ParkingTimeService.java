package com.carparking.carparking.service;

import com.carparking.carparking.entity.ParkingTime;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingTimeService {
    List<ParkingTime> getParkingTimes();
    List<ParkingTime> getParkingTimeById(Long parkingTimeId);
    ParkingTime saveParkingTime(ParkingTime parkingTime, Long carId, Long parkingLocationsId, LocalDateTime modified);//behövs localdatetime?
    ParkingTime updateModifiedTime(ParkingTime parkingTime, Long parkingTimeId, Long carId, LocalDateTime modified, LocalDateTime timestart);

    /*ParkingTime getOngoingParking(ParkingTime parkingTime, Long carId);//använd metod för att filtrera ch flagga ongoing
        ParkingTime getEndedParking(ParkingTime parkingTime, Long carId);//använd metod för att få ut avslutade tider*/
    ParkingTime getCar(Long carId);
}

