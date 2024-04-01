package com.weatherapi.entity;

import lombok.Data;

@Data
public class Current {
	private String last_updated;
	private double temp_c;
	private double temp_f;
	private double wind_mph;
	private double wind_kph;
	private double wind_degree;
	private String wind_dir;
	private double pressure_mb;
	private double pressure_in;
	private int humidity;
	private int cloud;
	private double feelslike_c;
	private double feelslike_f;
	private double vis_km;
	private double vis_miles;
	private double uv;
	private double gust_mph;
	private double gust_kph;
}
