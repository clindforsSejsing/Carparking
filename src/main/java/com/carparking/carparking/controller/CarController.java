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

    //går att posta men inte get:a
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


   /* @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car, Person person) {

        var p = personRepository.findById(person.getId());
        car.setPerson(person);
        var c = carRepository.save(car);
        return  ResponseEntity.created(
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri()).build();
    }*/
    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        var c = carRepository.save(car);
        return  ResponseEntity.created(
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getId()).toUri()).build();
    }

  /*  @PostMapping("/cars")
    public Car addCar(@RequestBody Person person) {
        var m = Set.copyOf(person.getCars());
        person.getCars().clear();
        for (Car car : m) {
            if (car.getId() != null)
                Person.getCars()
                        .add(
                                memberRepository.findById(member.getId())
                                        .orElse(member));
            else
                organization.getMembers()
                        .add(member);
        }

        return orgrepo.save(organization);

        // return orgrepo.findByName("Gulfuddens AIK");
        // return orgrepo.findOrganizationByMembersName("Martin");
    }*/

}
  /*  @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        var c = carRepository.save(car);
        return  ResponseEntity.created(
                ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(c.getRegNr()).toUri()).build();
    }*/