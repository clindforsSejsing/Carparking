package com.carparking.carparking.service;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ParkingService {

/*    *//**
     /**
     * @param modified Time when ParkingTime is being updated
     * @param stoptime Time when ParkingTime should stop
     * @return final check to see so that stop is not before start and nor equal each other.
     */
    public boolean isOngoingParking(LocalDateTime modified, LocalDateTime stoptime) {

        LocalDateTime rightNow = LocalDateTime.now();
        if (modified.equals(stoptime) & stoptime.isBefore(rightNow)) {
            return false;
        }
        return true;
    }



    /**
     * @param parkingTimeId ParkingTime id
     * @param stoptime stoptime for parking
     * @return must contain id for ParkingTime and stoptime can not be set to be after starttime.
     */
    public boolean isStopTimeAfterStartTime(Long parkingTimeId, LocalDateTime stoptime){

        LocalDateTime rightNow = LocalDateTime.now();
        return parkingTimeId != null && stoptime.isAfter(rightNow);
    }


}
