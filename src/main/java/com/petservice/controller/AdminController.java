package com.petservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservice.dto.PetDetailsDTO;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	@PostMapping("/{adminId}/pets/")	
	public void addPet(@PathVariable("adminId") String adminId, @RequestBody PetDetailsDTO petDetails) {
		
	}
	
	@PutMapping("/{adminId}/pets/")
	public void editPet(@PathVariable("adminId") String adminId, @RequestBody PetDetailsDTO petDetails) {
		
	}
}
