package com.petservice.exception;

public class AuthorizationException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 * @param message
	 */
	public AuthorizationException(String message) {
		super(message);
	}
}
