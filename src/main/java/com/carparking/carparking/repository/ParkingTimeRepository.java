package com.carparking.carparking.repository;

import com.carparking.carparking.entity.ParkingTime;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ParkingTimeRepository extends CrudRepository<ParkingTime, Long> {
    List<ParkingTime> findByPersonId (Long personId);
    List<ParkingTime> findByCarId (Long carId);

    List<ParkingTime> findByParkingTime (Long parkingId);
}
