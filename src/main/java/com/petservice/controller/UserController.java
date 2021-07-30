package com.petservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petservice.dto.PetDetailsDTO;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	/**
	 * 
	 * @param userId
	 * @param page
	 * @return
	 */
	@RequestMapping("{userId}/pets")
	public List<PetDetailsDTO> getPetDetails(@PathVariable("userId") String userId,
			@RequestParam("page") Optional<Integer> page) {
		return null;
	}
}
