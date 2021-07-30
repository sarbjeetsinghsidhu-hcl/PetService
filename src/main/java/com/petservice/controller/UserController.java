package com.petservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petservice.dto.PetDetailsDTO;
import com.petservice.service.PetService;
import com.petservice.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private PetService petService;
	/**
	 * 
	 * @param userId
	 * @param page
	 * @return
	 */
	@RequestMapping("{userId}/pets")
	public List<PetDetailsDTO> getPetDetails(@PathVariable("userId") String userId,
			@RequestParam("page") Optional<Integer> page) {
		LOGGER.info("Getting Pets");
		return petService.getPetDetails(userId,page.orElse(0));
		return null;
	}
}
