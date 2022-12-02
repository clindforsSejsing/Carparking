package com.carparking.carparking.exceptions;

public class ParkingLocationNotFoundException extends RuntimeException{

    public ParkingLocationNotFoundException(Long id)
    {super("Location with id '" + id + "' does not exist");}

}
