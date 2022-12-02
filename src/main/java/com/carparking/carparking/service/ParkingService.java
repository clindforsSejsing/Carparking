package com.carparking.carparking.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingService {

    public boolean isOngoingParking(LocalDateTime startime, LocalDateTime modified) {

        LocalDateTime rightNow = LocalDateTime.now();
        if (startime.equals(modified)) {
            return false;
        } else return !modified.equals(rightNow) && !modified.isBefore(rightNow);
    }


    /**
     * @param id ParkingTime id
     * @param modified stoptime for parking
     * @return must contain id for ParkingTime and stoptime can not be set to be after starttime.
     */
    public boolean isStopTimeAfterStartTime(Long id, LocalDateTime modified){

        LocalDateTime rightNow = LocalDateTime.now();
        return id != null && modified.isAfter(rightNow);
    }
}
