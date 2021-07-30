package com.petservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@Table(name="Pet_Order_Details")
@Builder
@Data
public class PetOrderDetails {

	@Id
	private Long id;
}
