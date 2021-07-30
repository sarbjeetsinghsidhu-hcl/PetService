package com.petservice.exception;

public class PetSoldOutException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public PetSoldOutException(String message) {
		super(message);
	}
}