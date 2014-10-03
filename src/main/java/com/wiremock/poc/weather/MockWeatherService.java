package com.wiremock.poc.weather;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("local")
public class MockWeatherService implements WeatherService {

	String endPoint = "http://localhost:9999/weather";
	
	@Override
	public String getEndPoint() {
		// TODO Auto-generated method stub
		return endPoint;
	}
	
	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

}
