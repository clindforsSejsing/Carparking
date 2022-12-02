package com.carparking.carparking.controller;

import com.carparking.carparking.entity.ParkingTime;
import com.carparking.carparking.repository.ParkingTimeRepository;
import com.carparking.carparking.service.ParkingTimeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/*För Parkeringstillfälle vill vi ha endpoints för:
        GET Hämta alla eller en, hämta pågående/avslutade (filtrering) för en person eller bil.
        POST Skapa ny, starttid sätts till nuvarande tid, stopptid verifieras till att vara efter nu.
        PUT/
        PATCH Uppdatera pågående parkering som inte är avslutad för att flytta fram stopptid.*/

/*CRUD implementationer för entiteterna.
        Starta, stoppa och ta ut information om pågående och avslutade
        parkeringstillfällen.*/
@AllArgsConstructor
@RestController
@RequestMapping("/api/parkings")
public class ParkingTimeController {

    ParkingTimeRepository parkingTimeRepository;
    ParkingTimeService parkingTimeService;


    @GetMapping("/api/parkings")
    public Iterable<ParkingTime> getall() {
        return parkingTimeRepository.findAll();
    }

    @GetMapping("/api/parkings/cars/{id}")
    public Optional<ParkingTime> getOne(@PathVariable Long id) {
        return parkingTimeRepository.findById(id);
    }


  /*  @PatchMapping("/api/parkings/cars/{id}")
    @Transactional
    public void UppdateParkingTime(@PathVariable Long id, @RequestParam LocalDateTime timestop) {

        //@pathvariable är samma som @requestparam
        var parkingTimeOpt = parkingTimeRepository.findById(id);
        if (parkingService.isStopTimeAfterStartTime(id, timestop)) {
            if (parkingTimeOpt.isPresent()) {
                ParkingTime parkingTimes = parkingTimeOpt.get();
                parkingTimes.setModified(timestop);
                parkingTimes.setOngoingParking(true);
                parkingTimeRepository.save(parkingTimes);
            } else {
                throw new RuntimeException();
            }
        }
*/
    }





   /* @PostMapping(path = "/api/parkings/cars/{id}")
    public ResponseEntity<ParkingTime> addNewParkingTime(@RequestBody ParkingTime parkingTime) {

        if (parkingService.isOngoingParking(parkingTime.getTimestart(),parkingTime.getModified())) {
            parkingTime.setOngoingParking(true);
        } else {
            parkingTime.setOngoingParking(false);
        }

        parkingTimeRepository.save(parkingTime);

        return new ResponseEntity<>(parkingTime, HttpStatus.CREATED);
    }*/


