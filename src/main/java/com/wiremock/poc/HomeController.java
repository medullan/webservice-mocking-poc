package com.wiremock.poc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.wiremock.poc.weather.WeatherService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private WeatherService weatherService;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@Autowired
	public void setWeatherService(WeatherService weatherService) {
		this.weatherService = weatherService;
	}



	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		String environment = System.getProperty("spring.profiles.active");
        Client client = Client.create();
        Object weatherObject = null;
        WebResource webResource = client.resource(weatherService.getEndPoint());
    	ClientResponse clientResponse = webResource.get(ClientResponse.class);
        
    	if(clientResponse.getStatus() == 200){
        	weatherObject = clientResponse.getEntity(String.class);
        }

        model.addAttribute("weatherObject", weatherObject);
    	
		return "home";
	}
}
