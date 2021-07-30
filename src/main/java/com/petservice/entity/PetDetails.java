package com.petservice.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

import com.petservice.PetStatus;

@Entity
@Table(name="pet_details")
@Builder
@Data
public class PetDetails implements Serializable {

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

}