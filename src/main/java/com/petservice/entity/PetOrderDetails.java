package com.petservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="Pet_Order_Details")
@Builder
@Data
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
	private LocalDate purchasedOn;

	public PetOrderDetails(Long id, PetDetails petDetails, UserDetails userDetails, LocalDate purchasedOn) {
		this.id = id;
		this.petDetails = petDetails;
		this.userDetails = userDetails;
		this.purchasedOn = purchasedOn;
	}

	public PetOrderDetails() {
	}
}
