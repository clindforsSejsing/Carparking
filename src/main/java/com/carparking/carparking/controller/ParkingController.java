package com.carparking.carparking.controller;

import com.carparking.carparking.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingController {

    @GetMapping("/cars")
    public String message() {
        return "return all cars";
    }

    @GetMapping("/cars/{id}")
    public String message1() {
        return "Return one car";
    }

  /*  @GetMapping("/persons")
    public Person getPerson(@PathVariable Long id){
        return new Person("Kalle","Mercedes");
    }*/

    @GetMapping("/persons/{id}")
    public String message3() {
        return "Return one person";
    }

    @GetMapping("/parkinglocations")
    public String message4() {
        return "Return all parkinglocations";
    }

    @GetMapping("/parkinglocations/{id}")
    public String message5() {
        return "Return one parkinglocation";
    }

    @GetMapping("/ended_parkings/{id}")
    public String message6() {
        return "Return all ended parkings for a car or a person";
    }

    @GetMapping("/ongoining_parkings/{id}")
    public String message7() {
        return "Return one ongoining parking depending on car or person";
    }

    @PostMapping("/persons")
    public String addPerson(@RequestBody Person person) {
        return person.toString();
    }

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
