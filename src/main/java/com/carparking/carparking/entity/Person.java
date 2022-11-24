package com.carparking.carparking.entity;
// fortsätta bygga api hjälpmetoder
//list eller set (set = inga upprepningar).
//kolla dokumentation för queryfrågor (lektion 14/11  kl 1.33) ,  manttomany, 2.21- querys
//TODO:
// 1.Skriva klart hur tabellerna ska kopplas ihop[x]
//2. adda hårdkodad data till bla locations []
//3. skriv querys för att få ut relevant data / post/ patch/ put []
//4. skriv dokumentation för API i readme.md[]
//5. adda javadocs, städa koden[]



import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (length= 50)
    private String name;
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name="person_id")
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
