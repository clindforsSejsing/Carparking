package com.carparking.carparking;

import com.carparking.carparking.entity.ParkingLocation;
import com.carparking.carparking.repository.ParkingLocationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.geolatte.geom.builder.DSL.g;
import static org.geolatte.geom.builder.DSL.point;
import static org.geolatte.geom.crs.CoordinateReferenceSystems.WGS84;


@SpringBootApplication
public class CarparkingApplication {

		public static void main (String[]args){
		SpringApplication.run(CarparkingApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ParkingLocationRepository repo) {
		return args-> {
			var m = new ParkingLocation();
			var sdh = new ParkingLocation();
			var stp = new ParkingLocation();
			var sth = new ParkingLocation();

			m.setName("Malmudden");
			sdh.setName("Södrahamn");
			stp.setName("Stadsparken");
			sth.setName("Storheden");

			m.setCoordinates(point(WGS84,g(65.58319179303082, 22.174553982619024)));
			sdh.setCoordinates(point(WGS84,g(65.58059156767646, 22.153348302875656)));
			stp.setCoordinates(point(WGS84,g(65.58286282081716, 22.146910892762495)));
			sth.setCoordinates(point(WGS84,g(65.618393309073, 22.043127268508332)));


			repo.save(m);
			repo.save(sdh);
			repo.save(stp);
			repo.save(sth);

		};
	}
}