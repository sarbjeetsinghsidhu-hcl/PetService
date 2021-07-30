package com.petservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Pet_Order_Details")
public class PetOrderDetails {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "pet_id", referencedColumnName = "pet_id")
	private PetDetails petDetails;
	
	@ManyToOne(fetch = FetchType.LAZY)	
	@JoinColumn(name = "userId", referencedColumnName = "userId")	
	private UserDetails userDetails;
	
	@Column(name="purchased_on")
	private Date purchasedOn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PetDetails getPetDetails() {
		return petDetails;
	}

	public void setPetDetails(PetDetails petDetails) {
		this.petDetails = petDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public Date getPurchasedOn() {
		return purchasedOn;
	}

	public void setPurchasedOn(Date purchasedOn) {
		this.purchasedOn = purchasedOn;
	}
	
	
	
}
