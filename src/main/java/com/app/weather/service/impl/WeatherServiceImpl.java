package com.app.weather.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.app.weather.entity.Weather;
import com.app.weather.entity.WeatherCondition;
import com.app.weather.service.WeatherService;


@Service
public class WeatherServiceImpl implements WeatherService{

	@Value("${weather.api.key}")
    private String apiKey;
	
	@Override
	public Weather getWeatherDetailByCity(String city) {
		
		String apiUrl = "https://api.weatherapi.com/v1/current.json?key=" + apiKey + "&q=" + city;
		
		System.out.println("apiKey :: "+apiKey);
		System.out.println("apiUrl :: "+apiUrl);
		RestTemplate restTemplate = new RestTemplate();
		Object weatherdetail = restTemplate.getForObject(apiUrl, Object.class);
		Map<String,Object> map;
		System.out.println(weatherdetail);
		map =new HashMap<>();
		map.put("weather",weatherdetail );
		
		
		Object name = (String)((Map<String, Object>) ((Map<String, Object>) map.get("weather")).get("location")).get("name");
		Object country = (String)((Map<String, Object>) ((Map<String, Object>) map.get("weather")).get("location")).get("country");
		Object temperatureInCel = (Double)((Map<String, Object>) ((Map<String, Object>) map.get("weather")).get("current")).get("temp_c");
		Object condition = (Map<String, Object>)((Map<String, Object>) ((Map<String, Object>) map.get("weather")).get("current")).get("condition");
		Object humidity = (Integer)((Map<String, Object>) ((Map<String, Object>) map.get("weather")).get("current")).get("humidity");
		
		System.out.println(condition);
		
		map.clear();
		map = (Map<String, Object>) condition;
		map.put("text", map.get("text"));
		map.put("icon", map.get("icon"));
		map.put("code", map.get("code"));
		
		Weather weather = null;
		
		if(!map.isEmpty()) {
			
			WeatherCondition weatherCondition =new WeatherCondition();
			weatherCondition.setConditionCode((Integer) map.get("code"));
			weatherCondition.setIconUrl((String) map.get("icon"));
			weatherCondition.setWeatherConditontype((String) map.get("text"));
			
			weather = new Weather();
			weather.setCity((String) name);
			weather.setCountry((String)country);
			weather.setTemperature((Double) temperatureInCel);
			weather.setHumidity((Integer) humidity);
			weather.setCondition(weatherCondition);
		}	
		return weather;
	}
	
	

}
