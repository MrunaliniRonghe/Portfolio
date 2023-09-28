package com.attempt3.apis.exception;

public class UserNotFoundException extends RuntimeException{

	public UserNotFoundException(String message) {
		super(message);
	}
	public UserNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
