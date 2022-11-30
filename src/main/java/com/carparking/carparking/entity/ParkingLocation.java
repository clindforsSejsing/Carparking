package com.carparking.carparking.entity;

import jakarta.persistence.*;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Entity
public class ParkingLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Point<G2D> coordinates;

    private String name;

  /*  @JsonIgnore*/
    @Transient
    private String longitude;

   /* @JsonIgnore*/
    @Transient
    private String latitude;

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
        if(longitude != null) {
            setCoordinates(point(WGS84,g(Double.parseDouble(longitude), Double.parseDouble(latitude))));
        }
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
        if(latitude != null) {
            setCoordinates(point(WGS84,g(Double.parseDouble(longitude), Double.parseDouble(latitude))));
        }
    }
    /*@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch =FetchType.EAGER)
    @JoinColumn(name="location_id",nullable = false)
    private List<ParkingTime> parkingtimes = new ArrayList<>();*/

 /*   public List<ParkingTime> getParkingtimes() {
        return parkingtimes;
    }

    public void setParkingtimes(List<ParkingTime> parkingtimes) {
        this.parkingtimes = parkingtimes;
    }*/

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Point<G2D> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Point<G2D> coordinate) {
        this.coordinates = coordinate;
    }

    public ParkingLocation() {

    }



    public ParkingLocation( String name,Point<G2D> coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /*public void setParkingtime(ParkingTime parkingTime) {
    }*/

  /*  @Override
    public String toString() {
        return "ParkingLocation{" +
                "coordinate=" + coordinates +
                ", name='" + name + '\'' +
                '}';
    }*/


}

