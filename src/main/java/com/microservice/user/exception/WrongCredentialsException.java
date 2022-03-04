package com.microservice.user.exception;

public class WrongCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	public WrongCredentialsException() {
		
	}

	public WrongCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public WrongCredentialsException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public WrongCredentialsException(String message) {
		super(message);
		
	}

	public WrongCredentialsException(Throwable cause) {
		super(cause);
		
	}
	

}
