package com.carparking.carparking.service;

import com.carparking.carparking.entity.Car;

import java.util.List;

public interface CarService {
        List<Car> getCars();
        Car getCar(Long carId);
        Car saveCar(Car car, Long personId);
        List<Car> getCarPersonById( Long personId);

}
