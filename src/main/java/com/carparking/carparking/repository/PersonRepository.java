package com.carparking.carparking.repository;

import com.carparking.carparking.entity.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository <Person, Long> {

}

//interface som sparar ned data i databasen