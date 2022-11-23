package com.carparking.carparking.repository;

import com.carparking.carparking.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, String> {
}

//interface som sparar ned data i databasen
//göra för tid och locatilationerna sen också (allt som ska sparas ned i en tabell
//torde ha ett interface.