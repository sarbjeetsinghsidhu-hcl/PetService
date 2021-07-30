package com.petservice.service;

import java.util.List;

import com.petservice.dto.PetDetailsDTO;

/**
 * 
 * @author Team.
 *
 */
public interface PetService {

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
	public PetDetailsDTO getPetDetails(String userId,int page);
	
	/**
	 * Return all the pet details in the system.
	 * @return
	 */
	public PetDetailsDTO getPetDetails();
	
	/**
	 * 
	 * @param page
	 * @return
	 */
	public List<PetDetailsDTO> getPets(int page);
}
