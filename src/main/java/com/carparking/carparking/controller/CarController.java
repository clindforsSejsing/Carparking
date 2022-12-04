package com.carparking.carparking.controller;

import com.carparking.carparking.entity.Car;
import com.carparking.carparking.service.CarService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/cars")
public class CarController {

    CarService carService;


    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        return new ResponseEntity<>(carService.getCars(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable Long id) {
        return new ResponseEntity<Car> (carService.getCar(id), HttpStatus.OK);
    }

    @GetMapping("/persons/{personId}")
    public ResponseEntity<List<Car>> getPersonsCars(@PathVariable Long personId) {
        return new ResponseEntity<>(carService.getCarPersonById(personId), HttpStatus.OK);
    }

    @PostMapping("/persons/{personId}")
    public ResponseEntity<Car> saveCar(@RequestBody Car car, @PathVariable Long personId) {
        return new ResponseEntity<>(carService.saveCar(car, personId), HttpStatus.CREATED);
    }

}

