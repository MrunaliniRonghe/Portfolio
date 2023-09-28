package com.attempt3.apis.exception;

public class ConnectionNotFoundException extends RuntimeException{

	public ConnectionNotFoundException(String message) {
		super(message);
	}
	
	public ConnectionNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
