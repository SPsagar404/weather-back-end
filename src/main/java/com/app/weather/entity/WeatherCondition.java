package com.app.weather.entity;

import org.springframework.stereotype.Component;

@Component
public class WeatherCondition {

	public String weatherConditontype;
	
	public String iconUrl;
	
	public  Integer conditionCode;
	
	

	public WeatherCondition() {
		
	}

	public WeatherCondition(String weatherConditontype, String iconUrl, Integer conditionCode) {
		super();
		this.weatherConditontype = weatherConditontype;
		this.iconUrl = iconUrl;
		this.conditionCode = conditionCode;
	}

	public String getWeatherConditontype() {
		return weatherConditontype;
	}

	public void setWeatherConditontype(String weatherConditontype) {
		this.weatherConditontype = weatherConditontype;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	public Integer getConditionCode() {
		return conditionCode;
	}

	public void setConditionCode(Integer conditionCode) {
		this.conditionCode = conditionCode;
	}

	@Override
	public String toString() {
		return "WeatherCondition [weatherConditontype=" + weatherConditontype + ", iconUrl=" + iconUrl
				+ ", conditionCode=" + conditionCode + "]";
	}
	
	
	
	
	
	

}
