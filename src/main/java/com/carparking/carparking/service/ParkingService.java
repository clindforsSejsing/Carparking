package com.carparking.carparking.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingService {

/*    *//**
     /**
     * @param startime Time when ParkingTime starts
     * @param modified Time when ParkingTime should stop
     * @return final check to see so that stop is not before start and nor equal each other.
     */
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
