package com.app.weather.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.weather.entity.Weather;
import com.app.weather.service.WeatherService;


@CrossOrigin(value = "*")
@RestController
public class WeatherRestController {

	@Autowired
	private WeatherService weatherService;
	
	 @GetMapping("/")
	    public ResponseEntity<Weather> getWeatherByCity(@RequestParam(value = "city", defaultValue = "pune") String city) {
		 
		 Weather weatherDetailByCity = weatherService.getWeatherDetailByCity(city);
		 System.out.println("City :: "+weatherDetailByCity);
	        return new ResponseEntity<Weather>(weatherDetailByCity, HttpStatus.OK);
	    }
	
	
}
