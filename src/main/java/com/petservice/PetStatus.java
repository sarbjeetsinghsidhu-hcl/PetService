package com.petservice;

public enum PetStatus {

	SOLD(0),AVAILABLE(1);
	
	private int value;

	private PetStatus(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
