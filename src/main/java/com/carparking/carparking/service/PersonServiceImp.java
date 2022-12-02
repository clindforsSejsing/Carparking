package com.carparking.carparking.service;

import com.carparking.carparking.entity.Person;
import com.carparking.carparking.exceptions.PersonNotFoundException;
import com.carparking.carparking.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class PersonServiceImp implements PersonService{

    PersonRepository personRepository;

    @Override
    public Person getPerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        return unwrapPerson(person, id);
    }

    @Override
    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> getPersons() {
        return (List<Person>)personRepository.findAll();
    }


    static Person unwrapPerson(Optional<Person> entity, Long id) {
        if (entity.isPresent()) return entity.get();
        else throw new PersonNotFoundException(id);
    }
}
