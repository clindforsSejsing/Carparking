package com.carparking.carparking.entity;

import jakarta.persistence.*;

@Entity
public class Car {

    @Id
    @Column (length= 10)
    private String regNr;
    @Column (length= 50)
    private String typeOfCar;

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
}
