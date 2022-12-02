package com.carparking.carparking.service;


import com.carparking.carparking.entity.Person;

import java.util.List;

public interface PersonService {
    Person getPerson(Long id);
    Person savePerson(Person person);
    List<Person> getPersons();


}
