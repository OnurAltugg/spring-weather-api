package com.weatherapi.entity;

import lombok.Data;

@Data
public class ForecastWeather {
	private Location location;
	private Current current;
	private Forecast forecast;
}
