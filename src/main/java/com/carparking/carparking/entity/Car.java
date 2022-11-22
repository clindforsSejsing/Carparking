package com.carparking.carparking.entity;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String typeOfCar;
    private String regNr;
    //id, auto_increment
    //bilmärke
    //registreringsnummer
    //foreignkey för en person

    @ManyToOne
    Person person;
    public Car() {

    }

   /* public Set<Person> getPerson() {
        return person;
    }

    public void setPerson(Set<Person> person) {
        this.person = person;
    }*/

   /* @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})*/
    // @JoinColumn("name" = )
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeOfCar() {
        return typeOfCar;
    }

    public void setTypeOfCar(String typeOfCar) {
        this.typeOfCar = typeOfCar;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }



    public Car(String typeOfCar, String regNr) {
        this.typeOfCar = typeOfCar;
        this.regNr = regNr;
    }
}
