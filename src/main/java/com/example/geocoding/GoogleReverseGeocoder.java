package com.example.geocoding;

import java.util.List;

import com.example.models.Location;
import com.google.code.geocoder.Geocoder;
import com.google.code.geocoder.GeocoderRequestBuilder;
import com.google.code.geocoder.model.GeocodeResponse;
import com.google.code.geocoder.model.GeocoderRequest;
import com.google.code.geocoder.model.GeocoderResult;
import com.google.code.geocoder.model.GeocoderStatus;

/**
 * 
 * Allows me to map city names to Locations
 * queries Google's reverse geocoding API
 * 
 * @author ryan
 *
 */
public class GoogleReverseGeocoder {
	
	private Geocoder geocoder;
		
	public GoogleReverseGeocoder() {
		super();
		this.geocoder = new Geocoder();
	}

	public Location reverseGeocode(String cityName){
		
		GeocoderRequest geocoderRequest = new GeocoderRequestBuilder().setAddress(cityName).setLanguage("en").getGeocoderRequest();
		GeocodeResponse geocoderResponse = geocoder.geocode(geocoderRequest);
		
		if(geocoderResponse.getStatus().equals( GeocoderStatus.OK)){
			List<GeocoderResult> geocoderResults = geocoderResponse.getResults();
			//use the first hit only
			try{
				GeocoderResult geocoderResult = geocoderResults.get(0);
				double lat = geocoderResult.getGeometry().getLocation().getLat().doubleValue();
				double lng = geocoderResult.getGeometry().getLocation().getLng().doubleValue();
				return new Location(lat,lng);
				
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}	
		return null;
	}
			
	
	public static void main(String args[]){
		GoogleReverseGeocoder revG = new GoogleReverseGeocoder();
		System.out.println(revG.reverseGeocode("Palms, Los Angeles, California").toString());
	}

}
