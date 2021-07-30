package com.petservice.dto;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class UserDTO {
	
	@NotBlank(message="")
	private String userId;
	
	
	private String userName;
	
	
	private String password;
	
	
	private Character userRole;

	

	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Character getUserRole() {
		return userRole;
	}
	public void setUserRole(Character userRole) {
		this.userRole = userRole;
	}	
}