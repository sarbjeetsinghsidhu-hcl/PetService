package com.petservice.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User_Details")
public class UserDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "userId")
	private String userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "user_role")
	private Character userRole;

	@OneToMany(mappedBy = "userDetails")
	private List<PetOrderDetails> petOrderDetails;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public List<PetOrderDetails> getPetOrderDetails() {
		return petOrderDetails;
	}

	public void setPetOrderDetails(List<PetOrderDetails> petOrderDetails) {
		this.petOrderDetails = petOrderDetails;
	}
}
