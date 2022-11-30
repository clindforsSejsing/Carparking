package com.carparking.carparking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

//id för parkeringstid
//tid för start (nu)
//tid för stopp (aktivt val som inte kan vara nu)
//tid för att förlänga (uppdatera stopptid, utan att mixtra med starttid)


@Entity
public class ParkingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch =FetchType.EAGER)
    @JsonIgnore
    private ParkingLocation parkingLocation;

    public ParkingLocation getParkingLocation() {
        return parkingLocation;
    }

    public void setParkingLocation(ParkingLocation parkingLocation) {
        this.parkingLocation = parkingLocation;
    }

   /* @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch =FetchType.EAGER)
    @JsonIgnore
    private Car car;*/


 /*   public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getModified() {
        return modified;
    }

    public void setModified(LocalDateTime modified) {
        this.modified = modified;
    }

    @CreationTimestamp
    @Column(name= "created", nullable = false, updatable = false)
    private LocalDateTime created;
    //skapar timestamp till nu. Förhindrar att den skrivs över

    @UpdateTimestamp
    private LocalDateTime modified;


}

