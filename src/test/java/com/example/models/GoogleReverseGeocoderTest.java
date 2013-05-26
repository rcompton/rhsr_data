package com.example.models;

import org.junit.Test;

import com.example.geocoding.GoogleReverseGeocoder;

public class GoogleReverseGeocoderTest {
	
	@Test
	public void testGoogleReverseGeocoderPalms(){
		GoogleReverseGeocoder revG = new GoogleReverseGeocoder();
		System.out.println(revG.reverseGeocode("Palms, Los Angeles, California").toString());
	}

}
