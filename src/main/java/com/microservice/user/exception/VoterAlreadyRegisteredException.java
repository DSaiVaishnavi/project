package com.microservice.user.exception;

public class VoterAlreadyRegisteredException extends Exception{

	private static final long serialVersionUID = 1L;

	public VoterAlreadyRegisteredException(String msg) {
		super(msg);
	}
}
