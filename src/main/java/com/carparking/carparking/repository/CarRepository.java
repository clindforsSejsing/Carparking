package com.carparking.carparking.repository;

import com.carparking.carparking.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {

    Car findByPersonId(Long id);

}