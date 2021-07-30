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
@Table(name="pet_details")
@Builder
@Data
public class PetDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "pet_Id")
	private String petId;	
	
	@Column(name = "pet_name")
	private String petName;
	
	@Column(name = "pet_category")
	private String petCategory;
	
	@Column(name = "pet_age")
	private Long petAge;
	
	
	@Column(name = "pet_availability")
	private int petAvailibility;
	
	@Column(name = "pet_price")
	private Double petPrice;

	@OneToMany(mappedBy="petDetails")
	private List<PetOrderDetails> petOrderDetails;

	public PetDetails(Integer id, String petId, String petName, String petCategory, Long petAge, int petAvailibility, Double petPrice, List<PetOrderDetails> petOrderDetails) {
		this.id = id;
		this.petId = petId;
		this.petName = petName;
		this.petCategory = petCategory;
		this.petAge = petAge;
		this.petAvailibility = petAvailibility;
		this.petPrice = petPrice;
		this.petOrderDetails = petOrderDetails;
	}

	public PetDetails() {
	}
}