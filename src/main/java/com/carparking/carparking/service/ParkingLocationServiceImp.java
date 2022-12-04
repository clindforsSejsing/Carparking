package com.carparking.carparking.service;

import com.carparking.carparking.entity.ParkingLocation;
import com.carparking.carparking.exceptions.ParkingLocationNotFoundException;
import com.carparking.carparking.repository.ParkingLocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ParkingLocationServiceImp implements ParkingLocationService{

    ParkingLocationRepository parkingLocationRepository;

    public ParkingLocationServiceImp(ParkingLocationRepository parkingLocationRepository) {
        this.parkingLocationRepository = parkingLocationRepository;
    }

    @Override
    public ParkingLocation getOneParkingLocation(Long id) {
        Optional<ParkingLocation> parkingLocation = parkingLocationRepository.findById(id);
        return findingLocation(parkingLocation, id);
    }

    @Override
    public ParkingLocation saveParkingLocation(ParkingLocation parkinglocation) {
        return parkingLocationRepository.save(parkinglocation);
    }

    @Override
    public List<ParkingLocation> getParkingLocation() {
        return (List<ParkingLocation>)parkingLocationRepository.findAll();
    }

    static ParkingLocation findingLocation(Optional<ParkingLocation> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new ParkingLocationNotFoundException(id);
    }
}
