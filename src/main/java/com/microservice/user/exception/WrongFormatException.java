package com.microservice.user.exception;

public class WrongFormatException extends Exception {
	//private static final long serialVersionUID = 1L;

	public WrongFormatException() {

	}

	public WrongFormatException(String message, Throwable cause, boolean enableSuppression,
								boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);

	}

	public WrongFormatException(String message, Throwable cause) {
		super(message, cause);

	}



	public WrongFormatException(String message) {
		super(message);

	}

	public WrongFormatException(Throwable cause) {
		super(cause);

	}

}
