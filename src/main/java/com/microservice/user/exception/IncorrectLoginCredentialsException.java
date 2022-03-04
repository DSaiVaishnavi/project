package com.voterservice.voter.exceptions;

public class IncorrectLoginCredentialsException extends Exception {
	public IncorrectLoginCredentialsException(String msg) {
		super(msg);
	}
}
