package com.example.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.geocoding.GoogleReverseGeocoder;
import com.example.models.Location;

@Path("/reverse-geocoder")
@Produces(MediaType.APPLICATION_JSON)
public class ReverseGeocodeService {

	@GET
	public Location get() {
		return new Location();
	}

	@GET
	@Path("/{city-name}")
	public Location get(@PathParam("city-name") String cityName) {
		//reverse geocode the entered text
		GoogleReverseGeocoder revG = new GoogleReverseGeocoder();
		
		return revG.reverseGeocode(cityName) ;
	}
	
	

}


