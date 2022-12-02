package com.carparking.carparking.repository;

import com.carparking.carparking.entity.Car;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findByPersonId(Long personId);
}