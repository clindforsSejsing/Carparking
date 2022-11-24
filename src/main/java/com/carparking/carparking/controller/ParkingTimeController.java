package com.carparking.carparking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingTimeController {
    //adda get och posts för



    @GetMapping("/ended_parkings/{id}")
    public String message6() {
        return "Return all ended parkings for a car or a person";
    }

    //göra en querystring ist för att hämta in pågående?
    @GetMapping("/ongoining_parkings/{id}")
    public String message7() {
        return "Return one ongoining parking depending on car or person";
    }

}
