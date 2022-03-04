package com.voterservice.voter.exceptions;

public class IncorrectCredentialsException extends Exception {

	private static final long serialVersionUID = 1L;

	public IncorrectCredentialsException(String msg) {
		super(msg);
	}
}
