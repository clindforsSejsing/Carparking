package com.carparking.carparking.repository;

import com.carparking.carparking.entity.ParkingTime;
import org.springframework.data.repository.CrudRepository;

public interface ParkingTimeRepository extends CrudRepository<ParkingTime, Long> {
    //ParkingTime findByPersonId (Long personId);
    ParkingTime findByCarId (Long carId);

    //ParkingTime findByParkingLocationId (Long parkingLocationId);
}
