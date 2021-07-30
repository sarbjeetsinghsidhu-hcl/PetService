package com.petservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petservice.entity.PetOrderDetails;
import com.petservice.entity.UserDetails;

public interface OrderRepository extends JpaRepository<PetOrderDetails,Long> {
	
	/**
	 * 
	 * @param userDetails
	 * @return
	 */
	public Optional<List<PetOrderDetails>> findByUserDetails(UserDetails userDetails);
}
