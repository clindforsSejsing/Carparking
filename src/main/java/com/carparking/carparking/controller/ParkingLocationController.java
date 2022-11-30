package com.carparking.carparking.controller;

import com.carparking.carparking.entity.ParkingLocation;
import com.carparking.carparking.repository.ParkingLocationRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.util.Optional;


@RestController
public class ParkingLocationController {
    ParkingLocationRepository parkingLocationRepository;

    public ParkingLocationController(ParkingLocationRepository parkingLocationRepository) {
        this.parkingLocationRepository = parkingLocationRepository;
    }


    @GetMapping("/parkinglocations")
    public List<ParkingLocation> allPoints() {
        return parkingLocationRepository.findAll();
    }


    @GetMapping("/parkinglocations/{id}")
    public Optional<ParkingLocation> getOne(@PathVariable Long id) {
        return parkingLocationRepository.findById(id);
    }

    @PostMapping("/parkinglocations")
    public ResponseEntity<ParkingLocation> createLocation(@RequestBody ParkingLocation parkinglocaton) {
        var pl = parkingLocationRepository.save(parkinglocaton);
        return  ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pl.getId()).toUri()).build();
    }
}

