package com.carparking.carparking.controller;

import com.carparking.carparking.entity.ParkingTime;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.repository.ParkingLocationRepository;
import com.carparking.carparking.repository.ParkingTimeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/*För Parkeringstillfälle vill vi ha endpoints för:
        GET Hämta alla eller en, hämta pågående/avslutade (filtrering) för en person eller bil.
        POST Skapa ny, starttid sätts till nuvarande tid, stopptid verifieras till att vara efter nu.
        PUT/
        PATCH Uppdatera pågående parkering som inte är avslutad för att flytta fram stopptid.*/

/*CRUD implementationer för entiteterna.
        Starta, stoppa och ta ut information om pågående och avslutade
        parkeringstillfällen.*/
@RestController
public class ParkingTimeController {

    ParkingTimeRepository parkingTimeRepository;
    CarRepository carRepository;

    public ParkingTimeController(ParkingTimeRepository parkingTimeRepository, CarRepository carRepository, ParkingLocationRepository parkingLocationRepository) {
        this.parkingTimeRepository = parkingTimeRepository;
        this.carRepository = carRepository;
        this.parkingLocationRepository = parkingLocationRepository;
    }

    ParkingLocationRepository parkingLocationRepository;

    @GetMapping("/parkings")
    public Iterable<ParkingTime> getall() {
        return parkingTimeRepository.findAll();
    }

    @GetMapping("/parkings/{id}")
    public Optional<ParkingTime> getOne(@PathVariable Long id)
    {
        return parkingTimeRepository.findById(id);
    }

    //göra en querystring ist för att hämta in pågående?
    @PostMapping("/parkings")
    public ParkingTime addParkingTime(@RequestBody ParkingTime parkingTime)
    {
        return parkingTimeRepository.save(parkingTime);
    }

    @PatchMapping ("/parkings/{id}")
    public ParkingTime changeParkingTime(@RequestBody ParkingTime parkingtime){

        return parkingTimeRepository.save(parkingtime);
    }
}

 /*   @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }*/