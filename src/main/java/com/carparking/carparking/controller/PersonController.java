package com.carparking.carparking.controller;

import com.carparking.carparking.entity.Person;
import com.carparking.carparking.repository.PersonRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

//styra o filtrera vad som ska skrivas in i post och
// vilken information som sållas ut i get.
@RestController
public class PersonController {

    //skapar o använder repository. Constructor för att kunna uppdatera den.
    PersonRepository personRepository;
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    //fetcha från db??
    @GetMapping("/persons")
    public List<Person> getPerson () {
        return List.of();
    }

    @GetMapping("/persons/{id}")
    public Person getOnePerson(@PathVariable Long id) {
    return (Person) personRepository.findAll();

    }
    @PostMapping("/persons")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        var p = personRepository.save(person);
        return  ResponseEntity.created(
        ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri()).build();
    }


//för att kunna skapa ett parkeringstillfälle behövs person_id, car, location och tid.
    //parking.java @ManyToMany(cascade = cascadeType.PERSIST)
    //private Set<Parking> parkings = new HashSet<>(); (Om man använder Persist, finns risk för rekursion- adda @Jsonignore på
    //kopian av objectet i klass-filen som är kopplad till huvudklassfilen.

    //skriva special metod i interface- se lektion del 2 14/11 1.25-30

    //@PostMapping("/parkings"
    //public Parking addParking(@RequestBody Parking parking){
    // return parkingrepo.save(parking}; 20-23 min 14/11 del 2 lektion






    /*@PostMapping("/persons")
    public String addPerson(@RequestBody Person person){
     *//*  return person.toString();*//*
        personRespository.save(person);
        return "Person saved";
    }*/



  /*  @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        //validera person
        personRespository.save(person);
        return "Person saved";
    }*/

    /*@PostMapping("/persons")
    @ResponseStatus(HttpStatus.CREATED)
    public Person addPerson(@RequestBody Person person) {
        return personRespository.save(person);
    }*/


    //GetMapping, PostMapping, PutMapping, DeleteMapping, PatchMapping
    //@GetMapping("path"), @GetMapping({"strings, "foo/bar", "foo"})

    //GET för en eller alla, pågående/avslutade för en person eller bil (filtrering)

   /* Följande endpoints ska finnas för personer, bilar och parkeringsplatser:
    //GET Hämta alla eller en bil
    //GET Hämta alla eller en person
    //GET Hämta alla eller en parkeringsplats*/

    //POST göra en ny starttid, (nutid), och inmatning av stopptid som är tdi efter nu .
    //PUT/PATCH Uppdatera pågående parking om den inte avslutas och flytta stopptiden framåt 1h.

    /* POST// Skapa ny person (id, namn, regnr bil, foreignkey till car)
    POST//skapa ny bil (
    Vad behöver vi för fler endpoints för att koppla Person med bilar?*/


}
