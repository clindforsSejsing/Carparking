package com.carparking.carparking.exceptions;

public class ParkingTimeNotFoundExeption extends RuntimeException {

    public ParkingTimeNotFoundExeption(Long parkingTimeId){
        super("Parkingtime with id '" + parkingTimeId + "' does not exist");
    }

}
