package com.petservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="pet_details")
@Builder
@Data
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

}