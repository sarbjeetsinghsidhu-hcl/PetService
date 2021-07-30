package com.petservice.exception;

public class PetNotFound extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PetNotFound(String message) {
		super(message);
	}

}
