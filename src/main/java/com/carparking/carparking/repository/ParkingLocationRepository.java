package com.carparking.carparking.repository;

import com.carparking.carparking.entity.ParkingLocation;
import org.geolatte.geom.G2D;
import org.geolatte.geom.Geometry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParkingLocationRepository extends ListCrudRepository<ParkingLocation, Long> {
    //fylla på med querys

    @Query("""
            SELECT p FROM ParkingLocation p WHERE WITHIN(p.coordinate, :geoarea) = true
            """)
    List<ParkingLocation> filterOnArea(@Param("geoarea") Geometry<G2D> geoArea);

}
