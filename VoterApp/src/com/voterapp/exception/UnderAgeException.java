package com.voterapp.exception;

public class UnderAgeException extends InValidVoterException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnderAgeException() {
		super();

	}

	public UnderAgeException(String message) {
		super(message);

	}

}
