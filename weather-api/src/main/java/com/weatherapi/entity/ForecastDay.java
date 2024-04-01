package com.weatherapi.entity;

import lombok.Data;

@Data
public class ForecastDay {
	private String date;
	private Day day;
	private Astro astro;
}
