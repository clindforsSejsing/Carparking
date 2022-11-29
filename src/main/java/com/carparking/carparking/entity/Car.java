package com.carparking.carparking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length= 25, nullable = false)
    private String reg;

    @ManyToOne
    @JsonIgnore
    private Person person;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getReg() {
        return reg;
    }

    public void setReg(String regNr) {
        this.reg = regNr;
    }
}


/* @ManyToOne(cascade ={CascadeType.PERSIST, CascadeType.MERGE}, fetch =FetchType.EAGER)
    @JoinColumn(name="person_id", referencedColumnName = "id")
    private Person person;*/

   /* public List<ParkingTime> getParkingTimeList() {
        return parkingTimeList;
    }*/

  /*  public void setParkingTimeList(List<ParkingTime> parkingTimeList) {
        this.parkingTimeList = parkingTimeList;
    }*/

 /*   public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }*/

/* @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="car_id")
    private List<ParkingTime> parkingTimeList = new ArrayList<>();*/