package com.carparking.carparking.entity;
// fortsätta bygga api hjälpmetoder
//list eller set (set = inga upprepningar).
//kolla dokumentation för queryfrågor (lektion 14/11  kl 1.33) ,  manttomany, 2.21- querys
//lektion 17 också
//TODO:
// 1.Skriva klart hur tabellerna ska kopplas ihop[x]
//2. adda hårdkodad data till bla locations, läsa om geolatte, fixa kodimplementationen i bean [x]
//3. skriv querys för att få ut relevant data / post/ patch/ put []
//4. metoder för filtrering? adda i servicefiler alt repository []
//5. skriv dokumentation för API i readme.md[]
//6. adda javadocs, städa koden[]


//OneToMany- Lazy
//ManyToOne- EAGER
//ManyToMany- Lazy
//OneToOne: Eager

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (length= 50, nullable = false)
    private String name;

    public Person() {
    }

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch =FetchType.EAGER)
    @JoinColumn(name="person_id", referencedColumnName = "id", nullable = false,insertable=false, updatable=false)
    private List<Car> cars = new ArrayList<>();


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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public void addCar(Car car){
        car.setPerson(this);
        this.cars.add(car);
    }

}
