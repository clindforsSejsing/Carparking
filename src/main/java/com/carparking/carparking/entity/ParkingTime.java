package com.carparking.carparking.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class ParkingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<ParkingLocation> parkinglocation = new HashSet<>();
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
    /*@Column(name= "created", nullable = false, updatable = false)*/
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime modified;


    //id för parkeringstid
    //tid för start (nu)
    //tid för stopp (aktivt val som inte kan vara nu)
    //tid för att förlänga (uppdatera stopptid, utan att mixtra med starttid)
    //foreignkey parkingLocation

}
