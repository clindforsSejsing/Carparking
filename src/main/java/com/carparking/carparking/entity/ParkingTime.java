package com.carparking.carparking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name="parking_time")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @CreationTimestamp
    @Column(name= "timestart", nullable = false, updatable = false)
    private LocalDateTime timestart= LocalDateTime.now();

    @UpdateTimestamp
    @Column(name= "modified")
    private LocalDateTime modified;

    @Column(name= "ongoing_parking")
    private Boolean ongoingParking;

    @ManyToOne
    @JoinColumn(name="car_id", referencedColumnName = "id")
    private Car car;

    @ManyToOne
    private ParkingLocation parkingLocation;

}

