package com.carparking.carparking.controller;

import com.carparking.carparking.entity.Car;
import com.carparking.carparking.entity.Person;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.repository.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Set;

@RestController
public class PersonController {
    PersonRepository personRepository;
    CarRepository carRepository;

    public PersonController(PersonRepository personRepository, CarRepository carRepository) {
        this.personRepository = personRepository;
        this.carRepository = carRepository;
    }

    @GetMapping("/persons")
    public Iterable<Person> getall() {
        return personRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    public Optional<Person> getOne(@PathVariable Long id) {
        return personRepository.findById(id);

    }

    @PostMapping("persons")
    public Person addPerson(@RequestBody Person person) {
        var m = Set.copyOf(person.getCars());
        person.getCars().clear();
        for (Car car : m) {
            if (car.getId() != null)
                person.getCars()
                        .add(
                                carRepository.findById(car.getId())
                                        .orElse(car));
            else {
                person.addCar(car);
            }
        }

        return personRepository.save(person);
    }
}
