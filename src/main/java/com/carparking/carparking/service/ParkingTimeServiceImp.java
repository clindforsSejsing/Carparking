package com.carparking.carparking.service;

import com.carparking.carparking.entity.Car;
import com.carparking.carparking.entity.ParkingLocation;
import com.carparking.carparking.entity.ParkingTime;
import com.carparking.carparking.exceptions.CarNotFoundException;
import com.carparking.carparking.exceptions.ParkingLocationNotFoundException;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.repository.ParkingLocationRepository;
import com.carparking.carparking.repository.ParkingTimeRepository;
import com.carparking.carparking.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class ParkingTimeServiceImp implements ParkingTimeService {
    CarRepository carRepository;
    ParkingLocationRepository parkingLocationRepository;
    ParkingTimeRepository parkingTimeRepository;
    ParkingService parkingService;

    PersonRepository personRepository;

    public ParkingTimeServiceImp(CarRepository carRepository, ParkingLocationRepository parkingLocationRepository, ParkingTimeRepository parkingTimeRepository, ParkingService parkingService,PersonRepository personRepository) {
        this.carRepository = carRepository;
        this.parkingLocationRepository = parkingLocationRepository;
        this.parkingTimeRepository = parkingTimeRepository;
        this.parkingService = parkingService;
        this.personRepository = personRepository;
    }

    @Override
    public List<ParkingTime> getParkingTimes() {
        return (List<ParkingTime>) parkingTimeRepository.findAll();
    }

    @Override
    public List<ParkingTime> getParkingTimeByIdAndEndedOrOngoingParkings(Long carId, Boolean ongoingParking) {
        return parkingTimeRepository.findByOngoingParking(ongoingParking);
    }


    @Override
    public List<ParkingTime> getACarsParkingTimes(Long carId) {
        return parkingTimeRepository.findByCarId(carId);
    }

    /*@Override
    public List<ParkingTime> getParkingTimeByIdAndOngoingParkings(ParkingTime parkingTime, Long carId) {
        var car= parkingTimeRepository.findByCarId(carId);
        return (List<ParkingTime>) parkingTimeRepository.findByOngoingParking(true);
    }*/

/*    @Override
    public List<ParkingTime> getParkingTimeByIdAndEndedParkings(ParkingTime parkingTime, Long carId) {
        parkingTimeRepository.findByCarId(carId);
        return (List<ParkingTime>)parkingTimeRepository.findByOngoingParking(false);
    }*/

    @Override
    public ParkingTime saveParkingTime (ParkingTime parkingTime, Long carId, Long locationsId, LocalDateTime stoptime) {
    Car car = findingCar(carRepository.findById(carId), carId);
    ParkingLocation parkingLocation = findingParkingLocation(parkingLocationRepository.findById(locationsId), locationsId);
    parkingTime.setParkingLocation(parkingLocation);
    parkingTime.setCar(car);

    if(parkingService.isStopTimeAfterStartTime(carId, stoptime)){
        parkingTime.setStoptime(parkingTime.getStoptime());
        parkingTime.setOngoingParking(true);

        parkingTime.setOngoingParking(parkingService.isOngoingParking(parkingTime.getTimestart(),parkingTime.getStoptime()));
        parkingTimeRepository.save(parkingTime);
    }

    return parkingTimeRepository.save(parkingTime);
    }

    @Override
    public ParkingTime updateParkingTime (ParkingTime parkingTimeIn, Long parkingTimeId) {
       ParkingTime parkingTime = parkingTimeRepository.findById(parkingTimeId).get();

        if(parkingService.isStopTimeAfterStartTime(parkingTimeId, parkingTimeIn.getStoptime())){
            parkingTime.setStoptime(parkingTimeIn.getStoptime());
            parkingTime.setOngoingParking(true);
            parkingTimeRepository.save(parkingTime);


        } else {
            parkingTime.setOngoingParking(false);
        }

        return parkingTimeRepository.save(parkingTime);
    }


   /* static ParkingTime findingParkingTime(Optional<ParkingTime> entity, Long parkingTimeId) {
        if (entity.isPresent()) return entity.get();
        else throw new ParkingTimeNotFoundExeption(parkingTimeId);
    }*/
    static Car findingCar (Optional<Car> entity, Long carId) {
        if (entity.isPresent()) return entity.get();
        else throw new CarNotFoundException(carId);
    }

    public ParkingLocation findingParkingLocation(Optional<ParkingLocation> entity, Long parkingLocationsId) {
        if (entity.isPresent()) return entity.get();
        else throw new ParkingLocationNotFoundException(parkingLocationsId);
}
}
