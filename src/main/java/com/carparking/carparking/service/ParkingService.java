package com.carparking.carparking.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingService {

    public boolean isOngoingParking(LocalDateTime startime, LocalDateTime stoptime) {

        LocalDateTime rightNow = LocalDateTime.now();
        if (startime.equals(stoptime)) {
            return false;
        } else return !stoptime.equals(rightNow) && !stoptime.isBefore(rightNow);
    }


    public boolean isStopTimeAfterStartTime(Long id, LocalDateTime stoptime){

        LocalDateTime rightNow = LocalDateTime.now();

        return id != null && stoptime.isAfter(rightNow);
    }
}
