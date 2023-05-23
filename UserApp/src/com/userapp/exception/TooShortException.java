package com.userapp.exception;

public class TooShortException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TooShortException() {
		super();
	}

	public TooShortException(String message) {
		super(message);
	}

}
