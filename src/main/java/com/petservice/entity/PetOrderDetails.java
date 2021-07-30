package com.petservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Pet_Order_Details")
public class PetOrderDetails {

	@Id
	private Long id;
}
