package com.carparking.carparking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "car")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length= 25, nullable = false)
    private String reg;

    @ManyToOne(optional = false)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    private Person person;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch =FetchType.EAGER)
    @JoinColumn(name="car_id",referencedColumnName = "id")
    private List<ParkingTime> carsParked = new ArrayList<>();

}