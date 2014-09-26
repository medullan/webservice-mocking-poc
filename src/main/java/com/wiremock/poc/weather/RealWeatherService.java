package com.wiremock.poc.weather;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("production")
public class RealWeatherService implements WeatherService {

	String endPoint = "http://api.openweathermap.org/data/2.5/weather?lat=35&lon=139";
	
	@Override
	public String getEndPoint() {
		// TODO Auto-generated method stub
		return endPoint;
	}

	public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

}
