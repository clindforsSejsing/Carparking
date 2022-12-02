package com.carparking.carparking.service;

import com.carparking.carparking.entity.Car;
import com.carparking.carparking.entity.Person;
import com.carparking.carparking.exceptions.CarNotFoundException;
import com.carparking.carparking.repository.CarRepository;
import com.carparking.carparking.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.carparking.carparking.service.PersonServiceImp.findingPerson;

@AllArgsConstructor
@Service
public class CarServiceImp implements CarService{

    CarRepository carRepository;
    PersonRepository personRepository;

    @Override
    public List<Car> getCars() {
        return (List<Car>)carRepository.findAll();
    }

    @Override
    public Car getCar(Long carId) {
        Optional<Car> car = carRepository.findById(carId);
        return findingCar(car, carId);
    }


    @Override
    public Car saveCar(Car car, Long personId) {
        Person person = findingPerson(personRepository.findById(personId), personId);
        car.setPerson(person);
        return carRepository.save(car);
    }

    @Override
    public List<Car> getCarPersonById(Long personId) {
        return carRepository.findByPersonId(personId);
    }
    static Car findingCar (Optional<Car> entity, Long carId) {
        if (entity.isPresent()) return entity.get();
        else throw new CarNotFoundException(carId);
    }

}
