package com.petservice.service;

import java.util.List;

import com.petservice.dto.EditPetDTO;
import com.petservice.dto.PetDetailsDTO;
import com.petservice.dto.PetDetailsRequestDTO;
import com.petservice.dto.PetDetailsResponseDTO;

/**
 * @author Team.
 */
public interface PetService {
	
	/**
	 * PetDetails for a user id.
	 * @param userId
	 * @return
	 */
	public List<PetDetailsDTO> getPetDetails(String userId,int page);
	
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
     * PetDetails for a user id.
     *
     * @return
     */
    public PetDetailsResponseDTO addPets(String adminId, PetDetailsRequestDTO petDetailsRequestDTO);

    /**
     * Adding PetDetails.
     *
     * @param adminId, petDetailsRequestDTO
     * @return
     */

    public PetDetailsResponseDTO editPet(String adminId, EditPetDTO editPetDTO);

}
