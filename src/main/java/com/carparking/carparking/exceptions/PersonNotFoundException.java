package com.carparking.carparking.exceptions;

public class PersonNotFoundException extends RuntimeException {

    public PersonNotFoundException(Long id){
        super("Person with id '" + id + "' does not exist");
    }

}
