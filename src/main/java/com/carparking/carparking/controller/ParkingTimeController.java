package com.carparking.carparking.controller;

import com.carparking.carparking.entity.ParkingTime;
import com.carparking.carparking.service.ParkingTimeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<List<ParkingTime>>getParkingTimeById(@PathVariable Long carId) {
        return new ResponseEntity<>(parkingTimeService.getACarsParkingTimes(carId), HttpStatus.OK);
    }


    @GetMapping("/cars/{carId}/{ongoingParking}")
    List<ParkingTime> getParkingTimeByIdAndEndedOrOngoingParkings(@PathVariable Long carId, @PathVariable Boolean ongoingParking) {
        return parkingTimeService.getParkingTimeByIdAndEndedOrOngoingParkings( carId,ongoingParking);
    }


    @PostMapping("/cars/{carId}/locations/{locationsId}")
    public ResponseEntity<ParkingTime> saveParkingtimeForCar(@RequestBody ParkingTime parkingTime,
                                                             @PathVariable Long carId, @PathVariable Long locationsId) {
        return new ResponseEntity<>(parkingTimeService.saveParkingTime(parkingTime, carId, locationsId, parkingTime.getStoptime()), HttpStatus.CREATED);
    }

    @PatchMapping("/{parkingTimeId}")
    public ResponseEntity<ParkingTime> updateParkingtimeForCar(@RequestBody ParkingTime parkingTime, @PathVariable Long parkingTimeId) {
        return new ResponseEntity<>(parkingTimeService.updateParkingTime(parkingTime, parkingTimeId), HttpStatus.CREATED);
    }
}





