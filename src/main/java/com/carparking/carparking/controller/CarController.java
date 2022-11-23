package com.carparking.carparking.controller;

import com.carparking.carparking.entity.Car;
import com.carparking.carparking.repository.CarRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

public class CarController {

    CarRepository carRepository;

    public CarController(CarRepository carRespository) {
        this.carRepository = carRespository;
    }

    //skapar o använder repository. Constructor för att kunna uppdatera den.


    //fetcha från db??
    @GetMapping("/cars")
    public List<Car> getCar () {
        return List.of();
    }

    @GetMapping("/cars/{id}")
    public Car getOneCar(@PathVariable String regNr) {
        return (Car) carRepository.findAll();

    }
    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        var c = carRepository.save(car);
        return  ResponseEntity.created(
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getRegNr()).toUri()).build();
    }
}
