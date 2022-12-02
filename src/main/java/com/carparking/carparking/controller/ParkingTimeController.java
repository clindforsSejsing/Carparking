package com.carparking.carparking.controller;

import com.carparking.carparking.entity.ParkingTime;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.repository.ParkingLocationRepository;
import com.carparking.carparking.repository.ParkingTimeRepository;
import com.carparking.carparking.service.ParkingService;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

/*För Parkeringstillfälle vill vi ha endpoints för:
        GET Hämta alla eller en, hämta pågående/avslutade (filtrering) för en person eller bil.
        POST Skapa ny, starttid sätts till nuvarande tid, stopptid verifieras till att vara efter nu.
        PUT/
        PATCH Uppdatera pågående parkering som inte är avslutad för att flytta fram stopptid.*/

/*CRUD implementationer för entiteterna.
        Starta, stoppa och ta ut information om pågående och avslutade
        parkeringstillfällen.*/
@RestController
public class ParkingTimeController {

    ParkingTimeRepository parkingTimeRepository;
    CarRepository carRepository;

    ParkingLocationRepository parkingLocationRepository;

    ParkingService parkingService;


    public ParkingTimeController(ParkingTimeRepository parkingTimeRepository, CarRepository carRepository, ParkingLocationRepository parkingLocationRepository, ParkingService parkingService) {
        this.parkingTimeRepository = parkingTimeRepository;
        this.carRepository = carRepository;
        this.parkingLocationRepository = parkingLocationRepository;
        this.parkingService = parkingService;
    }

    @GetMapping("/api/parkings")
    public Iterable<ParkingTime> getall() {
        return parkingTimeRepository.findAll();
    }

    @GetMapping("/api/parkings/cars/{id}")
    public Optional<ParkingTime> getOne(@PathVariable Long id) {
        return parkingTimeRepository.findById(id);
    }

    //find all where name or cars equals to same as in path (querystring)


   /* @PostMapping("/parkings")
    ResponseEntity<ParkingTime> addParkingTime(@RequestBody ParkingTime parkingTime)
    {
        if (parkingService.isOngoingParking(parkingTime.getId(),parkingTime.getTimestop() )) {
            return ResponseEntity.badRequest()
                    .body("Stoptime cannot be smaller than starttime.");
        }

        return parkingTimeRepository.save();
    }*/

    @PatchMapping("/api/parkings/cars/{id}")
    @Transactional
    public void UppdateParkingTime(@PathVariable Long id, @RequestParam LocalDateTime timestop) {

        //@pathvariable är samma som @requestparam
        var parkingTimeOpt = parkingTimeRepository.findById(id);
        if (parkingService.isStopTimeAfterStartTime(id, timestop)) {
            if (parkingTimeOpt.isPresent()) {
                ParkingTime parkingTimes = parkingTimeOpt.get();
                parkingTimes.setModified(timestop);
                parkingTimes.setOngoingParking(true);
                parkingTimeRepository.save(parkingTimes);
            } else {
                throw new RuntimeException();
            }
        }

    }

/*    @PostMapping(path = "/parkings")
    public <ParkingTime> addNewParkingTime(@RequestBody ParkingTime parkingTime) {
        if (parkingService.isOngoingParking(parkingTime.getTimestart(), parkingTime.getTimestart())) {
            parkingTime.setOngoingParking(true);
        } else {
            parkingTime.setOngoingParking(false);
        }
        Car = car
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

        parkingTimeRepository.addCar(car),
        parkingTime.addParkingLocation(parkinglocation);
    }
}*/



    @PostMapping(path = "/api/parkings/cars/{id}")
    public ResponseEntity<ParkingTime> addNewParkingTime(@RequestBody ParkingTime parkingTime) {

        if (parkingService.isOngoingParking(parkingTime.getTimestart(),parkingTime.getModified())) {
            parkingTime.setOngoingParking(true);
        } else {
            parkingTime.setOngoingParking(false);
        }
       /* var c= carRepository.findById(1L);
        parkingLocationRepository.findById(1L);*/
        /*arkingTime.setParkingLocation(c);*/

        parkingTimeRepository.save(parkingTime);

        return new ResponseEntity<>(parkingTime, HttpStatus.CREATED);
    }

  /*  @PostMapping(path = "/parkings")
    public void addNewParkingTime(@RequestBody ParkingTime parkingTime, @RequestParam LocalDateTime timestop) {
        if (parkingService.isOngoingParking(parkingTime.getTimestart(), timestop)) {
            parkingTime.setOngoingParking(true);
            parkingTime.setTimestop(timestop);
        } else {
            parkingTime.setOngoingParking(false);
        }

        parkingTimeRepository.save(parkingTime);
    }*/
}

//@Responsebody serializerar input till json
//@Restkontroller sköter det år oss (controller o responsbody i samma)

//Responseentity kan returnera ett http svar ex <ParkingTime> metodnamn(@pathvariable Long id){
//ParkingTime parkingtime = parkingtimeresository.findbyid(id);
//return new Responsentity<>(parkingtime, httpstatus.ok);
//}
//Responseentity kan returnera ett http svar ex <ParkingTime> (obj som ska returneras).
//@RequestBody serializerar json tillbaka till javakod. Måste finnas för att man ska kunna inhämta data
//från databasen.

//ex : @Postmappih("/contact")
//public Responsentity<HttpStatus> createContact (@RequestBody Conctact contact)
//contactService.saveContact(contact);
//return new RsponsEntity<>(HttpStatus.CREATED);}


//FORTS kap 158 REST API POST

//för att spara ner en persons betyg: inhämta objektet-
//Student student = studentrepository.findby(studentId).get();
//grade.setStudent(student);
//return gradeRepository.save(grade) (en student, flera betyg)

//id för parkeringstid
//tid för start (nu)
//tid för stopp (aktivt val som inte kan vara nu)
//tid för att förlänga (uppdatera stopptid, utan att mixtra med starttid)

/* @JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss[.SSS][.SS][.S]")*/