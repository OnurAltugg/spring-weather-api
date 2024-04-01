package com.weatherapi.service;

import com.weatherapi.entity.ForecastWeather;
import com.weatherapi.entity.Weather;

public interface WeatherApiService {
	
	public Weather getCurrentWeather(String city);
	
	public ForecastWeather getForecastWeather(String city, int days);

}
