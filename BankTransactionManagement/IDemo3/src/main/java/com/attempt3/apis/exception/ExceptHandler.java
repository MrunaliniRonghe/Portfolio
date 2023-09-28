package com.attempt3.apis.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptHandler {

	@ExceptionHandler(value = {UserNotFoundException.class})
	public ResponseEntity<Object> handleCVNotFoundException(UserNotFoundException cvNotFound){
		Exception exception = new Exception(
				cvNotFound.getMessage(),
				cvNotFound.getCause(),
				HttpStatus.NOT_FOUND
		);
		
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler (value = {ConnectionNotFoundException.class})
	public ResponseEntity<Object> handleConnectionNotFoundException(ConnectionNotFoundException con){
		Exception exception = new Exception(
				con.getMessage(),
				con.getCause(),
				HttpStatus.INTERNAL_SERVER_ERROR
		);
		
		return new ResponseEntity<>(exception, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
