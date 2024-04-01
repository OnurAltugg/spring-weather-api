package com.weatherapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.weatherapi.entity.ForecastWeather;
import com.weatherapi.entity.Weather;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WeatherApiServiceImpl implements WeatherApiService {
	
	private final RestTemplate restTemplate;
	
	@Autowired
	private HttpHeaders httpHeaders;
	
	private static final String WEATHER_API_URL = "http://api.weatherapi.com/v1/current.json";
	private static final String FORECAST_API_URL = "http://api.weatherapi.com/v1/forecast.json";
	private static final String API_KEY = "a93632375add4dbb868154942240104";
	
	@Override
	public Weather getCurrentWeather(String city) {
		httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		ResponseEntity<Weather> response = restTemplate.exchange(
				WEATHER_API_URL 
				+ "?key=" + API_KEY 
				+ "&q=" + city, 
				org.springframework.http.HttpMethod.GET, entity, Weather.class
				);;
		return response.getBody();
	}

	@Override
	public ForecastWeather getForecastWeather(String city, int days) {
		httpHeaders.setAccept(List.of(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
		ResponseEntity<ForecastWeather> response = restTemplate.exchange(
				FORECAST_API_URL 
				+ "?key=" + API_KEY 
				+ "&q=" + city
				+ "&days=" + days,
				org.springframework.http.HttpMethod.GET, entity, ForecastWeather.class
				);;
		return response.getBody();
	}

}
