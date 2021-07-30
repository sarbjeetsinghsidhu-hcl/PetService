package com.petservice.controller;

import com.petservice.dto.EditPetDTO;
import com.petservice.dto.PetDetailsRequestDTO;
import com.petservice.dto.PetDetailsResponseDTO;
import com.petservice.service.PetService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.petservice.dto.PetDetailsDTO;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@Slf4j
@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private PetService petService;
	
	@PostMapping("/{adminId}/pets/")
	@ApiOperation(value = "This method is used to add pets")
	public ResponseEntity<PetDetailsResponseDTO> addPet(@PathVariable("adminId") String adminId, @RequestBody PetDetailsRequestDTO dto){
		log.info("pet added "+ dto.getPetName());
		return  new ResponseEntity<>(petService.addPets(adminId,dto),CREATED);
	}


	@PutMapping("/{adminId}/pets/")
	@ApiOperation(value = "This method is used to edit pets")
	public ResponseEntity<PetDetailsResponseDTO> editPet(@PathVariable("adminId") String adminId,@RequestBody EditPetDTO dto){
		log.info("pet updated "+ dto.getPetName());
		return  new ResponseEntity<>(petService.editPet(adminId,dto),OK);
	}
}
