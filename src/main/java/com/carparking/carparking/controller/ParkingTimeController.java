package com.carparking.carparking.controller;

//FELSÖKA-- varför bygger den inte? sätta tillbaka construktorerna? autowire?


import com.carparking.carparking.entity.ParkingTime;
import com.carparking.carparking.service.ParkingTimeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/parkings")
public class ParkingTimeController {

    ParkingTimeService parkingTimeService;

    @GetMapping
    public ResponseEntity<List<ParkingTime>> getall() {
        return new ResponseEntity<>(parkingTimeService.getParkingTimes(), HttpStatus.OK);
    }


    @GetMapping("/cars/{carId}")
    public ResponseEntity<ParkingTime> getParkingTimesForACar(@PathVariable Long carId) {
            return new ResponseEntity<>(parkingTimeService.getCar(carId), HttpStatus.OK);
    }

   @PostMapping("/cars/{carId}/parkingslocations/{locationsId}")
    public ResponseEntity<ParkingTime> saveParkingtimeForCar(@RequestBody ParkingTime parkingTime,
    @PathVariable Long carId, @PathVariable Long locationsId, @PathVariable LocalDateTime modified) {
    return new ResponseEntity<>(parkingTimeService.saveParkingTime(parkingTime, carId, locationsId, modified), HttpStatus.CREATED);
    }

    @PatchMapping("/{parkingTimesId}/cars/{carsId}")
    public ResponseEntity<ParkingTime> updateModifiedTime(@RequestBody ParkingTime parkingTime, @PathVariable Long parkingTimeId,
  @PathVariable Long carId, @PathVariable LocalDateTime modified, @PathVariable LocalDateTime timestart)
    {
        return new ResponseEntity<>(parkingTimeService.getCar(carId), HttpStatus.CREATED);
    }
    }


/*För Parkeringstillfälle vill vi ha endpoints för:
        GET Hämta alla eller en, hämta pågående/avslutade (filtrering) för en person eller bil.
        POST Skapa ny, starttid sätts till nuvarande tid, stopptid verifieras till att vara efter nu.
        PUT/
        PATCH Uppdatera pågående parkering som inte är avslutad för att flytta fram stopptid.*/

/*CRUD implementationer för entiteterna.
        Starta, stoppa och ta ut information om pågående och avslutade
        parkeringstillfällen.*/

//post, patch,ParkingTime parkingTime, Long carId, Long parkingLocationsId, LocalDateTime modified
//querystring for ongoing, ended parkings samt för ägarna (personer) till bilarna ev en endpoint för det
//ang konvertera tid: https://www.baeldung.com/spring-date-parameters

     /*ParkingTime getOngoingParking(ParkingTime parkingTime, Long carId);//använd metod för att filtrera ch flagga ongoing
        ParkingTime getEndedParking(ParkingTime parkingTime, Long carId);//använd metod för att få ut avslutade tider*/