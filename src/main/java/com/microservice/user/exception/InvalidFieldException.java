package com.voterservice.voter.exceptions;

public class InvalidFieldException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InvalidFieldException(String msg) {
		super(msg);
	}
}
