package com.petservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.petservice.entity.PetDetails;

@Repository
public interface PetDetailsRepository extends JpaRepository<PetDetails, Integer> {

	/**
	 * 
	 * @param petId
	 * @return
	 */
	public Optional<PetDetails> findByPetId(String petId);
}
