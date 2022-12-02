package com.carparking.carparking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

}