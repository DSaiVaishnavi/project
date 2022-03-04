package com.microservice.user.exception;

public class ShowException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ShowException() {
		super();
		
	}

	public ShowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public ShowException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ShowException(String message) {
		super(message);
	
	}

	public ShowException(Throwable cause) {
		super(cause);
		
	}

}
