package com.carparking.carparking.service;

import com.carparking.carparking.entity.Person;
import com.carparking.carparking.exceptions.PersonNotFoundException;
import com.carparking.carparking.repository.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PersonServiceImp implements PersonService{

    PersonRepository personRepository;

    public PersonServiceImp(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getPersons() {
        return (List<Person>)personRepository.findAll();
    }
    @Override
    public Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return findingPerson(person, id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }


    static Person findingPerson(Optional<Person> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new PersonNotFoundException(id);
    }
}
