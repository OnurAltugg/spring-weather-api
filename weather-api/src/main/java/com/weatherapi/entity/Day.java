package com.weatherapi.entity;

import lombok.Data;

@Data
public class Day {
	private double maxtemp_c;
	private double maxtemp_f;
	private double mintemp_c;
	private double mintemp_f;
	private double avgtemp_c;
	private double avgtemp_f;
}
