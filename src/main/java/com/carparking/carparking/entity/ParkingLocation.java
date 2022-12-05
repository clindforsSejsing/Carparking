package com.carparking.carparking.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Point;

import java.util.ArrayList;
import java.util.List;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;

@Entity
@Table(name = "parking_location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParkingLocation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Point<G2D> coordinates;
    private String name;
    @Transient
    private String longitude;
    @Transient
    private String latitude;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE},fetch =FetchType.EAGER)
    @JoinColumn(name="parking_location_id",referencedColumnName = "id",nullable = false,insertable=false, updatable=false)
    private List<ParkingTime> parkinglocations = new ArrayList<>();

    public void setLatitude(String latitude) {
        this.latitude = latitude;
        if(longitude != null) {
            setCoordinates(point(WGS84,g(Double.parseDouble(longitude), Double.parseDouble(latitude))));
        }
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
        if(latitude != null) {
            setCoordinates(point(WGS84,g(Double.parseDouble(longitude), Double.parseDouble(latitude))));
        }
    }
}
