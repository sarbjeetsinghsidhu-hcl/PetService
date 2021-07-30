package com.petservice.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="User_Details")
@Builder
@Data
public class UserDetails implements Serializable {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "userId",unique = true)
	private String userId;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "user_role")
	private Character userRole;

	@OneToMany(mappedBy = "userDetails")
	private List<PetOrderDetails> petOrderDetails;

	public UserDetails() {
	}

	public UserDetails(Long id, String userId, String userName, String password,
					   Character userRole, List<PetOrderDetails> petOrderDetails) {
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.userRole = userRole;
		this.petOrderDetails = petOrderDetails;
	}
}
