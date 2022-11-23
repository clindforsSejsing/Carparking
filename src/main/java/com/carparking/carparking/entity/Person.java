package com.carparking.carparking.entity;
//lektion 14/11  kl 1.25 fortsätta bygga api
//sätta in env.key- commita kod

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

//id som auto_inc och som sätts som individuellt av hibernate
//namn
//foreigner som kopplar samman med parkeringstid
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length= 50)
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="car_id")
    private Set<Car> cars = new HashSet<>();
   /*  @OneToMany
    Set<Car> cars;*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Car> getCars() {
        return cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
