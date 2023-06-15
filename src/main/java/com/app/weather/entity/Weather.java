package com.app.weather.entity;

import org.springframework.stereotype.Component;

@Component
public class Weather {

	public String city;
	
	public String country;
	
	public Double temperature;
	
	public Integer humidity;
	
	public WeatherCondition condition;

	public Weather() {
		
	}

	public Weather(String city,String country, Double temperature, Integer humidity, WeatherCondition condition) {
		super();
		this.city = city;
		this.temperature = temperature;
		this.humidity = humidity;
		this.condition = condition;
		this.country = country;
	}
	

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getTemperature() {
		return temperature;
	}

	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}

	public Integer getHumidity() {
		return humidity;
	}

	public void setHumidity(Integer humidity) {
		this.humidity = humidity;
	}

	public WeatherCondition getCondition() {
		return condition;
	}

	public void setCondition(WeatherCondition condition) {
		this.condition = condition;
	}
	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Weather [city=" + city + ", temperature=" + temperature + ", humidity=" + humidity + ", condition="
				+ condition + "]";
	}
	
	
	
	

	

}
