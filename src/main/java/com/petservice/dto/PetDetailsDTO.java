package com.petservice.dto;

public class PetDetailsDTO {

	private String petId;

	private String petName;

	private String petCategory;

	private Long petAge;

	private String petAvailibility;

	private Double petPrice;

	/**
	 * 
	 */
	public PetDetailsDTO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param petId
	 * @param petName
	 * @param petCategory
	 * @param petAge
	 * @param petAvailibility
	 * @param petPrice
	 */
	public PetDetailsDTO(String petId, String petName, String petCategory, Long petAge, String petAvailibility,
			Double petPrice) {
		super();
		this.petId = petId;
		this.petName = petName;
		this.petCategory = petCategory;
		this.petAge = petAge;
		this.petAvailibility = petAvailibility;
		this.petPrice = petPrice;
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

	@Override
	public String toString() {
		return "PetDetailsDTO [petId=" + petId + ", petName=" + petName + ", petCategory=" + petCategory + ", petAge="
				+ petAge + ", petAvailibility=" + petAvailibility + ", petPrice=" + petPrice + "]";
	}
}