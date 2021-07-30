package com.petservice;

public enum Role {

	ADMIN('A'), USER('U');

	private char value;

	private Role(char value) {
		this.value = value;
	}
	
	public char getValue() {
		return value;
	}
}
