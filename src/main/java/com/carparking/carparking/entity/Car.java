package com.carparking.carparking.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Car {

    @Id
    @Column (length= 10)
    private String regNr;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="car_id")
    private Set<ParkingTime> parkingtimes = new HashSet<>();

    public Set<ParkingTime> getParkingtimes() {
        return parkingtimes;
    }

    public void setParkingtimes(Set<ParkingTime> parkingtimes) {
        this.parkingtimes = parkingtimes;
    }

    public String getRegNr() {
        return regNr;
    }

    public void setRegNr(String regNr) {
        this.regNr = regNr;
    }
}
