package com.weatherapi.entity;

import lombok.Data;

@Data
public class Weather {
	private Location location;
	private Current current;
}
