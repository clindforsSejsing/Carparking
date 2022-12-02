package com.carparking.carparking.controller;

import com.carparking.carparking.entity.Person;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/api/persons")
public class PersonController {


    PersonService personService;
    CarRepository carRepository;

    @GetMapping
    public ResponseEntity<List<Person>> getPersons()
    {
        return new ResponseEntity<>(personService.getPersons(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Long id)
    {
        return new ResponseEntity<>(personService.getPerson(id), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> savePerson(@RequestBody Person person) {
        return new ResponseEntity<>(personService.savePerson(person), HttpStatus.CREATED);
    }

}
