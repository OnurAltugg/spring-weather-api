package com.weatherapi.entity;

import java.util.List;

import lombok.Data;

@Data
public class Forecast {
	private List<ForecastDay> forecastday;
}
