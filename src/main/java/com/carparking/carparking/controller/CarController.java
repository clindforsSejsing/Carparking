package com.carparking.carparking.controller;

import com.carparking.carparking.entity.Car;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Optional;

@RestController
public class CarController {

    CarRepository carRepository;
    PersonRepository personRepository;

    public CarController(CarRepository carRespository, PersonRepository personRepository) {
        this.carRepository = carRespository;
        this.personRepository = personRepository;
    }

    @GetMapping("/cars")
    public Iterable<Car> getall() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public Optional<Car> getOne(@PathVariable Long id) {
        return carRepository.findById(id);

    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        var c = carRepository.save(car);
        return  ResponseEntity.created(
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri()).build();
    }

}
