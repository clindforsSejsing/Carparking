package com.carparking.carparking.controller;

import com.carparking.carparking.entity.ParkingLocation;
import com.carparking.carparking.service.ParkingLocationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/parkinglocations")
public class ParkingLocationController {
    ParkingLocationService parkingLocationService;

    @GetMapping
    public ResponseEntity<List<ParkingLocation>> getParkingLocations()
    {
        return new ResponseEntity<>(parkingLocationService.getParkingLocation(), HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ParkingLocation> getOneParkingLocation(@PathVariable Long id)
    {
        return new ResponseEntity<>(parkingLocationService.getOneParkingLocation(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<ParkingLocation> saveParkingLocation(@RequestBody ParkingLocation parkingLocation) {
        return new ResponseEntity<>(parkingLocationService.saveParkingLocation(parkingLocation), HttpStatus.CREATED);
    }
}

