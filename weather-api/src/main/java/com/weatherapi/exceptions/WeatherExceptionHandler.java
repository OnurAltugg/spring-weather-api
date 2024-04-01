package com.weatherapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class WeatherExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ExceptionErrorResponse> handleException(HttpClientErrorException exc){
		ExceptionErrorResponse error = new ExceptionErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage("City not found!");
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionErrorResponse> handleException(IllegalArgumentException exc){
		ExceptionErrorResponse error = new ExceptionErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public ResponseEntity<ExceptionErrorResponse> handleException(Exception exc){
		ExceptionErrorResponse error = new ExceptionErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessage(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}
