package com.carparking.carparking.entity;
//1.38 lektion 10/11-22 tom 2.01 (forts härifrån)

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;
//id som auto_inc och som sätts som individuellt av hibernate
//namn
//foreigner som kopplar samman med parkeringstid
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
   // @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    //private Set<Car> cars = new HashSet<>();
   @OneToMany
    List<Car> cars;

    public Person() {

    }
    public Person(String name) {
        this.name = name;
    }

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
        return (Set<Car>) cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = (List<Car>) cars;
    }

}
