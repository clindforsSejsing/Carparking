package com.carparking.carparking.repository;

import com.carparking.carparking.entity.ParkingLocation;
import org.springframework.data.repository.ListCrudRepository;

public interface ParkingLocationRepository extends ListCrudRepository<ParkingLocation, Long> {

}

