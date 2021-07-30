package com.petservice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.petservice.dto.PetDetailsDTO;
import com.petservice.dto.UserDTO;
import com.petservice.entity.PetDetails;
import com.petservice.entity.UserDetails;
import com.petservice.exception.PetNotFound;
import com.petservice.repository.PetDetailsRepository;
import com.petservice.repository.UserDetailsRepository;
import com.petservice.service.PetService;

@Service
public class PetServiceImpl implements PetService {

	/**
	 * 
	 */
	@Autowired
	private PetDetailsRepository petDetailsRepository;
	
	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public PetDetailsDTO getPetDetails(String userId,int page) {
		Page<UserDetails> users = userDetailsRepository.findByUserId(userId, PageRequest.of(page, 5, Sort.Direction.ASC, "petName"));
		if(users.isEmpty()) {
			throw new PetNotFound("Not pet's availabe.");
		}
		users.getContent().forEach(user ->{
			
			
		});
		return null;
	}

	@Override
	public List<PetDetailsDTO> getPets(int page) {
		List<PetDetailsDTO> result = new ArrayList<PetDetailsDTO>();
		Page<PetDetails> pets = petDetailsRepository.findAll(PageRequest.of(page, 5, Sort.Direction.ASC, "petName"));
		if (pets.isEmpty()) {
			throw new PetNotFound("Not pet's availabe at this moment.");
		}
		pets.getContent().forEach(pet -> {
			PetDetailsDTO petDetails = new PetDetailsDTO(pet.getPetId(), pet.getPetName(), pet.getPetCategory(),
					pet.getPetAge(), pet.getPetAvailibility(), pet.getPetPrice());
			result.add(petDetails);
		});
		return result;
	}

	/*
	 * (non-Javadoc)
	 * @see com.petservice.service.PetService#getPetDetail(java.lang.String)
	 */
	@Override
	public PetDetailsDTO getPetDetail(String petId) {
		PetDetailsDTO petDto = null;
		Optional<PetDetails> pet =  petDetailsRepository.findByPetId(petId);		
		if(pet.isPresent()) {
			petDto = mapToDto(pet.get());
		}else {
			throw new PetNotFound(String.format("Pet Details for pet id {%s} not found.",petId));
		}
		return petDto;
	}

	@Override
	public PetDetailsDTO getPetDetails() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private PetDetailsDTO mapToDto(PetDetails pet) {
		return new PetDetailsDTO(pet.getPetId(), pet.getPetName(), pet.getPetCategory(),
				pet.getPetAge(), pet.getPetAvailibility(), pet.getPetPrice());
	}
}
