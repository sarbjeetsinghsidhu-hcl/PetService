package com.petservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Team-2
 *
 */
@RestController
@RequestMapping("/api/v1/pets")
public class PetController {

	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(PetController.class);
	
	@GetMapping("/")
	public List<Object> getPets(@RequestParam("page") Optional<Integer> page){
		return null;
	}
	
	@GetMapping("/{petId}")
	public List<Object> getPet(@PathVariable("petId") String petId){
		return null;
	}
	
	@PostMapping("order")
	public void purchasePet() {
		
	}
	
}
