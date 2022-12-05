package com.carparking.carparking.service;

import com.carparking.carparking.entity.ParkingTime;

import java.time.LocalDateTime;
import java.util.List;

public interface ParkingTimeService {
    List<ParkingTime> getParkingTimes();
  /* List<ParkingTime>getParkingTimeByIdAndEndedParkings(Long carId, Boolean ongoingParking);*/
    List<ParkingTime> getParkingTimeByIdAndEndedOrOngoingParkings(Long carId, Boolean ongoingParking);
    ParkingTime saveParkingTime(ParkingTime parkingTime, Long carId, Long locationsId, LocalDateTime stoptime);
    ParkingTime updateParkingTime(ParkingTime parkingTime, Long parkingTimeId);
    List<ParkingTime> getACarsParkingTimes(Long carId);

}
