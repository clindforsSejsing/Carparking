package com.carparking.carparking.service;

import com.carparking.carparking.entity.ParkingTime;
import com.carparking.carparking.exceptions.ParkingTimeNotFoundExeption;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.repository.ParkingLocationRepository;
import com.carparking.carparking.repository.ParkingTimeRepository;
import com.carparking.carparking.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ParkingTimeServiceImp implements ParkingTimeService {
    CarRepository carRepository;
    PersonRepository personRepository;
    ParkingLocationRepository parkingLocationRepository;
    ParkingTimeRepository parkingTimeRepository;
    ParkingService parkingService;


    @Override
    public List<ParkingTime> getParkingTimes() {
        return null;
    }

    @Override
    public List<ParkingTime> getParkingTimeById(Long parkingTimeId) {
        return null;
    }

    @Override
    public ParkingTime saveParkingTime(ParkingTime parkingTime, Long carId, Long parkingLocationsId, LocalDateTime modified) {
        return null;
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

    @Override
    public ParkingTime getCar(Long carId) {
        return null;
    }

}

