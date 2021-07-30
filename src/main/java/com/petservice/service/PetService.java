package com.petservice.service;

import com.petservice.dto.PetDetailsDTO;

/**
 * 
 * @author Team.
 *
 */
public interface Service {

	/**
	 * 
	 * @param petId
	 * @return
	 */
	public PetDetailsDTO getPetDetail(String petId);
	
	/**
	 * PetDetails for a user id.
	 * @param userId
	 * @return
	 */
	public PetDetailsDTO getPetDetails(String userId);
	
	/**
	 * Return all the pet details in the system.
	 * @return
	 */
	public PetDetailsDTO getPetDetails();
}
