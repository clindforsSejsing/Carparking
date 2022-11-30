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

   /* @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch =FetchType.EAGER)
    @JoinColumn(name="car_id", referencedColumnName = "id")
    private List<ParkingTime> ParkingTimeForcars = new ArrayList<>();*/

    /*public List<ParkingTime> getParkingTimeForcars() {
        return ParkingTimeForcars;
    }

    public void setParkingTimeForcars(List<ParkingTime> parkingTimeForcars) {
        ParkingTimeForcars = parkingTimeForcars;
    }*/

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
