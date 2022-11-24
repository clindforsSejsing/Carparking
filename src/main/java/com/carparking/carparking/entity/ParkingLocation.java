package com.carparking.carparking.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

@Entity
public class ParkingLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Point<G2D> coordinate;

    public ParkingLocation() {

    }

    public Point<G2D> getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point<G2D> coordinate) {
        this.coordinate = coordinate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ParkingLocation(Long id, Point<G2D> coordinate) {
        this.id = id;
        this.coordinate = coordinate;
    }

}
