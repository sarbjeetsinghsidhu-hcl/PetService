package com.petservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pet_details")
public class PetDetails {

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
	private String petAvailibility;
	
	@Column(name = "pet_price")
	private Double petPrice;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPetId() {
		return petId;
	}

	public void setPetId(String petId) {
		this.petId = petId;
	}

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getPetCategory() {
		return petCategory;
	}

	public void setPetCategory(String petCategory) {
		this.petCategory = petCategory;
	}

	public Long getPetAge() {
		return petAge;
	}

	public void setPetAge(Long petAge) {
		this.petAge = petAge;
	}

	public String getPetAvailibility() {
		return petAvailibility;
	}

	public void setPetAvailibility(String petAvailibility) {
		this.petAvailibility = petAvailibility;
	}

	public Double getPetPrice() {
		return petPrice;
	}

	public void setPetPrice(Double petPrice) {
		this.petPrice = petPrice;
	}
}