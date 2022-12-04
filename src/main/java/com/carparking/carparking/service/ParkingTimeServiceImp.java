package com.carparking.carparking.service;

import com.carparking.carparking.entity.Car;
import com.carparking.carparking.entity.ParkingLocation;
import com.carparking.carparking.entity.ParkingTime;
import com.carparking.carparking.exceptions.CarNotFoundException;
import com.carparking.carparking.exceptions.ParkingLocationNotFoundException;
import com.carparking.carparking.exceptions.ParkingTimeNotFoundExeption;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.repository.ParkingLocationRepository;
import com.carparking.carparking.repository.ParkingTimeRepository;
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

    public ParkingTimeServiceImp(CarRepository carRepository, ParkingLocationRepository parkingLocationRepository, ParkingTimeRepository parkingTimeRepository, ParkingService parkingService) {
        this.carRepository = carRepository;
        this.parkingLocationRepository = parkingLocationRepository;
        this.parkingTimeRepository = parkingTimeRepository;
        this.parkingService = parkingService;
    }

    @Override
    public List<ParkingTime> getParkingTimes() {
        return (List<ParkingTime>) parkingTimeRepository.findAll();
    }

    @Override
    public ParkingTime getCar(Long carId) {
        return parkingTimeRepository.findByCarId(carId);
    }

    @Override
    public ParkingTime getParkingTimeById(Long parkingTimeId) {
        Optional<ParkingTime> parkingTime = parkingTimeRepository.findById(parkingTimeId);
        return findingParkingTime(parkingTime, parkingTimeId);
    }

    @Override
    public ParkingTime saveParkingTime (ParkingTime parkingTime, Long carId, Long parkingLocationsId, LocalDateTime modified) {
    Car car = findingCar(carRepository.findById(carId), carId);
    ParkingLocation parkingLocation = findingParkingLocation(parkingLocationRepository.findById(parkingLocationsId), parkingLocationsId);
    parkingTime.setParkingLocation(parkingLocation);
    parkingTime.setCar(car);

    return parkingTimeRepository.save(parkingTime);
    }

    @Override
    public ParkingTime updateModifiedTime(ParkingTime parkingTime, Long parkingTimeId, Long carId, LocalDateTime modified, LocalDateTime timestart) {
        var parkingTimeOpt = parkingTimeRepository.findById(parkingTimeId);
        if (parkingService.isStopTimeAfterStartTime(parkingTimeId, modified)) {

            if (parkingTimeOpt.isPresent()) {
                ParkingTime parkingTimes = parkingTimeOpt.get();
                parkingTimes.setModified(modified);
                parkingTimes.setOngoingParking(true);
                parkingTimeRepository.save(parkingTimes);

                parkingTime.setOngoingParking(parkingService.isOngoingParking(timestart, modified));
                parkingTimeRepository.save(parkingTime);
            } else {
                throw new ParkingTimeNotFoundExeption(parkingTimeId);
            }
        }
        return parkingTime;
    }

    static ParkingTime findingParkingTime(Optional<ParkingTime> entity, Long parkingTimeId) {
        if (entity.isPresent()) return entity.get();
        else throw new ParkingTimeNotFoundExeption(parkingTimeId);
    }
    static Car findingCar (Optional<Car> entity, Long carId) {
        if (entity.isPresent()) return entity.get();
        else throw new CarNotFoundException(carId);
    }
    public ParkingLocation findingParkingLocation(Optional<ParkingLocation> entity, Long parkingLocationsId) {
        if (entity.isPresent()) return entity.get();
        else throw new ParkingLocationNotFoundException(parkingLocationsId);
}
}

