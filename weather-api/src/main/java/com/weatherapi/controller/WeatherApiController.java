package com.weatherapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.weatherapi.entity.ForecastWeather;
import com.weatherapi.entity.Weather;
import com.weatherapi.service.WeatherApiService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class WeatherApiController {
	
    private final WeatherApiService weatherApiService;	
    
    
    //Provides the current weather forecast for the specified city.
	@GetMapping("/weather/{cityName}")
	public ResponseEntity<Weather> getCurrentWeather(@PathVariable String cityName){
		Weather weather = weatherApiService.getCurrentWeather(cityName);
		return new ResponseEntity<>(weather, HttpStatus.OK);
	}
	
	//Provides the weather forecast for the specified city for the next n days.
	@GetMapping("/weather/{cityName}/{days}")
	public ResponseEntity<ForecastWeather> getForecastWeatherForDays(@PathVariable String cityName, @PathVariable int days){
	    ForecastWeather forecastWeather = weatherApiService.getForecastWeather(cityName, days);
	    if(days < 1 || days > 10) {
	    	throw new IllegalArgumentException("Days should be between 1 and 10");
	    }
	    return new ResponseEntity<>(forecastWeather, HttpStatus.OK);
	}

	
}
