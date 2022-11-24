package com.carparking.carparking.controller;

import com.carparking.carparking.repository.ParkingLocationRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParkingLocationController {
    ParkingLocationRepository parkingLocationRepository;

    public ParkingLocationController(ParkingLocationRepository parkingLocationRepository) {
        this.parkingLocationRepository = parkingLocationRepository;
    }

      /*  @GetMapping("/parkinglocations")
    public Person getOnePerson(@PathVariable int id) {
        return new Person("kalle anka");
    }

    @GetMapping("/parkinglocations/{id}")
    public String message5() {
        return "Return one parkinglocation";
    }


    //@GetMapping

    //WGS84
    //65°49'30.4"N 21°41'29.3"E Stadsparken Boden
    //65°40'14.4"N 21°55'58.2"E Sjukhuskyrkan Sunderbyn
    //65°34'49.8"N 22°9'38.1"E Luleå Södra hamn
    //65°34'36.5"N 22°5'46.5"E Bergnäsets grill
    // 65°38'56.6"N 22°2'9.6"E, Hägnan Friluftsmuseum

    //Skriva om denna
 /*   @PostMapping("/parkings")
    public ResponseEntity<ParkingLocation> insertOne (@RequestBody ParkingLocation parkingLocation){
        //playground.setCoordinate(point(WGS84,g(4.33,3.21)));
        var newPlayground = parkingLocationRepository.save(parkingLocation);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPlayground.getId())
                .toUri();

        return ResponseEntity.created(location).body(newPlayground);
    }*/

    //Läsa på om geolatte (lektionens kod nedan)

   /* @GetMapping("/playgrounds")
    public List<Playground> allPoints() {
        return playgroundRepository.findAll();
    }

    @GetMapping(path = "/playgrounds", params = "filter")
    public List<Playground> filterPoints(@RequestParam String filter) {

        Geometry<G2D> area = polygon(WGS84, ring(
                g(0.0, 0.0),
                g(10.0, 0.0),
                g(10.0, 10.0),
                g(0.0, 10.0),
                g(0.0, 0.0)));

        return playgroundRepository.filterOnArea(area);
    }

    @GetMapping(path = "/geo")
    public Geometry<G2D> filterPoints() {
        Geometry<G2D> area = polygon(WGS84, ring(
                g(0.0, 0.0),
                g(10.0, 0.0),
                g(10.0, 10.0),
                g(0.0, 10.0),
                g(0.0, 0.0)));

        return area;
    }*/

}
